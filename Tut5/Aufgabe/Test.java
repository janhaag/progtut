import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class Test {
    public static final String INPUT_IMAGE = "";
    public static final String OUTPUT_FILE = "";

    public static void main(String... args) throws Exception {
        BufferedImage img = ImageIO.read(new File(INPUT_IMAGE));
        FloydSteinbergDitherer d = new FloydSteinbergDitherer();
        d.dither(img, 3);
        ImageIO.write(img, "png", new File(OUTPUT_FILE));
    }
}
