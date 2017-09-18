import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.awt.image.DataBufferByte;
import java.util.ArrayList;
import javax.sound.midi.*;
import javax.sound.sampled.AudioPermission;
import javax.swing.JFrame;
import javax.swing.SwingWorker;
/*
package lib/metadata-extractor-2.10.1/com/drew/metadata;
import com.drew.imaging.*;
import com.drew.imaging.jpeg.*;
import com.drew.metadata.exif.*;*/

public class artpeggio {
   private static int key;
   private static gui ArtInterface;
   public static String imgPath = " ";
   public static int numSamples =20;
   static int[][] rgb = new int[(numSamples + 1) * (numSamples + 1)][3];;
    static SwingWorker <Void,String> musical;
   // public static Thread InterfaceThread;

      public static void main(String[] args) {
     /*    InterfaceThread = new Thread() {
             public void run()
             {
                ArtInterface = new gui();
                while(true)
                {

                }
             }
         };InterfaceThread.run();
*/javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
               gui aGui = new gui();
            }
         });
          musical = new musicPlayer();
            ArtInterface = new gui();
         ArtInterface.setVisible(true);
      AudioPermission permission = new AudioPermission("permission", "play");
      String filepath = "artpeggio/resources/drawables/ex02.jpg";


     // loadPhoto(1);
   }
   public static int getKey()
   {
      return key;
   }
   public static int[][] getRgb(){
         return rgb;
   }
   public static void loadPhoto(int DemoNum) {
      BufferedImage image = null;
      switch (DemoNum) {
         case 1: imgPath="ex01.jpg";
               break;
         case 2: imgPath="ex02.jpg";
               break;
         case 3: imgPath="ex03.jpg";
               break;
      }
      try {
         image = ImageIO.read(artpeggio.class.getResourceAsStream("drawables/"+imgPath));
      } catch (IOException e) {
         e.printStackTrace();
      }
      //array for pixels
      try {
         byte[] pixels = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
      }catch (Exception e)
      {
         e.printStackTrace();
      }
      //image width and height
      int width = image.getWidth();
      int height = image.getHeight();
      //rgbTot calculates total, in order to do mean calculation later
      int[] rgbTot = new int[3];
      //volume
      int vol = 100;
      //total number of pixels grabbed so far
      int pixelsSampled = 0;

      for (int y = 0; y < height; y += Math.ceil(height/numSamples)) { //y++) {
         for (int x = 0; x < width; x += Math.ceil(width/numSamples)) { //x++) {
            int clr = image.getRGB(x,y);
            rgbTot[0] += (int) ((clr & 0x00ff0000) >> 16);
            rgbTot[1] += (int) ((clr & 0x0000ff00) >> 8);
            rgbTot[2] += (int) clr & 0x000000ff;

            rgb[pixelsSampled][1] = ((clr & 0x0000ff00) >> 8);
            rgb[pixelsSampled][2]= (clr & 0x000000ff);

            System.out.printf("Loop: %d Rt: %5d Gt: %5d Bt: %5d | ", pixelsSampled,
               (rgbTot[0]), (rgbTot[1]), (rgbTot[2]));
            System.out.printf("Rv: %3d Gv: %3d Bv: %3d\n",
               (rgb[pixelsSampled][0]/2), (rgb[pixelsSampled][1]/2),
               (rgb[pixelsSampled][2]/2));
            pixelsSampled++;
         }

      }
      assert pixelsSampled != 0;
      rgbTot[0] = rgbTot[0]/pixelsSampled;
      rgbTot[1] = rgbTot[1]/pixelsSampled;
      rgbTot[2] = rgbTot[2]/pixelsSampled;
      int total_mean = (rgbTot[0] + rgbTot[1] + rgbTot[2]) / 3;
      key = total_mean;

      if(!musical.isDone()) {
         musical.cancel(true);
         System.out.println("canceled musical");
      }
            musical = new musicPlayer();
         musical.execute();
   }







   public static void loadPhoto(String filepath) {
      BufferedImage image = null;
      File f = null;

      try {
         f = new File(filepath);
         image = ImageIO.read(f);
      }
      catch (IOException e) {
         System.out.println(e);
      }
      catch (Exception e) {
         System.out.println(e);
      }


      //array for pixels
      try {
         byte[] pixels = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
      }catch (Exception e)
      {
         e.printStackTrace();
      }
      //image width and height
      int width = image.getWidth();
      int height = image.getHeight();
      //rgbTot calculates total, in order to do mean calculation later
      int[] rgbTot = new int[3];
      //volume
      int vol = 100;
      //total number of pixels grabbed so far
      int pixelsSampled = 0;

      for (int y = 0; y < height; y += Math.ceil(height/numSamples)) { //y++) {
         for (int x = 0; x < width; x += Math.ceil(width/numSamples)) { //x++) {
            int clr = image.getRGB(x,y);
            rgbTot[0] += (int) ((clr & 0x00ff0000) >> 16);
            rgbTot[1] += (int) ((clr & 0x0000ff00) >> 8);
            rgbTot[2] += (int) clr & 0x000000ff;

            rgb[pixelsSampled][1] = ((clr & 0x0000ff00) >> 8);
            rgb[pixelsSampled][2]= (clr & 0x000000ff);

            System.out.printf("Loop: %d Rt: %5d Gt: %5d Bt: %5d | ", pixelsSampled,
               (rgbTot[0]), (rgbTot[1]), (rgbTot[2]));
            System.out.printf("Rv: %3d Gv: %3d Bv: %3d\n",
               (rgb[pixelsSampled][0]/2), (rgb[pixelsSampled][1]/2),
               (rgb[pixelsSampled][2]/2));
            pixelsSampled++;
         }

      }
      assert pixelsSampled != 0;
      rgbTot[0] = rgbTot[0]/pixelsSampled;
      rgbTot[1] = rgbTot[1]/pixelsSampled;
      rgbTot[2] = rgbTot[2]/pixelsSampled;
      int total_mean = (rgbTot[0] + rgbTot[1] + rgbTot[2]) / 3;
      key = total_mean;

   if(musical.isDone()==false)
      musical.cancel(true);
      musical = new musicPlayer();
      musical.execute();
   }


}
