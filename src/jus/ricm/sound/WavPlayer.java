package jus.ricm.sound;

import java.io.*;
import javax.sound.sampled.*;
 
public class WavPlayer implements Runnable {
    private String filename;

 
    public WavPlayer(String wavfile) {
            filename = wavfile;
    }
 
    @Override
    public void run() {
        while(true)
        {
        	loop();
        }
    }
    
    public void loop()
    {
         int nBytesRead = 0;
         byte[] abData = new byte[524288];    // 128Kb
         AudioInputStream audioInputStream = null;
         AudioFormat format = null;
         SourceDataLine auline = null;
    	try {
            File soundFile = new File(filename);
            audioInputStream = AudioSystem.getAudioInputStream(soundFile);
            format = audioInputStream.getFormat();
            DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);
            auline = (SourceDataLine) AudioSystem.getLine(info);
            auline.open(format);
            auline.start();
            while (nBytesRead != -1) {
                nBytesRead = audioInputStream.read(abData, 0, abData.length);
                if (nBytesRead >= 0)
                        auline.write(abData, 0, nBytesRead);
            }
        } catch (Exception e) {
                e.printStackTrace();
                return;
        } finally {
            if (auline != null) {
                auline.drain();
                auline.close();
            }
        }
    }
}
