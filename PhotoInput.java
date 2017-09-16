import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.metadata.*;
import javax.imageio.stream.*;
import java.awt.image.DataBufferByte;
import java.util.Iterator;
import javax.sound.midi.*;
import javax.sound.sampled.AudioPermission;
/*
package lib/metadata-extractor-2.10.1/com/drew/metadata;
import com.drew.imaging.*;
import com.drew.imaging.jpeg.*;
import com.drew.metadata.exif.*;***REMOVED***

public class PhotoInput {
   public static void main(String[] args) {
      AudioPermission permission = new AudioPermission("permission", "play");
      String filepath = "./drawables/ex01.jpg";
      
      int numSamples = 20;
      int[][] rgb = new int[(numSamples + 1) * (numSamples + 1)][3];
      int key = loadPhoto(filepath, rgb, numSamples);
      playMusic(rgb, key);
   ***REMOVED***

   public static int loadPhoto(String filepath, int[][] rgb, int numSamples) {
      BufferedImage image = null;
      File f = null;
   
      try {
         f = new File(filepath);
         image = ImageIO.read(f);
  ***REMOVED*** 
      catch (IOException e) {
         System.out.println(e);
  ***REMOVED*** 
      catch (Exception e) {
         System.out.println(e);
  ***REMOVED***
        
   
        //array for pixels
      byte[] pixels = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
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
 ***REMOVED***  
         
  ***REMOVED***
      assert pixelsSampled != 0;
      rgbTot[0] = rgbTot[0]/pixelsSampled;
      rgbTot[1] = rgbTot[1]/pixelsSampled;
      rgbTot[2] = rgbTot[2]/pixelsSampled;
      int total_mean = (rgbTot[0] + rgbTot[1] + rgbTot[2]) / 3;
      return total_mean;
   ***REMOVED***

   public static void playMusic(int rgb[][], int key) {
   
      System.out.println(key);
        //  I:  0 4 7
        //  V: -1 2 7
        // VI:  0 4 9
        // IV:  0 5 9
      final int ZERO = key;
      final int FOUR = key + 4;
      final int SEVEN = key + 7;
      final int NEG_ONE = key - 1;
      final int TWO = key + 2;
      final int NINE = key + 9;
      final int FIVE = key + 5;
      final int QUARTER = 100;
        
        //create Synthesizer 
      Synthesizer midiSynth = null;
      try { 
         midiSynth = MidiSystem.getSynthesizer();
         midiSynth.open();
  ***REMOVED*** 
      catch (Exception e) {
         System.out.println(e);
  ***REMOVED***
        //get instruments and channels, load the default instrument
      Instrument[] instr = midiSynth.getDefaultSoundbank().getInstruments();
      MidiChannel[] mChannels = midiSynth.getChannels();
      midiSynth.loadInstrument(instr[0]);
        
      int vol = 100;
      int volChord = 50;
   
        //notes since last chord;
      int chordCounter = 1;
      for (int r = 0; r < rgb.length; r++) {
         /*       
         switch (chordCounter) {
            case 1:
                        //turn off all previous notes
               mChannels[1].noteOn(ZERO, volChord);
               mChannels[1].noteOn(FOUR, volChord);
               mChannels[1].noteOn(SEVEN, volChord);
               chordCounter++;
   ***REMOVED***
            case 2:
                        
               mChannels[1].noteOn(NEG_ONE, volChord);
               mChannels[1].noteOn(TWO, volChord);
               mChannels[1].noteOn(SEVEN, volChord);
               chordCounter++;
   ***REMOVED***
            case 3:
                        
               mChannels[1].noteOn(ZERO, volChord);
               mChannels[1].noteOn(FOUR, volChord);
               mChannels[1].noteOn(NINE, volChord);
               chordCounter++;
   ***REMOVED***
                    
            case 4:
            
               mChannels[1].noteOn(ZERO, volChord);
               mChannels[1].noteOn(FIVE, volChord);
               mChannels[1].noteOn(NINE, volChord);
               chordCounter++;
   ***REMOVED***
        ***REMOVED***
               ;
 ***REMOVED******REMOVED***
                
         System.out.println("Now for the notes");
         
         //FIRST NOTE
         for (int c = 0; c < 3; c++) {
            mChannels[0].noteOn(rgb[r][c]/2, vol);
            System.out.println(rgb[r][c]/2 + "r: " + r);
            try {
               Thread.sleep(QUARTER);
***REMOVED*** 
            catch (InterruptedException e) {
               mChannels[0].noteOff(rgb[r][c]/2);
***REMOVED***
 ***REMOVED***
         
         
         for (int c = 0; c < 3; c++) {
            mChannels[0].noteOff(rgb[r][c]/2);
 ***REMOVED***
         
         /*
         mChannels[0].noteOn(rgb[r][0]/2, vol);
         try {
            Thread.sleep(QUARTER);
 ***REMOVED*** 
         catch (InterruptedException e) {
            mChannels[0].noteOff(rgb[r][0]/2);
 ***REMOVED***
      
                //SECOND NOTE
         mChannels[0].noteOn(rgb[r][1]/2, vol);
         try {
            Thread.sleep(QUARTER);
 ***REMOVED*** 
         catch (InterruptedException e) {
            mChannels[0].noteOff(rgb[r][1]/2);
 ***REMOVED***
                
                //THIRD NOTE
         mChannels[0].noteOn(rgb[r][2]/2, vol);
         try {
            Thread.sleep(QUARTER);
 ***REMOVED*** 
         catch (InterruptedException e) {
            mChannels[0].noteOff(rgb[r][2]/2);
 ***REMOVED***
      
                //FIRST NOTE
         mChannels[0].noteOn(rgb[r][0]/2, vol);
         try {
            Thread.sleep(QUARTER);
 ***REMOVED*** 
         catch (InterruptedException e) {
            mChannels[0].noteOff(rgb[r][0]/2);
 ***REMOVED******REMOVED***
      
         /*       //turn off all previous notes
         switch (chordCounter) {
            case 1:
               mChannels[0].noteOff(ZERO);
               mChannels[0].noteOff(FOUR);
               mChannels[0].noteOff(SEVEN);
               chordCounter++;
   ***REMOVED***
            case 2:
                        
               mChannels[0].noteOff(NEG_ONE);
               mChannels[0].noteOff(TWO);
               mChannels[0].noteOff(SEVEN);
               chordCounter++;
   ***REMOVED***
            case 3:
                        
               mChannels[0].noteOff(ZERO);
               mChannels[0].noteOff(FOUR);
               mChannels[0].noteOff(NINE);
               chordCounter++;
   ***REMOVED***
                    
            case 4:
            
               mChannels[0].noteOff(ZERO);
               mChannels[0].noteOff(FIVE);
               mChannels[0].noteOff(NINE);
               chordCounter++;
   ***REMOVED***
        ***REMOVED***
               ;
 ***REMOVED***
                //rotate the counter: chordCounter == 4 ? = 1 : ++
         if (chordCounter == 4) {
            chordCounter = 1;
 ***REMOVED***
         else {
            chordCounter++;
 ***REMOVED******REMOVED***
      
  ***REMOVED***
   ***REMOVED***
***REMOVED***
