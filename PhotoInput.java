import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import javax.imageio.ImageIO;
import java.awt.image.DataBufferByte;

public class PhotoInput {
    public static void main(String[] args) {
        loadPhoto("./drawables/ex01.jpg");
***REMOVED***

    public static long[][] loadPhoto(String filepath) {
        BufferedImage img = null;
        File f = null;

        try {
            f = new File(filepath);
            img = ImageIO.read(f);
***REMOVED*** catch (IOException e) {
            System.out.println(e);
***REMOVED***

        byte[] pixels = ((DataBufferByte) img.getRaster().getDataBuffer()).getData();
        int width = img.getWidth();
        int height = img.getHeight();
        long[][] result = new long[height][width];
        
        //suppose no alpha channel
        final int pixelLength = 3;
        for (int pixel = 0, r = 0; pixel < pixels.length; pixel += pixelLength, r++) {
            float avg = 0;
            int rgb = -16777216; //255 alpha
            for(int c = 0; c < width; c++) {
                rgb += ((long) pixels[pixel] & 0xff); //blue
                rgb += (((long) pixels[pixel + 1] & 0xff) << 8); //green
                rgb += (((long) pixels[pixel + 2] & 0xff) << 16); //red
                //result[r][c] = rgb;
***REMOVED***
            avg += (float) rgb / pixels.length;
            System.out.println(rgb + " " + avg);
***REMOVED***
***REMOVED***
***REMOVED***

***REMOVED***
