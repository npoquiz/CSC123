package com.usman.csudh.bank.core;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.File;

public class FileHook extends CurrencyReader{

	protected InputStream getInputStream()throws Exception {
		return new FileInputStream(new File("exchange-rate.csv"));
	}


}