package com.nickh.easy;

import java.io.IOException;

public class MultiplicationTable {
    public static void main (String[] args) throws IOException {
    	for (int i = 1; i <= 12; i++){
    		for(int j =1; j<=12; j++){
        		System.out.format("%4d", i*j);
    		}
    		System.out.println();
    	}
    }
    
}
