package com.nickh.moderate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * 
 * @author nick.hansen
 *
 */
public class HappyNumbers {

	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		//		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

		String line;
		while ((line = buffer.readLine()) != null) {
			line = line.trim();
		}
		buffer.close();
	}
}
