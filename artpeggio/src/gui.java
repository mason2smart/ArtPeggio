import sun.applet.Main;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.FileInputStream;
import java.awt.Image;

import java.net.URL;
public class gui extends JFrame {
   JPanel LoadPanel;
   JLabel loadLabel;
   Dimension screenSize= Toolkit.getDefaultToolkit().getScreenSize();
   final double FrameWidthMulti = screenSize.getWidth()/1920;
   final double FrameHeightMulti = screenSize.getHeight()/1080;
   final int FrameWidth=(int)(800*FrameWidthMulti);
   final int FrameHeight=(int)(1000*FrameHeightMulti);
   Image LoadIMG;
   public gui()
   {
      super("artPeggio");
      setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      Dimension windowSize = new Dimension(FrameWidth, FrameHeight);
      this.setSize(windowSize);
      this.setResizable(false);
      setlook();
      initLoading();
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
   public void initLoading()
   {
      LoadPanel=new JPanel();
      Image loadIMG = null;
      ImageIcon loadImg;
      loadLabel=new JLabel();
      loadLabel.setLayout(new BorderLayout());
      loadLabel.setVisible(true);
      LoadPanel.add(loadLabel);
      File sourceimage=new File("artpeggio/resources/drawables/ex02.jpg");
      for (int i=0; i<=64; i++) {
         if (i < 9){

            sourceimage=new File("artpeggio/resources/IntroJPGSequence/Intro0"+i+".jpg" );
 ***REMOVED***
         else {
          sourceimage=new File("artpeggio/resources/IntroJPGSequence/Intro"+i+".jpg" );
 ***REMOVED***
      try {
         loadIMG=ImageIO.read(sourceimage);
         loadImg = new ImageIcon(loadIMG.getScaledInstance(FrameWidth, FrameHeight, Image.SCALE_SMOOTH));
         loadLabel.setIcon(loadImg);
         this.pack();
 ***REMOVED***
      catch (Exception e)
      {
         e.printStackTrace();
  ***REMOVED***
         try {
            Thread.sleep(200);
 ***REMOVED*** catch (InterruptedException e) {
            e.printStackTrace();
 ***REMOVED***

  ***REMOVED***
      this.pack();
      this.setVisible(true);

   ***REMOVED***



***REMOVED***


