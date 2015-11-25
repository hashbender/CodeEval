package com.nickh.moderate;

import java.io.*;
import java.util.*;

/**
 * 
 * @author nick.hansen
 *
 */
public class PassTriangle {
	public static void main(String[] args) throws IOException {
		// File file = new File(args[0]);
		// BufferedReader buffer = new BufferedReader(new FileReader(file));
		// TODO uncomment this for local testing
		BufferedReader buffer = new BufferedReader(new InputStreamReader(
				System.in));
		String line;
		List<List<Integer>> pyramid = new ArrayList<List<Integer>>();
		while ((line = buffer.readLine().trim()) != null && line.length() > 0) {
			List<String> inputStrings = new ArrayList<String>(
					Arrays.asList(line.split(" ")));
			List<Integer> input = new ArrayList<Integer>();
			for (String inputString : inputStrings)

				input.add(Integer.parseInt(inputString));
			pyramid.add(input);
		}

		for (int i = pyramid.size() - 1; i > 0; i--) {
			for (int j = 0; j < pyramid.get(i).size() - 1; j++) {
				int number = Math.max(pyramid.get(i).get(j)
						+ pyramid.get(i - 1).get(j), pyramid.get(i).get(j + 1)
						+ pyramid.get(i - 1).get(j));
				pyramid.get(i - 1).set(j, number);
			}
		}
		System.out.println(pyramid.get(0).get(0));
		buffer.close();
	}
}
