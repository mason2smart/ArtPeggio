import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
public class gui extends JFrame {
   final double FrameSizeMulti = Screensize.
final int FrameWidth=800;
final int FrameHeight=1000*;
   public gui()
   {
      JPanel LoadPanel;
      Dimension windowSize = new Dimension(FrameWidth, FrameHeight);
      this.setSize(windowSize);
      this.ins
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


***REMOVED***


