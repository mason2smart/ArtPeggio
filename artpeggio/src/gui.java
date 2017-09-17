import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
public class gui extends JFrame {
   JLabel loadLabel;
   Dimension screenSize= Toolkit.getDefaultToolkit().getScreenSize();
   final double FrameWidthMulti = screenSize.getWidth()/1920;
   final double FrameHeightMulti = screenSize.getHeight()/1080;
   final int FrameWidth=(int)(800*FrameWidthMulti);
   final int FrameHeight=(int)(1000*FrameHeightMulti);
   public gui()
   {
      JPanel LoadPanel;
      Dimension windowSize = new Dimension(FrameWidth, FrameHeight);
      this.setSize(windowSize);
      this.setResizable(false);
      setlook();
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
      loadLabel=new JLabel();
      loadLabel.setLayout(new BorderLayout());
      loadLabel.setVisible(true);
      this.add(loadLabel);
      
      this.pack();
      this.setVisible(true);
   ***REMOVED***



***REMOVED***


