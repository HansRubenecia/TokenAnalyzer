package com.TokenAnalyzer.domain;

public class SyntaxAnalysis 
{
	public String Analysis(String input) 
	{
		
		String[] inputSplit = input.split(">");
		String output = "";
		
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
