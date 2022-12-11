package com.TokenAnalyzer.App;

import java.awt.EventQueue;

import com.TokenAnalyzer.Gui.Gui;

public class TokenAnalyzerApp {
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					new Gui();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	

}
