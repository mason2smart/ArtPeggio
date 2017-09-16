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
        String filepath = "./drawables/ex02.jpg";
        loadPhoto(filepath);
        readAndPrintMetadata(filepath);
***REMOVED***

    public static int[] loadPhoto(String filepath) {
        BufferedImage image = null;
        File f = null;
        Synthesizer midiSynth = null;

        try {
            f = new File(filepath);
            image = ImageIO.read(f);
            midiSynth = MidiSystem.getSynthesizer();
            midiSynth.open();
***REMOVED*** catch (IOException e) {
            System.out.println(e);
***REMOVED*** catch (Exception e) {
            System.out.println(e);
***REMOVED***
        
        Instrument[] instr = midiSynth.getDefaultSoundbank().getInstruments();
        MidiChannel[] mChannels = midiSynth.getChannels();
        midiSynth.loadInstrument(instr[0]);


        byte[] pixels = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
        int width = image.getWidth();
        int height = image.getHeight();
        int pixelsSampled = width * height;
        int[] rgb = new int[6];
        int vol = 100;
        for (int y = 0; y < height; y += (height/10)) { //y++) {
            for (int x = 0; x < width; x += (width/10)) { //x++) {
                int clr = image.getRGB(x,y);
                rgb[0] += (int) (clr & 0x00ff0000) >> 16;
                rgb[1] += (int) (clr & 0x0000ff00) >> 8;
                rgb[2] += (int) clr & 0x000000ff;
                rgb[3] = (clr & 0x00ff0000) >> 16;
                rgb[4] = (clr & 0x0000ff00) >> 8;
                rgb[5] = clr & 0x000000ff;

                mChannels[0].noteOn(rgb[3]/2, vol);
                mChannels[0].noteOn(rgb[4]/2, vol);
                mChannels[0].noteOn(rgb[5]/2, vol);
                try {
                    Thread.sleep(50);
    ***REMOVED*** catch (InterruptedException e) {
                    mChannels[0].noteOff(rgb[3]/2);
                    mChannels[0].noteOff(rgb[4]/2);
                    mChannels[0].noteOff(rgb[5]/2);
    ***REMOVED***
                
                System.out.println("Rt: %d Gt: %d Bt: %d", (rgb[0]/2), (rgb[1]/2), (rgb[2]/2));
                System.out.println("Rv: %d Gv: %d Bv: %d", (rgb[3]/2), (rgb[4]/2), (rgb[5]/2));
***REMOVED***
***REMOVED***
        assert pixelsSampled != 0;
        rgb[0] = rgb[0]/pixelsSampled;
        rgb[1] = rgb[1]/pixelsSampled;
        rgb[2] = rgb[2]/pixelsSampled;
        for (int i : rgb) {
            System.out.println(i);
***REMOVED***
    return rgb;
***REMOVED***

    public static void readAndPrintMetadata(String filepath) {
        try {
            File f = new File(filepath);
            ImageInputStream imageStream = ImageIO.createImageInputStream(f);
            Iterator<ImageReader> readers = ImageIO.getImageReaders(imageStream);
            if (readers.hasNext()) {
                ImageReader reader = readers.next();
                reader.setInput(imageStream, true);
                IIOMetadata metadata = reader.getImageMetadata(0);

                String[] names = metadata.getMetadataFormatNames();
                int length = names.length;
                for (String i : names) {
                    System.out.println(i);
    ***REMOVED***
***REMOVED***
***REMOVED***
        catch (Exception e) {
            e.printStackTrace();
***REMOVED***
/*
            Metadata metadata = ImageMetadataReader.readMetadata(file);
            for (Directory directory : metadata.getDirectories()) {
                    for (Tag tag : directory.getTags()) {
                                System.out.format("[%s] - %s = %s",
                                                    directory.getName(), tag.getTagName(), tag.getDescription());
                        ***REMOVED***
                        if (directory.hasErrors()) {
                                    for (String error : directory.getErrors()) {
                                                    System.err.format("ERROR: %s", error);
                                                ***REMOVED***
                            ***REMOVED***
***REMOVED***
***REMOVED***
***REMOVED***
***REMOVED***
***REMOVED***
***REMOVED***
