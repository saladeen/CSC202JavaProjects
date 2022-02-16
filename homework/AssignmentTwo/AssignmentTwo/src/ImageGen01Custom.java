import java.awt.image.*;
import java.awt.Color;
import java.io.*;
import javax.imageio.*;

public class ImageGen01Custom {
    public static void main (String[] args) {
        String fileOut = "test.jpg";   // destination file
      
        // create BufferedImage of SIZE and TYPE
        final int SIDE = 1024;
        final int TYPE = BufferedImage.TYPE_INT_RGB;
        BufferedImage image = new BufferedImage(SIDE, SIDE, TYPE);
      
        final int LIMIT = 255; // limit of RGB values
        int r, g, b;           // from C -> values for R, G and B
        Color color;

        for (int i = 0; i < SIDE; i++) {
            for (int j = 0; j < SIDE; j++) {
                r = (i + j) % LIMIT;
                g = (i * j) % LIMIT;
                b = (i * i) % LIMIT;
                color =  new Color(r, g, b);
                image.setRGB(i, j, color.getRGB());  // saves pixel
            }   
        }

        // write image to file
        try {
            File outputfile = new File(fileOut);
            ImageIO.write(image, "jpg", outputfile);
        } catch (IOException e) {
          System.out.println("could not save file ...");
        }
    }
}