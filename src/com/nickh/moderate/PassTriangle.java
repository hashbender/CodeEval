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
public class PassTriangle {
	public static void main(String[] args) throws IOException {
		// File file = new File(args[0]);
		// BufferedReader buffer = new BufferedReader(new FileReader(file));
		// TODO uncomment this for local testing
		BufferedReader buffer = new BufferedReader(new InputStreamReader(
				System.in));
		String line;
		List<List<Integer>> pyramid = new ArrayList<List<Integer>>();
		while ((line = buffer.readLine()) != null && line.length() > 0) {
			line = line.trim();
			List<String> inputStrings = new ArrayList<String>(
					Arrays.asList(line.split(" ")));
			List<Integer> input = new ArrayList<Integer>();
			for (String inputString : inputStrings)
				input.add(Integer.parseInt(inputString));
			pyramid.add(input);
		}
		int sum = 0;
		int rowAboveIndex = 0;
		for (List<Integer> row : pyramid) {
			int left = rowAboveIndex - 1;
			int right = rowAboveIndex + 1;
			if (left < 0) {
				left = 0;
			} else if (right >= row.size()) {
				right = row.size() - 1;
			}
			int max = 0;
			for (int i = left; i != right; i++) {
				if (row.get(i) > max) {
					max = row.get(i);
					rowAboveIndex = i;
				}
			}
			sum += max;
			// the row above index needs to add 1 due to the row size increasing
			rowAboveIndex++;
		}
		System.out.print(sum);
		buffer.close();
	}
}
