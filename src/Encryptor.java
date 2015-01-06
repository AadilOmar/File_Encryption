import java.util.ArrayList;

//remember caps

/*
 * 
 * gets created. Takes letter from test and adds the index that the code letter is in in the array to it
 * 
 */
public class Encryptor {

	String oldText;
	String code;
	String newText="";
	
	ArrayList<String> listArray = new ArrayList();
	char[] array = new char[55];
	
	//first 26 are letters
	//next 10 are numbers 0-9
	//next are symbols 
	
	
	public Encryptor(){
		
		
		
		System.out.println();
		createStructure();
		
	}
	
	public void read(){
		
	}
	
	//	test  "my name is aadil omar"
	//	code  "stuf"
	
	public String encrypt(String test, String code){
		newText="";
		this.oldText=test;
		this.code=code;
		System.out.println(test);
		System.out.println(code);
		String textLetter;
		String codeLetter;
		int index;
		int xcode=0;
		
		int buf1;
		int buf2;
		
		int structureIndex;
		String structureString;
		
		for(int x=0;x<test.length();x++,xcode++){ 
			//System.out.println("textChar "+test.charAt(x)+" passchar "+code.charAt(xcode));
			
			if(xcode==code.length()){			
				xcode=0;
			}
			textLetter=test.charAt(x)+"";
			codeLetter=code.charAt(xcode)+"";
			
			//bufs are indexof text/codeletters
			buf1=listArray.indexOf(textLetter)+1;
			buf2=listArray.indexOf(codeLetter)+1;


			structureIndex=buf1+buf2;
			
			System.out.print("buf "+buf1+" ");
			System.out.println("buf "+buf2);
			
			if(structureIndex>array.length-1){
				structureIndex=structureIndex-array.length;
			}
			System.out.println("structureindex "+structureIndex);

			structureString=listArray.get(structureIndex);
			newText+=structureString;
			
		}
		System.out.println("encrypted code: "+newText);
		return newText;
	}
	
	public String decrypt(String text, String code1){
		this.newText="";
		this.code=code1;
		this.oldText=text;
		String textLetter;
		String codeLetter;
		int index;
		int xcode=0;
		
		int buftxt;
		int bufcode;
		
		int structureIndex;
		String structureString;
		
		for(int x=0;x<oldText.length();x++,xcode++){ 
			if(xcode==code.length()){			
				xcode=0;
			}
			textLetter=oldText.charAt(x)+"";
			codeLetter=code.charAt(xcode)+"";
			
			//bufs are indexof text/codeletters
			buftxt=listArray.indexOf(textLetter)+1;
			bufcode=listArray.indexOf(codeLetter)+1;

			structureIndex=buftxt-bufcode;
			
			System.out.print("buf "+buftxt+" ");
			System.out.println("buf "+bufcode);
			
			if(structureIndex<1){
				//structureIndex=array.length;
				newText+=" ";
			}
			else{
				System.out.println("structureindex "+structureIndex);
	
				structureString=listArray.get(structureIndex);
				newText+=structureString;
			}
			
		}
		System.out.println("DECRYPTED code: "+newText);
		return newText;
		
	}
	
	public void createStructure(){
		for(int x=0;x<26;x++){
			char q = (char) ('a'+x);
			String w=""+q;
			listArray.add(w);
		}
		for(int x=26;x<36;x++){
			char q = (char) ('0'+x-26);
			String w=""+q;
			listArray.add(w);
		}
		//starts from top. goes down with all shift keys
		listArray.add("!");
		listArray.add("@");
		listArray.add("#");
		listArray.add("$");
		listArray.add("%");
		listArray.add("^");
		listArray.add("&");
		listArray.add("*");
		listArray.add("(");
		listArray.add(")");
		listArray.add("_");
		listArray.add("+");
		listArray.add("{");
		listArray.add("}");
		listArray.add(":");
		listArray.add("'");//shouldve been double but too much of a pain
		listArray.add("<");
		listArray.add(">");
		listArray.add("?");

		for(int x=0;x<listArray.size();x++){
			System.out.println(listArray.get(x)+" "+listArray.size());
		}


		
		
	}
	
	
	
}


//array[36]='!';
//array[37]='@';
//array[38]='#';
//array[39]='$';
//array[40]='%';
//array[41]='^';
//array[42]='&';
//array[43]='&';
//array[44]='*';
//array[45]='(';
//array[46]=')';
//array[47]='_';
//array[48]='+';
//array[49]='{';
//array[50]='}';
//array[51]=':';
//array[52]='"';
//array[53]='<';
//array[54]='>';
//array[55]='?';
