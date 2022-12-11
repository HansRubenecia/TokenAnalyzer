package com.TokenAnalyzer.domain;

import java.io.File;
import java.io.InputStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;


public class BgMusic
{
	private static Clip clip;
	

	public BgMusic(InputStream inputStream)
	{
		
		AudioInputStream audioInput;
		try {
			audioInput = AudioSystem.getAudioInputStream(inputStream);
			clip = AudioSystem.getClip();
			clip.open(audioInput);
		
		} catch (Exception e) 
		{
			
			e.printStackTrace();
		}
		
	}
	public static void playMusic()
	{
			clip.start();
			clip.loop(Clip.LOOP_CONTINUOUSLY);
	}
	public static void stopMusic()	
	{
		clip.stop();
	}
}
	
	
	


