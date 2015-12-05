package com.nickh.moderate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author nick.hansen
 *
 */
public class StackImplementation {
	public static void main(String[] args) throws IOException {
		// File file = new File(args[0]);
		// BufferedReader buffer = new BufferedReader(new FileReader(file));
		// TODO uncomment this for local testing
		BufferedReader buffer = new BufferedReader(new InputStreamReader(
				System.in));
		String line;
		while ((line = buffer.readLine()) != null && line.length() > 0) {
			line = line.trim();
			List<String> input = new ArrayList<String>(Arrays.asList(line
					.split(" ")));
			StringBuilder builder = new StringBuilder();
			for (int i = input.size() - 1; i >= 0; i -= 2) {
				builder.append(input.get(i) + " ");
			}
			System.out.println(builder.toString().trim());
		}
		buffer.close();
	}
}
