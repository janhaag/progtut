import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 * The dithering tool. It uses the Floyd-Steinberg algorithm to reduce color depth.
 *
 * @author Jan Haag
 */
public class FloydSteinbergDitherer {

    /**
     * Dither the given image.
     * @param img The image to dither. It is modified in place.
     * @param colorDepth the color depth to reduce to
     */
    public void dither(BufferedImage img, int colorDepth) {
        if (colorDepth < 0 || colorDepth > 24) {
            throw new IllegalArgumentException("Illegal bit depth.");
        }
        for (int y = img.getMinY(); y < img.getHeight(); y++) {
            for (int x = img.getMinX(); x < img.getWidth(); x++) {
                Color oldP = new Color(img.getRGB(x, y));
                Color newP = getClosestColor(oldP, colorDepth);
                img.setRGB(x, y, newP.getRGB());
                int[] qError = calculateError(oldP, newP);
                distributeError(x, y, img, qError);
            }
        }
    }

    /**
     * Distribute the quantization error for a given pixel.
     * @param x the x-coordinate of the pixel
     * @param y the y coordinate of the pixel
     * @param img the image to work on (modified inplace)
     * @param qError the quantization error to distribute
     */
    private void distributeError(int x, int y, BufferedImage img, int[] qError) {
        if (x < img.getWidth() - 1) {
            Color oldCol = new Color(img.getRGB(x + 1, y));
            Color newCol = calculateNewValue(oldCol, qError, 7.0 / 16.0);
            img.setRGB(x + 1, y, newCol.getRGB());
        }

        if (y < img.getHeight() - 1) {
            Color oldCol;
            Color newCol;
            if (x > img.getMinX()) {
                oldCol = new Color(img.getRGB(x - 1, y + 1));
                newCol = calculateNewValue(oldCol, qError, 3.0 / 16.0);
                img.setRGB(x - 1, y + 1, newCol.getRGB());
            }

            oldCol = new Color(img.getRGB(x, y + 1));
            newCol = calculateNewValue(oldCol, qError, 5.0 / 16.0);
            img.setRGB(x, y + 1, newCol.getRGB());

            if (x < img.getWidth() - 1) {
                oldCol = new Color(img.getRGB(x + 1, y + 1));
                newCol = calculateNewValue(oldCol, qError, 1.0 / 16.0);
                img.setRGB(x + 1, y + 1, newCol.getRGB());
            }
        }
    }

    /**
     * Calculate the new (temporary) value for the given color, applying factor.
     * @param oldCol old pixel color
     * @param qError the quantization error as returned by calculateError
     * @param factor the factor to scale the error with
     * @return a new color for the pixel
     */
    private Color calculateNewValue(Color oldCol, int[] qError, double factor) {
        int r = fixRange((int) Math.round(oldCol.getRed() + factor * qError[0]));
        int g = fixRange((int) Math.round(oldCol.getGreen() + factor * qError[1]));
        int b = fixRange((int) Math.round(oldCol.getBlue() + factor * qError[2]));
        return new Color(r, g, b);
    }

    /**
     * fix a value in the valid 8-byte range for colors.
     * @param i the (possibly out of range) color value
     * @return the color value if ti was in range, else the nearest color in range
     */
    private int fixRange(int i) {
        if (i > 255) {
            return 255;
        }
        if (i < 0) {
            return 0;
        }
        return i;
    }

    /**
     * Calculate the error introduced by setting the pixel from the old to the new color.
     * @param oldP the old pixel color
     * @param newP the new pixel color
     * @return the three-element array (r, g, b)
     */
    private int[] calculateError(Color oldP, Color newP) {
        int r = oldP.getRed() - newP.getRed();
        int g = oldP.getGreen() - newP.getGreen();
        int b = oldP.getBlue() - newP.getBlue();
        return new int[] {r, g, b};
    }

    /**
     * Find the closest 3-bit color to the given RGB color.
     *
     * @param oldP the color to quantize
     * @param colorDepth the color depth for the dithered image
     * @return the new color
     */
    private Color getClosestColor(Color oldP, int colorDepth) {
        int bitPerChannel = colorDepth / 3;
        int r = fixChannel(oldP.getRed(), bitPerChannel);
        int g = fixChannel(oldP.getGreen(), bitPerChannel);
        int b = fixChannel(oldP.getBlue(), bitPerChannel);
        return new Color(r, g, b);
    }

    /**
     * Quantize a single color channel.
     *
     * @param channel the value of the color channel to quantize
     * @param bits 1/3 of the color depth for dithering
     * @return the quantized value
     */
    private int fixChannel(int channel, int bits) {
        double d = 255 / (Math.pow(2, bits) - 1);
        return (int) Math.round(Math.round(channel / d) * d);
    }
}
