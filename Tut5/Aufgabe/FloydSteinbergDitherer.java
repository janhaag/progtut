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
        // Rest of code goes here...
    }

///////////////////////////////////////////////////////////////////////////////
//////////////////////////////// Don't change /////////////////////////////////
///////////////////////////////////////////////////////////////////////////////

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
