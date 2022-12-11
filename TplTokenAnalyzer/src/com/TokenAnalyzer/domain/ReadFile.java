package com.TokenAnalyzer.domain;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ReadFile 
{
	private String output;
	private Path fileName;

	public String ReadInput(String path) 
	{
		
		try {
			fileName = Path.of(path);
			output = Files.readString(fileName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return output;
	}
}
