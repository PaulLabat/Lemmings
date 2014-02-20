package jus.ricm.sound;


import java.io.*;

import javax.sound.sampled.*;

public class Sound implements Cloneable, Runnable {
	private String filename;
	private File soundFile; 
	private int nBytesRead = 0;
	private byte[] abData = new byte[524288]; // 128Kb
	private AudioInputStream audioInputStream = null;
	private AudioFormat format = null;
	private SourceDataLine auline = null;
	private DataLine.Info info;
	private byte[] buffer;
	
	public Sound(String wavfile) {
		filename = wavfile;
		soundFile = new File(filename);
		buffer = new byte[(int) soundFile.length()];		
		try {
			audioInputStream = AudioSystem.getAudioInputStream(soundFile);
			format = audioInputStream.getFormat();
			this.info = new DataLine.Info(SourceDataLine.class, format);		
			while (nBytesRead != -1) {
				nBytesRead = audioInputStream.read(abData, 0, abData.length);
				//On remplis le buffer
				if (nBytesRead >0) {
					for (int i=0; i<nBytesRead; i++) {
						buffer[i]=abData[i];
					}
				}
			}			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		} 
		
		
		
	}
	public Sound() {
	}
	public Sound cloneObj() {
		try {
			Sound objA = new Sound();
			Sound objACloned = (Sound) objA.clone();
			return(objACloned);
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public void run() {
		try {
		auline = (SourceDataLine) AudioSystem.getLine(info);
		auline.open(format);
		auline.start();
		if (buffer.length > 100000) {
			byte[] minibuffer = new byte[120000];
			for (int i=0; i<120000;i++) {
				minibuffer[i]=buffer[i];
			}
			auline.write(minibuffer, 0,  minibuffer.length);
		}
		else {
			auline.write(buffer, 0,  buffer.length);
		}
		}
		catch (Exception e) {
			System.out.println("Exception : "+e.toString());
		}
		finally {
			if (auline != null) {
				auline.drain();
				auline.close();
			}
		}
	}
	public File GetFile() {
		return this.soundFile;
	}
	public void SetFile(File soundFile) {
		this.soundFile = soundFile;
	}
	public void SetAudioInputStream(AudioInputStream a) {
		this.audioInputStream = a;
	}
	public DataLine.Info GetInfo() {
		return this.info;
	}
	public void SetInfo(DataLine.Info i) {
		this.info = i;
	}
	public AudioFormat GetAudioFormat() {
		return this.format ;
	}
	public void SetAudioFormat(AudioFormat i) {
		this.format = i;
	}
	public byte[]  GetAudiobuffer() {
		return this.buffer ;
	}
	public void SetAudiobuffer(byte[] i) {
		this.buffer = i;
	}
}