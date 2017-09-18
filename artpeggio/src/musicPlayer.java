import javax.sound.midi.Instrument;
import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Synthesizer;
import javax.swing.SwingWorker;

public class musicPlayer extends SwingWorker<Void,String> {
int key;
int rgb[][];
   public musicPlayer() {
   ***REMOVED***

   /**
    * Computes a result, or throws an exception if unable to do so.
    * <p>
    * <p>
    * Note that this method is executed only once.
    * <p>
    * <p>
    * Note: this method is executed in a background thread.
    *
    * @return the computed result
    * @throws Exception if unable to compute a result
    ***REMOVED***
   @Override
   protected Void doInBackground() {
      this.key=artpeggio.getKey();
      this.rgb=artpeggio.getRgb();
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
         if (this.isCancelled())
         {
***REMOVED***
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

   /**
    * When an object implementing interface <code>Runnable</code> is used
    * to create a thread, starting the thread causes the object's
    * <code>run</code> method to be called in that separately executing
    * thread.
    * <p>
    * The general contract of the method <code>run</code> is that it may
    * take any action whatsoever.
    *
    * @see Thread#run()
    ***REMOVED***
   return null;
   ***REMOVED***
   ***REMOVED***