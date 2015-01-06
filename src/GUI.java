import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.io.*;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.*;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;




















import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class GUI  {

	static String s = "q";
	static Boolean toEncrypt;
	static Boolean toContinue=false;
	static String test = "something";
	static String code1;
	static String codde2;
	
	static Scanner scan = new Scanner(System.in);
	static JFrame frame = new JFrame();
	static JPanel mainPanel = new JPanel();
	
	static JButton encryptButton = new JButton();
	static JButton decryptButton = new JButton();
	static Object lock;
	private static String totalText;
	static FileReader reader;
	static File file;
	
	public GUI(){
		
	}
	public static void main(String[]args) throws IOException, InterruptedException{
		
		lock = new Object();
		GUI graphics= new GUI();
		graphics.createMainScreen();
		synchronized (toContinue) {
			while (!toContinue) {
			      toContinue.wait();
			      toContinue=true;
			}
		}
		
			
			reader = new FileReader(toEncrypt, frame);
			try {
				totalText=reader.readFile();
				file = reader.getFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		graphics.createPasswordScreen();
	
	
	}
	public void createPasswordScreen(){
		System.out.println("IN CREATEPASSSCREEN");
		GridBagConstraints c= new GridBagConstraints();
		JPanel passwordPanel = createPasswordPanel();
		
		frame.setFocusable(true);
		frame.getContentPane().removeAll();
		frame.setLayout(new GridLayout());
		frame.add(passwordPanel,c);
		frame.revalidate();
		frame.repaint();
		
	}
	public JPanel createPasswordPanel(){
		System.out.println("EARLY TOTAL "+totalText);
		PasswordPanel passwordPanel = new PasswordPanel(frame,totalText,file);
		return passwordPanel;
		
	}
	public void createMainScreen() throws IOException{
		GridBagConstraints c = new GridBagConstraints();
		
		frame.setLayout(new GridBagLayout());
		frame.setVisible(true);
		frame.setBackground(Color.black);
		frame.setExtendedState(frame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		
		
		
		c.gridx=3;
		c.gridy=1;
		c.gridwidth=3;
		mainPanel.setBackground(Color.black);
		JLabel text = new JLabel();
		text.setText("WOULD YOU LIKE TO...");
		text.setFont(new Font("monaco", 3, 40));
		text.setLocation(300, 300);
		text.setForeground(Color.yellow);
		mainPanel.add(text);
		frame.add(mainPanel,c);
		
		
		c.gridx=2;
		c.gridy=3;
		c.gridwidth=2;

		encryptButton.setText("ENCRYPT A FILE");
		frame.add(encryptButton,c);
		
		c.gridx=5;
		c.gridy=3;
		c.gridwidth=2;
		c.insets=new Insets(20, 20, 20, 20);
		decryptButton.setText("DECRYPT A FILE");

		frame.getContentPane().setBackground(Color.black);
		frame.add(decryptButton,c);
		frame.revalidate();

	
		encryptButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				encryptButton.removeActionListener(this);
				decryptButton.removeActionListener(this);
				System.out.println("ENCRYPT WILL OCCUR!!");
				synchronized(toContinue){
					toEncrypt=true;
					toContinue.notify();
					
				}
				
			}
		});
		decryptButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				encryptButton.removeActionListener(this);
				decryptButton.removeActionListener(this);
				System.out.println("DECRYPT WILL OCCUR!!");
				synchronized (toContinue) {
					toEncrypt=false;
					toContinue.notify();
					
				}
			
			}
		});
		
		
	
		
	}


}
