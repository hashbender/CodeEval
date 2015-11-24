package com.nickh.easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @author nick.hansen
 *
 */
public class SumOfIntegersFromFile {

	public static void main (String[] args) throws IOException {
//        File file = new File(args[0]);
//        BufferedReader buffer = new BufferedReader(new FileReader(file));
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String line;
        int sum = 0;
        while ((line = buffer.readLine()) != null && line.length() > 0) {
            sum += Integer.valueOf(line.trim());
        }
        System.out.print(sum);
        buffer.close();
    }
    
	
}
