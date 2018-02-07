package com.Ebu;

public class EnCryption {
	
	public void Encrypt(String s ){
		String ans="";
		char a[]=s.toCharArray();
		for(char c : a){
			if(c<'C')
				ans=ans+(char)(c+23);
			else ans=ans+(char)(c-3);
		}
		System.out.println(ans);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EnCryption ob=new EnCryption();
		ob.Encrypt("ASDFGHJJ");
	}

}
