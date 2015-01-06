import java.awt.Dimension;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;


public class FileReader {

	public  boolean toBeEncrypted;
	public static JFrame frame;
	static File file1;

	
	public FileReader(boolean toEncrypt,JFrame frame){
		toBeEncrypted=toEncrypt;
		this.frame=frame;
	}
	public static String writeFile(String toWrite) throws IOException{
		try {
            //Whatever the file path is.
            FileOutputStream is = new FileOutputStream(file1);
            OutputStreamWriter osw = new OutputStreamWriter(is);    
            Writer w = new BufferedWriter(osw);
            w.write(toWrite);
            w.close();
        } catch (IOException e) {
            System.err.println("Problem writing to the file statsTest.txt");
        }
		return null;
	}
	public static String readFile() throws IOException{

		System.out.println("11111");
		
		String totalString = "";
		JFileChooser chooser = new JFileChooser();
		int returnValue=chooser.showOpenDialog(frame);
		file1 = chooser.getSelectedFile();
		System.out.println("PATH "+file1.getAbsolutePath());
		System.out.println("TOSTRING "+file1.toString());
		System.out.println("222222");
		Scanner scan = new Scanner(file1);
		System.out.println("3333");
		while(scan.hasNextLine()){
			System.out.println("4444");
			totalString+=scan.nextLine();
		}
		System.out.println(totalString);
		return totalString;		
	}
	public File getFile(){
		return file1;
	}
	
	
}
