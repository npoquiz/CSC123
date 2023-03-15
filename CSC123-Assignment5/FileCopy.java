 //Nathan Poquiz (npoquiz1@toromail.csudh.edu)
import java.io.*;
import java.lang.*;
public class FileCopy {
	public static void main(String args[]) throws IOException{
		try {
		File sourceFile = new File(args[0]);
        File targetFile = new File(args[1]);
		if (targetFile.exists())
		{
			System.out.println("Error, file exists");
		}
        targetFile.getParentFile().mkdirs();
        targetFile.createNewFile();
		
		
			FileInputStream in = new FileInputStream(sourceFile);
	    	FileOutputStream out = new FileOutputStream(targetFile);
		
		 int byteRead = -1;
		 
         while ((byteRead = in.read()) != -1) 
         {
             out.write(byteRead);
         }

		} catch (FileNotFoundException e) {
			System.out.println("Error, file not found");
		} catch (ArrayIndexOutOfBoundsException exception) {
			System.out.println("Error, argument missing");
		}
		
	}
}
