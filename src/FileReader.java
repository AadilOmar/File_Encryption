import java.awt.Dimension;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;


public class FileReader {

	public  boolean toBeEncrypted;
	public static JFrame frame;
	
	public FileReader(boolean toEncrypt,JFrame frame){
		toBeEncrypted=toEncrypt;
		this.frame=frame;
	}
	
	public static String readFile() throws IOException{
		File file = new File("aazaaz.txt");
		Scanner read = new Scanner(file);
		String line = read.nextLine();
		System.out.println("line of text "+line);
		
		
		
		JFileChooser chooser = new JFileChooser();
		int returnValue=chooser.showOpenDialog(frame);
		File file1 = chooser.getSelectedFile();
		FileInputStream stream = new FileInputStream(file1.getAbsolutePath());


		System.out.println("0000000000");
		String totalText = null;
		if(returnValue==chooser.APPROVE_OPTION){
			
			System.out.println("1111111111");
			XWPFDocument document = new XWPFDocument(stream);
			System.out.println("222222222");

			XWPFWordExtractor extractor = new XWPFWordExtractor(document); ;
			System.out.println("333333333");

			totalText = extractor.getText();
			System.out.println(totalText);
			chooser.setVisible(false);
//			String fileName = chooser.getSelectedFile().getAbsolutePath();
//			System.out.println("FILENAME!!"+fileName);
//			Scanner read = new Scanner(file1);	
//			String line = read.nextLine();
			

		}
		else{
			
		}
		return totalText;

		
		
	}
	
	
}
