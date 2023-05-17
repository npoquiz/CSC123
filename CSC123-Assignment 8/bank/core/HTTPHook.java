package com.usman.csudh.bank.core;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class HTTPHook extends CurrencyReader {

	protected InputStream getInputStream() throws Exception {
		Socket socket = new Socket("www.usman.cloud", 80);

		OutputStream out = socket.getOutputStream();
		out.write("GET /banking/exchange-rate.csv HTTP/1.1\r\n".getBytes());
		out.write("Host: www.usman.cloud\r\n".getBytes());
		out.write("\r\n".getBytes());

		return socket.getInputStream();
	
	}

}