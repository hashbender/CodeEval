package com.nickh.moderate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 
 * @author nick.hansen
 *
 */
public class PassTriangle {
	public static void main(String[] args) throws IOException {
		//File file = new File(args[0]);
		//BufferedReader buffer = new BufferedReader(new FileReader(file));
		// TODO uncomment this for local testing
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		String line;
		List<List<Integer>> pyramid = new ArrayList<List<Integer>>();
		while ((line = buffer.readLine().trim()) != null && line.length() > 0) {
			List<String> inputStrings = new ArrayList<String>(Arrays.asList(line.split(" ")));
			List<Integer> input = new ArrayList<Integer>();
			for (String inputString : inputStrings)
				
				input.add(Integer.parseInt(inputString));
			pyramid.add(input);
		}
		int sum = 0;
		int rowAboveIndex = 0;
		Collections.reverse(pyramid);
		rowAboveIndex = pyramid.get(0).indexOf(Collections.max(pyramid.get(0)));
		
		for (List<Integer> row: pyramid){
			int left = rowAboveIndex - 1;
			int right = rowAboveIndex; 
			if (left < 0) {
				sum += row.get(right);
			} else if (row.get(right) > row.get(left)){
				sum += row.get(right);
			} else if (row.get(left) > row.get(right)){
				rowAboveIndex = left;
				sum += row.get(left);
			} else if (row.get(left) == row.get(right)){
				//TODO fuck
				throw new RuntimeException();
			}
		}
		System.out.println(sum);
		buffer.close();
	}
}
