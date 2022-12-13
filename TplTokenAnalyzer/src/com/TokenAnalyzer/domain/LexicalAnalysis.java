package com.TokenAnalyzer.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class LexicalAnalysis 
{
	private String output;
	private String dataType;
	private String value;
	public String Analysis(String input) 
	{
		if(input.contains(";"))
		{
			input = input.replace(";"," ;");
		}	
		List <String>tokenList= new ArrayList<String>();
		HashMap<String, String> hm = new HashMap<String, String>();
		hm.put("int", "<data_type>");
		hm.put("String", "<data_type>");
		hm.put("float", "<data_type>");
		hm.put("char", "<data_type>");
		hm.put("long", "<data_type>");
		hm.put("byte", "<data_type>");
		hm.put("boolean", "<data_type>");
		hm.put("double", "<data_type>");
		hm.put("=", "<assignment_operator>");
		hm.put("+", "<assignment_operator>");
		hm.put("-", "<assignment_operator>");
		hm.put("%", "<assignment_operator>");
		hm.put("+=", "<assignment_operator>");
		hm.put("-=", "<assignment_operator>");
		hm.put("*=", "<assignment_operator>");
		hm.put("/=", "<assignment_operator>");
		hm.put("/", "<assignment_operator>");
		hm.put(";", "<delimiter>");
		
		String str = input;
        Pattern pattern = Pattern.compile("\".*?\"");
        Matcher matcher = pattern.matcher(str);

        List<String> quotes = new ArrayList<>();
        StringBuffer buffer = new StringBuffer();

        while (matcher.find()) 
        {
            String quote = matcher.group();
            int length = quote.length();
            quotes.add(quote.substring(1, length - 1));
            matcher.appendReplacement(buffer, "<value>");
        }
        matcher.appendTail(buffer);
        
        String trim = buffer.toString().trim().replaceAll("\\s{2,}", " ");
        String[]stringList= trim.split(" ");

        for (String a : quotes)
        {
        	hm.put(a, "<value>");
        	this.value = "String";
        }
		
        for(String a : stringList) 
		{
        	if (a.matches("[0-9]+")) 
			{
				tokenList.add("<value>");
				this.value = a;
			}
			else if (a.contains("\'"))
			{
				tokenList.add("<value>");
				this.value = "char";
			}
			else if((hm.get(a)) == "<data_type>")
			{
				tokenList.add("<data_type>");
				this.dataType = a;
			}
			else if(hm.get(a) == "<assignment_operator>")
			{
				tokenList.add("<assignment_operator>");
			}
			else if(a.equals("<value>"))
			{
				tokenList.add("<value>");
			}
			else if(a.equals("true") || a.equals("false"))
			{
				tokenList.add("<value>");
				this.value = "boolean";
			}
			else if(hm.get(a) == "<delimiter>")
			{
				tokenList.add("<delimiter>");
			}
			
			else 
			{
				tokenList.add("<identifier>");
			}
			
		}
		for(String a : tokenList)
		{
			output += a;
		}
		return output.replaceAll("null", "");
		
	}
	public String getDataType()
	{
		return dataType;
		
	}
	public String getValue()
	{
		return value;
		
	}
}
	


