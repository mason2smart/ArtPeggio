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


}


