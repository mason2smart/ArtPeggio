import sun.applet.Main;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.FileInputStream;
import java.awt.Image;

import java.io.InputStream;
import java.net.URL;
public class gui extends JFrame {
   BufferedImage[] images;
   JPanel LoadPanel;
   JLabel loadLabel;
   Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
   final double FrameWidthMulti = screenSize.getWidth() / 1920;
   final double FrameHeightMulti = screenSize.getHeight() / 1080;
   final int FrameWidth = (int) (400 * FrameWidthMulti);
   final int FrameHeight = (int) (800 * FrameHeightMulti);
   Image LoadIMG;
   ImageIcon loadImg;
   JPanel Options;
   private boolean isBuffered=false;

   public gui()
   {
      super("artPeggio");
      images = new BufferedImage[64];
      setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      Dimension windowSize = new Dimension(FrameWidth, FrameHeight);
      this.setSize(windowSize);
      this.setPreferredSize(windowSize);
      this.setResizable(false);
      Options = new JPanel();
      LoadPanel=new JPanel();
      Options.setSize(windowSize);
      this.setVisible(false);
      loadLabel=new JLabel();
      loadLabel.setLayout(new BorderLayout());
      loadLabel.setVisible(true);
      this.add(loadLabel);
      LoadPanel.setSize(windowSize);
      
      setlook();
      BufferLoading();
   }
   public void initOptions(){
      this.removeAll();
      this.add(Options);
      this.pack();
   }
   public void setlook() {
      try {
         UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
      } catch (ClassNotFoundException e) {
         e.printStackTrace();
      } catch (InstantiationException e) {
         e.printStackTrace();
      } catch (IllegalAccessException e) {
         e.printStackTrace();
      } catch (UnsupportedLookAndFeelException e) {
         e.printStackTrace();
      }
   }
   private BufferedImage getScaledImage(Image srcImg, int w, int h){
      BufferedImage resized = new BufferedImage(w, h, BufferedImage.TRANSLUCENT);
      Graphics2D g2 = resized.createGraphics();
      g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
      g2.drawImage(srcImg, 0, 0, w, h, null);
      g2.dispose();
      return resized;
   }
   public void BufferLoading()
   {
      new Thread(){
          public void run(){
        InputStream sourceimage = new InputStream() {
         @Override
         public int read() throws IOException {
            return 0;
         }
            };
          for (int i = 0; i < 64; i++) {
             try {
            if (i <= 9) {
               sourceimage = this.getClass().getResourceAsStream("intro/Intro0" + i + ".jpg");
            } else if (i > 9) {
               sourceimage = this.getClass().getResourceAsStream("intro/Intro" + i + ".jpg");
            }

            images[i] = getScaledImage(ImageIO.read(new BufferedInputStream(sourceimage)), FrameWidth, FrameHeight);
         } catch (IOException e) {
            e.printStackTrace();
         }
      } isBuffered=true;
      try {
         sourceimage.close();
      } catch (IOException e) {
         e.printStackTrace();
      }}
   }.run();}
public void initLoad(){
      this.setVisible(true);
      this.removeAll();
      this.add(loadLabel);
      while (!isBuffered)//ensures the images are already buffered and stored in array ~10 second process.
      {
         //wait for images to be buffered
      }
      for (int i=0; i<64; i++) {
         loadLabel.setIcon(new ImageIcon(images[i]));
         this.pack();

         try {
            Thread.sleep(84);
         } catch (InterruptedException e) {
            e.printStackTrace();
         }

      }

   }



}


