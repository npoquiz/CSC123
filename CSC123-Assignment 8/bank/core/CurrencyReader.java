package com.usman.csudh.bank.core;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public abstract class CurrencyReader {

	public static CurrencyReader getInstance(String type) throws Exception{
		if(type.equalsIgnoreCase("file")) {
			return new FileHook();
		}
		else if(type.equalsIgnoreCase("webservice")) {
			return new HTTPHook();
		}
		else {
			throw new Exception("Type "+type+ " not understood!");
		}
	}
		
	public ArrayList<String> readCurrencies() throws Exception{
		InputStream in=getInputStream();
		BufferedReader br=new BufferedReader(new InputStreamReader(in));
		
		ArrayList<String> list=new ArrayList<String>();
		
		String line=null;
		while((line=br.readLine())!=null) {
			list.add(line);
		}
		
		return list;
		
	}
	
	protected abstract InputStream getInputStream() throws Exception; 
	

}