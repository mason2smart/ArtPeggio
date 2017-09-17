import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.awt.Image;

import java.io.InputStream;

public class gui extends JFrame {
   BufferedImage[] images;
   BufferedImage logoImage=null;
   JPanel LoadPanel;
   JLabel logoLabel;
   JLabel loadLabel;
   Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
   final double FrameWidthMulti = screenSize.getWidth() / 1920;
   final double FrameHeightMulti = screenSize.getHeight() / 1080;
   final int FrameWidth = (int) (400 * FrameWidthMulti);
   final int FrameHeight = (int) (800 * FrameHeightMulti);
   Image LoadIMG;
   ImageIcon loadImg;
   JPanel Options;
   private boolean isBuffered = false;
   JTextField filePath;
   Dimension windowSize;
   InputStream sourceimage;
   Image bgImage;
   JButton browse;
   boolean LogoisBuffered;
   JFileChooser imageSelector;



   public gui() {
      super("artPeggio");
      images = new BufferedImage[64];
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      windowSize= new Dimension(FrameWidth, FrameHeight);
      this.setSize(windowSize);
      this.setPreferredSize(windowSize);
      this.setResizable(false);
      LoadPanel = new JPanel();
      this.setVisible(false);
      loadLabel = new JLabel();
      loadLabel.setLayout(new BorderLayout());
      loadLabel.setVisible(false);
      LoadPanel.setSize(windowSize);
      Options = new JPanel();
      this.setLayout(new GridLayout(2,1));
      setlook();


      loadOptions();
     // BufferLoading();

   }

   public void browseBtn(){
      browse = new JButton("Browse Image");
      browse.setPreferredSize(new Dimension((int)(320*FrameWidthMulti), (int)(180*FrameHeightMulti)));
      browse.setSize((int)(320*FrameWidthMulti), (int)(180*FrameHeightMulti));

      browse.setBorder(BorderFactory.createSoftBevelBorder(2, Color.blue,Color.black));
      Options.add(browse,BorderLayout.NORTH);
            browse.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                  browse.setText("browsing...");
                  imageSelector = new JFileChooser();
                  imageSelector.setFileSelectionMode(JFileChooser.FILES_ONLY);//only allows selection of files
                  int selectV = imageSelector.showOpenDialog(null);
                  if (selectV == JFileChooser.APPROVE_OPTION) {
                     filePath.setText(imageSelector.getSelectedFile().toString());
                  }
            }
   });}

   public void initOptions() {
      Options.setBackground(Color.darkGray);
      Options.setSize(windowSize);
      Options.setLayout(new FlowLayout(1,2,10));//Flow Layout
      Options.setBackground(Color.darkGray);
      browseBtn();
      this.add(Options);
      Options.setOpaque(false);
      Options.setVisible(true);
      this.setVisible(true);
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
   public void loadOptions(){
      logoImageLoad();
      initOptions();
   }
   private BufferedImage getScaledImage(Image srcImg, int w, int h) {
      BufferedImage resized = new BufferedImage(w, h, BufferedImage.TRANSLUCENT);
      Graphics2D g2 = resized.createGraphics();
      g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
      g2.drawImage(srcImg, 0, 0, w, h, null);
      g2.dispose();
      return resized;
   }


   public void runSelection(int demo){
      artpeggio.loadPhoto(demo);
   }


   public void logoImageLoad() {
      logoLabel = new JLabel();
      /*InputStream  sourceimages;
       sourceimages = this.getClass().getResourceAsStream("intro/logo.jpg");

      try {
         logoImage = getScaledImage(ImageIO.read(new BufferedInputStream(sourceimage)), FrameWidth, FrameHeight);
      } catch (IOException e) {
         e.printStackTrace();
      }


      try {
         sourceimages.close();
      } catch (IOException e) {
         e.printStackTrace();
      }
         try{
         logoLabel.setIcon(new ImageIcon(logoImage));
         this.add(logoLabel, BorderLayout.NORTH);
            logoLabel.setVisible(true);
            logoLabel.setOpaque(true);
            this.pack();
         }
         catch(NullPointerException e)
      {   e.printStackTrace();
      }
      */
      logoLabel.setIcon(new ImageIcon(getClass().getResource("intro/logo.png")));
      this.add(logoLabel, BorderLayout.NORTH);


   }
   public void BufferLoading() {
      new Thread() {
                  public void run() {
                     sourceimage = new InputStream() {
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
            }
            isBuffered = true;
            try {
               sourceimage.close();
            } catch (IOException e) {
               e.printStackTrace();
            }
         }
      }.run();
   }

   public void initLoad() {
      this.setVisible(true);
      this.removeAll();
      this.add(loadLabel);
      while (!isBuffered)//ensures the images are already buffered and stored in array ~10 second process.
      {
         //wait for images to be buffered
      }
      for (int i = 0; i < 64; i++) {
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


