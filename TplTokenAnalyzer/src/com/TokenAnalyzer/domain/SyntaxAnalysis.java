package com.TokenAnalyzer.domain;

import java.util.HashMap;

public class SyntaxAnalysis 
{
	public String Analysis(String input) 
	{
		
		String[] inputSplit = input.split(">");
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		String output = "";
		hm.put("<data_type", 1);
		hm.put("<identifier", 2);
		hm.put("<assignment_operator", 3);
		hm.put("<value", 4);
		hm.put("<delimiter", 5);
		
		for (String a : inputSplit)
		{
			output += a + ">";
		}
		if(output.equals("<data_type><identifier><delimiter>")||output.equals("<data_type><identifier><assignment_operator><value><delimiter>"))
		{
			return "Syntax is Correct!";
		}
		else
		{
			return "Syntax is Incorrect!";
		}

	}
	
	
}
