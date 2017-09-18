import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.awt.Image;

import java.io.InputStream;
import java.util.ArrayList;

public class gui extends JFrame {
   JComboBox<String> Demo;
   Font buttonFont;
   Font selectedFont;
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
   String fileName;
   JButton runTap;
   int DemoInt;
   String comboText;
   JLabel selectedImg;
   Image selectedImage;




   public gui() {
      super("artPeggio");
      images = new BufferedImage[64];
      this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
      WindowListener exitListener = new WindowAdapter() {
         public void windowClosing(WindowEvent e) {
            int confirm = JOptionPane.showOptionDialog(
               null, "Are You Sure You Wish To Quit?",
               "Exit Now?", JOptionPane.YES_NO_OPTION,
               JOptionPane.QUESTION_MESSAGE, new ImageIcon(getClass().getResource("intro/logoThumbLoopedTransparent.gif")), null, null);
            if (confirm == 0) {
               System.exit(0);

***REMOVED***
 ***REMOVED******REMOVED***;this.addWindowListener(exitListener);
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
      selectedImg = new JLabel();
      this.setLayout(new BorderLayout(2,2));
      filePath=new JTextField();


      setlook();


      loadOptions();
   //   initLoad();



   ***REMOVED***


   public void DemoSelect(){
      Demo = new JComboBox<String>();
      Options.add(Demo);
      Demo.setFont(buttonFont.deriveFont((float)(40*FrameWidthMulti)));
      Demo.addItem("No Selection");Demo.addItem("Cat");Demo.addItem("Clown");Demo.addItem("Starry Night");
      Demo.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e){
            comboText= (String) Demo.getSelectedItem();
            DemoInt = Demo.getSelectedIndex();
            if(!Demo.getSelectedItem().equals("No Selection")) {
               filePath.setText((String) Demo.getSelectedItem());
               addSelectedImg(Demo.getSelectedIndex());
***REMOVED***
            else
               filePath.setText("No Item Selected");
 ***REMOVED***
  ***REMOVED***);
   ***REMOVED***



   public void browseBtn(){
      browse = new JButton("Browse Image");
      browse.setPreferredSize(new Dimension((int)(320*FrameWidthMulti), (int)(180*FrameHeightMulti)));
      browse.setSize((int)(320*FrameWidthMulti), (int)(180*FrameHeightMulti));
      try {
         buttonFont = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("Imprint.ttf"));//set font to microsoft font stored in resources
         browse.setFont(buttonFont.deriveFont((float) (40 * FrameWidthMulti)));//scales font size!
         selectedFont = Font.createFont(Font.TRUETYPE_FONT,getClass().getResourceAsStream("msyi.ttf"));
  ***REMOVED*** catch (FontFormatException e) {
         e.printStackTrace();
  ***REMOVED*** catch (IOException e) {
         e.printStackTrace();
  ***REMOVED***

      browse.setBorder(BorderFactory.createLineBorder(Color.blue,2, false));
      Options.add(browse,BorderLayout.NORTH);
            browse.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                  browse.setText("browsing...");
                  imageSelector = new JFileChooser();
                  imageSelector.setFileSelectionMode(JFileChooser.FILES_ONLY);//only allows selection of files
                  int selectV = imageSelector.showOpenDialog(null);
                  if (selectV == JFileChooser.APPROVE_OPTION) {
                     fileName = imageSelector.getSelectedFile().getName();
                     filePath.setText(imageSelector.getSelectedFile().toString());
      ***REMOVED***
                  if (filePath.getText().length()>4)
                  {
                     browse.setText(fileName);
                     browse.setFont(selectedFont.deriveFont((float) (60 * FrameWidthMulti)));//scales font size!
                     addSelectedImg(imageSelector.getSelectedFile().toString());
      ***REMOVED***
                  else
                  {
                     browse.setText("Browse Image");
                     browse.setFont(buttonFont.deriveFont((float) (40 * FrameWidthMulti)));//scales font size!
      ***REMOVED***
***REMOVED***
   ***REMOVED***);***REMOVED***

   public void runBtn(){
      runTap = new JButton("Play Image");
      runTap.setPreferredSize(new Dimension((int)(320*FrameWidthMulti), (int)(180*FrameHeightMulti)));
      runTap.setSize((int)(320*FrameWidthMulti), (int)(100*FrameHeightMulti));
      runTap.setFont(buttonFont.deriveFont((float) (40 * FrameWidthMulti)));//scales font size!
      //Options.add(new JSeparator());
      Options.add(runTap,BorderLayout.SOUTH);

      runTap.setBorder(BorderFactory.createLineBorder(Color.blue,2, false));
      runTap.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {

            if (filePath.getText().length()>4||DemoInt!=-1) {
               runTap.setText("Loading...");
               if (filePath.getText().equals(comboText))
               {
                  runSelection(DemoInt);
   ***REMOVED***
               else
               {
                  runSelection(filePath.getText());
   ***REMOVED***
***REMOVED***
            runTap.setText("Play Image");
 ***REMOVED******REMOVED***);

   ***REMOVED***
   public void addSelectedImg(int i){
      try {
        selectedImage= ImageIO.read(artpeggio.class.getResourceAsStream("drawables/ex0"+i+".jpg"));
  ***REMOVED*** catch (IOException e) {
         e.printStackTrace();
  ***REMOVED***
      selectedImage=selectedImage.getScaledInstance(FrameWidth,200, selectedImage.SCALE_SMOOTH);
      selectedImg.setIcon(new ImageIcon(selectedImage));
      Options.validate();
      this.pack();
   ***REMOVED***
   public void addSelectedImg(String FilePath){
      File f = new File(FilePath);
      try {
         selectedImage = ImageIO.read(f);
  ***REMOVED*** catch (IOException e) {
         e.printStackTrace();
  ***REMOVED***

      selectedImage=selectedImage.getScaledInstance(FrameWidth,200, selectedImage.SCALE_SMOOTH);
      selectedImg.setIcon(new ImageIcon(selectedImage));
      Options.validate();
      this.pack();
   ***REMOVED***


   public void initOptions() {
      Options.setBackground(Color.darkGray);
      Options.setSize(windowSize);
      Options.setLayout(new GridLayout(4,1));//Flow Layout
      Options.setBackground(Color.darkGray);
      browseBtn();
      DemoSelect();
      Options.add(selectedImg);
      runBtn();

      this.add(Options);
      Options.setOpaque(true);
      Options.setVisible(true);
      filePath.setMargin(new Insets(5,5,5,5));
      filePath.setEditable(false);
      this.add(filePath, BorderLayout.SOUTH);
      filePath.setBackground(Color.lightGray);
      filePath.setFont(selectedFont.deriveFont((float) (10 * FrameWidthMulti)));
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

      //BufferLoading();
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
   public void runSelection(String filepath){
      artpeggio.loadPhoto(filepath);
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
      this.removeAll();
      this.setVisible(true);
      this.add(loadLabel);
      loadLabel.setVisible(true);
      this.pack();
      for (int i = 0; i < 64; i++) {
         loadLabel.setIcon(new ImageIcon(images[i]));
         this.pack();

         try {
            Thread.sleep(84);
 ***REMOVED*** catch (InterruptedException e) {
            e.printStackTrace();
 ***REMOVED***

  ***REMOVED***
this.remove(loadLabel);
      loadOptions();
   ***REMOVED***


***REMOVED***


