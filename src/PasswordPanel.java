import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class PasswordPanel extends JPanel implements ActionListener{
	
	String p1 = "";
	String p2 = "";
	JLabel text;
	JLabel pass1;
	JLabel pass2;
	JButton save1;
	JButton save2;
	JTextField passField1;
	JTextField passField2;
	JFrame frame;
	String totalText;
	File file;
	
	public PasswordPanel(JFrame frame,String text, File file){
		System.out.println("IN CONSTRUCTIR");
		totalText = text;
		this.file = file;
		this.frame = frame;
		this.setBackground(Color.BLACK);
		addComponents();
	}
	public void addComponents(){
		GridBagConstraints c = new GridBagConstraints();
		this.setLayout(new GridBagLayout());
		
		c.gridx = 0;
		c.gridy = 0;
		text=new JLabel();
		text.setFont(new Font("monaco", 3, 40));
		text.setText("Enter Password(s) to Encrypt");
		this.add(text,c);
		
		c.gridx = 0;
		c.gridy = 2;
		pass1=new JLabel();
		pass1.setFont(new Font("monaco", 3, 40));
		pass1.setText("Enter Password 1");
		this.add(pass1,c);
		
		c.gridx = 0;
		c.gridy = 3;
		pass2=new JLabel();
		pass2.setFont(new Font("monaco", 3, 40));
		pass2.setText("Enter Password 2");
		this.add(pass2,c);

		
		c.gridx = 1;
		c.gridy = 2;
		passField1 = new JTextField();
		passField1.setForeground(Color.BLACK);
		passField1.setBackground(Color.blue);
		passField1.setText("type something");		
		this.add(passField1,c);
		passField1.addActionListener(this);
		
		c.gridx = 1;
		c.gridy = 3;
		passField2 = new JTextField();
		passField2.setForeground(Color.BLACK);
		passField2.setBackground(Color.blue);
		passField1.setBounds(passField1.getX(), passField1.getY(), 40, 40);
		passField2.setText("type something");
		this.add(passField2,c);
		passField2.addActionListener(this);
		
		c.gridx = 2;
		c.gridy = 2;
		save1=new JButton();
		save1.setText("Save and overwrite");
		this.add(save1,c);

//		c.gridx = 2;
//		c.gridy = 3;
//		save2 = new JButton();
//		save2.setText("Save as");
//		this.add(save2,c);
		addActionListeners();
		
	}
	public void addActionListeners(){
		save1.addActionListener(this);
		//save2.addActionListener(this);	
	}
	public void encrypt(String password){
		Encryptor e = new Encryptor();
		System.out.println("TOTALSSS "+totalText);
		totalText = e.encrypt(totalText, password);
		System.out.println("TOTALSSS "+totalText);
	}
	public void decrypt(String password){
		Encryptor e = new Encryptor();
		totalText = e.decrypt(totalText, password);
		System.out.println("OMGPLZ "+totalText);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("PERFORMED ACTION");
		p1 = passField1.getText();
		p2 = passField2.getText();
		
		if(e.getSource().equals(save1)){
			System.out.println("save1");
			if(!p1.equals("type something")){
				encrypt(p1);
				decrypt(p1);
			}
			if(!p2.equals("type something")){
				encrypt(p2);
			}
			System.out.println(totalText);
		}
//		else if(e.getSource().equals(save2)){
//			System.out.println("save2");
//		}
	}
}
