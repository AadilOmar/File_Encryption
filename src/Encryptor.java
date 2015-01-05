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
	char[] array = new char[56];
	
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
			if(xcode==code.length()){			
				xcode=0;
			}
			textLetter=test.charAt(x)+"";
			codeLetter=code.charAt(xcode)+"";
			
			//bufs are indexof text/codeletters
			buf1=listArray.indexOf(textLetter);
			buf2=listArray.indexOf(codeLetter);
//
//
//			System.out.println("textLetter: "+textLetter);
//			System.out.println("codeLetter: " +codeLetter);
//
//			
//			
			
			
//			for(int t=0;t<listArray.size();t++){
//				if(x<10){
//					System.out.print(listArray.get(t)+" ");
//				}
//				else{
//					System.out.print(listArray.get(t) + "  ");
//				}
//			}
//			System.out.println();

			structureIndex=buf1+buf2;
			
			System.out.print("buf "+buf1+" ");
			System.out.println("buf "+buf2);
			
			if(structureIndex>array.length){
				structureIndex=structureIndex-array.length;
			}
			System.out.println("structureindex "+structureIndex);

			structureString=listArray.get(structureIndex);
			newText+=structureString;
			
//			for(int y=0;y<array.length;y++){
//				if(codeLetter==array[y]){
//					structureIndex=y;
//				}
//			}
		}
		System.out.println("encrypted code: "+newText);
		return newText;
	}
	
	public void decrypt(String text, String code1){
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
			buftxt=listArray.indexOf(textLetter);
			bufcode=listArray.indexOf(codeLetter);
//
//
//			System.out.println("textLetter: "+textLetter);
//			System.out.println("codeLetter: " +codeLetter);
//
//			
//			
			
			
//			for(int t=0;t<listArray.size();t++){
//				if(x<10){
//					System.out.print(listArray.get(t)+" ");
//				}
//				else{
//					System.out.print(listArray.get(t) + "  ");
//				}
//			}
//			System.out.println();

			structureIndex=buftxt-bufcode;
			
			System.out.print("buf "+buftxt+" ");
			System.out.println("buf "+bufcode);
			
			if(structureIndex<0){
				//structureIndex=array.length;
				newText+=" ";
			}
			else{
				System.out.println("structureindex "+structureIndex);
	
				structureString=listArray.get(structureIndex);
				newText+=structureString;
			}
			
//			for(int y=0;y<array.length;y++){
//				if(codeLetter==array[y]){
//					structureIndex=y;
//				}
//			}
		}
		System.out.println("DECRYPTED code: "+newText);
		
		
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



//
//		for(int x=0;x<listArray.size();x++){
//			if(x<10){
//				System.out.print(listArray.get(x)+" ");
//			}
//			else{
//				System.out.print(listArray.get(x) + "  ");
//			}
//		}
//		System.out.println();
//		for(int x=0;x<listArray.size();x++){
//			System.out.print(x+" ");
//		}
//		System.out.println();
//		System.out.println();
		
		
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
