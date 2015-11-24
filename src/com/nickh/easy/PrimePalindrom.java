package com.nickh.easy;

import java.io.IOException;

public class PrimePalindrom {
    public static void main (String[] args) throws IOException {
    	for (int i = 1; i <= 12; i++){
    		StringBuilder b = new StringBuilder();
    		for(int j =1; j<=12; j++){
    			b.append(j*i+" ");
    		}
    		System.out.println(b.toString().trim());
    	}
    }
    
}
