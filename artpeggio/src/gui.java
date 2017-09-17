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

   ***REMOVED***

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
      ***REMOVED***
***REMOVED***
   ***REMOVED***);***REMOVED***

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

   ***REMOVED***


   public void setlook() {
      try {
         UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
  ***REMOVED*** catch (ClassNotFoundException e) {
         e.printStackTrace();
  ***REMOVED*** catch (InstantiationException e) {
         e.printStackTrace();
  ***REMOVED*** catch (IllegalAccessException e) {
         e.printStackTrace();
  ***REMOVED*** catch (UnsupportedLookAndFeelException e) {
         e.printStackTrace();
  ***REMOVED***
   ***REMOVED***
   public void loadOptions(){
      logoImageLoad();
      initOptions();
   ***REMOVED***
   private BufferedImage getScaledImage(Image srcImg, int w, int h) {
      BufferedImage resized = new BufferedImage(w, h, BufferedImage.TRANSLUCENT);
      Graphics2D g2 = resized.createGraphics();
      g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
      g2.drawImage(srcImg, 0, 0, w, h, null);
      g2.dispose();
      return resized;
   ***REMOVED***


   public void runSelection(int demo){
      artpeggio.loadPhoto(demo);
   ***REMOVED***


   public void logoImageLoad() {
      logoLabel = new JLabel();
      /*InputStream  sourceimages;
       sourceimages = this.getClass().getResourceAsStream("intro/logo.jpg");

      try {
         logoImage = getScaledImage(ImageIO.read(new BufferedInputStream(sourceimage)), FrameWidth, FrameHeight);
  ***REMOVED*** catch (IOException e) {
         e.printStackTrace();
  ***REMOVED***


      try {
         sourceimages.close();
  ***REMOVED*** catch (IOException e) {
         e.printStackTrace();
  ***REMOVED***
         try{
         logoLabel.setIcon(new ImageIcon(logoImage));
         this.add(logoLabel, BorderLayout.NORTH);
            logoLabel.setVisible(true);
            logoLabel.setOpaque(true);
            this.pack();
 ***REMOVED***
         catch(NullPointerException e)
      {   e.printStackTrace();
  ***REMOVED***
      ***REMOVED***
      logoLabel.setIcon(new ImageIcon(getClass().getResource("intro/logo.png")));
      this.add(logoLabel, BorderLayout.NORTH);


   ***REMOVED***
   public void BufferLoading() {
      new Thread() {
                  public void run() {
                     sourceimage = new InputStream() {
                        @Override
                        public int read() throws IOException {
                       ***REMOVED***
            ***REMOVED***
***REMOVED***;
            for (int i = 0; i < 64; i++) {
               try {
                  if (i <= 9) {
                     sourceimage = this.getClass().getResourceAsStream("intro/Intro0" + i + ".jpg");
      ***REMOVED*** else if (i > 9) {
                     sourceimage = this.getClass().getResourceAsStream("intro/Intro" + i + ".jpg");
      ***REMOVED***

                  images[i] = getScaledImage(ImageIO.read(new BufferedInputStream(sourceimage)), FrameWidth, FrameHeight);
   ***REMOVED*** catch (IOException e) {
                  e.printStackTrace();
   ***REMOVED***
***REMOVED***
            isBuffered = true;
            try {
               sourceimage.close();
***REMOVED*** catch (IOException e) {
               e.printStackTrace();
***REMOVED***
 ***REMOVED***
  ***REMOVED***.run();
   ***REMOVED***

   public void initLoad() {
      this.setVisible(true);
      this.removeAll();
      this.add(loadLabel);
      while (!isBuffered)//ensures the images are already buffered and stored in array ~10 second process.
      {
         //wait for images to be buffered
  ***REMOVED***
      for (int i = 0; i < 64; i++) {
         loadLabel.setIcon(new ImageIcon(images[i]));
         this.pack();

         try {
            Thread.sleep(84);
 ***REMOVED*** catch (InterruptedException e) {
            e.printStackTrace();
 ***REMOVED***

  ***REMOVED***

   ***REMOVED***


***REMOVED***


