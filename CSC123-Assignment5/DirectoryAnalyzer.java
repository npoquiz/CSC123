import java.io.*;
import java.lang.*;
import java.util.*;
public class DirectoryAnalyzer {
	public static void main(String args[]) {
	try {
		File folder = new File(args[0]);
		File[] list = folder.listFiles();
		
		ArrayList<String> files = new ArrayList<String>();
		ArrayList<Long> size = new ArrayList<Long>();
		
		int totalFiles = 0;
		
		for (File file : list) {
		    if (file.isFile()) {
		        files.add(file.getName());
		        size.add(file.length());
		    }    
		}	
		
		for (File file : list) {
		    if (file.isFile()) {
		        System.out.println("File name: " + file.getName() + " ------ Size: " + file.length() + " bytes");
		    }    
		}	
		
		for (int i = 0; i < files.size(); i++)
		{
			totalFiles = i;
		}
		
		System.out.println("Total Files: " + totalFiles);
		
	}  catch (ArrayIndexOutOfBoundsException exception) {
		System.out.println("Error, argument missing");

	}
	
	
}
}