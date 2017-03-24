package com.p.num;

import java.io.File;

public class NumTest {

	
	public static void main(String[] args) {/*
		int[] nums={4501,4921,5341};
		
		for(int num:nums){
			System.out.println("==================>>>>>>>>>>>>>>>");
			for(int divisor=2;divisor<11;divisor++){
				float rest=((num%divisor));
				if(rest==((float)1)){
					System.out.println(num +" is multiple of "+divisor+" continue..");
				}else{
					break;
				}
				System.out.println(num+" modulus "+divisor +"  ==  "+rest );
			}
		}
		
	*/
	File f=new File("");
	File[] children=f.listFiles();
	if(children!=null && children.length>0){
		for(File child:children){
			if(child!=null&&child.exists()){
				if(child.isFile()&&child.getName().endsWith(".jsp")){
					System.out.println(child.getName());
					
				}
			}
		}
	}
	
//	f.listFiles()
	}
	
	
	public static int sum(int i1,int i2){
		return i1+i2;
	}
}