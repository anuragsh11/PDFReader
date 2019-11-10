import java.io.FileInputStream;
import java.io.*;
import java.io.InputStream;

import org.apache.tika.metadata.*;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.sax.BodyContentHandler;


public class ReaderPdf {

	public static void main(String[] args) {
		ReaderPdf read = new ReaderPdf();
		read.convertPdf("C:/Users/anuragsh/Desktop/VFUS_68302_1000027986_ENG_D_Statement_20171101_20180104_171054.pdf");

	}

	private void convertPdf(String fileName)
	{
		// TODO Auto-generated method stub
		InputStream stream =null;
		try
		{
			stream = new FileInputStream(fileName);
			AutoDetectParser parser = new AutoDetectParser();
			BodyContentHandler handler =new BodyContentHandler(-1);
			Metadata metadata = new Metadata();
			parser.parse(stream, handler, metadata, new ParseContext());
			
			//System.out.println(handler.toString());
			PrintWriter out = new PrintWriter(new FileWriter("C:/Users/anuragsh/Desktop/output1.txt"));
			out.println(handler.toString());
			out.close();
		}
		catch( Exception e)
		{
			e.printStackTrace();
		}	finally {
			if (stream !=null)
				try{
					stream.close();
					}
					catch (IOException e)
					{
						System.out.println("Error in closing");
					}
				}
	}
}

