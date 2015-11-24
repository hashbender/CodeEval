package com.nickh.moderate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * 
Given a sequence, write a program to detect cycles within it.

INPUT SAMPLE:

Your program should accept as its first argument a path to a filename containing a sequence of numbers (space delimited). The file can have multiple such lines. E.g



1
2
3
2 0 6 3 1 6 3 1 6 3 1
3 4 8 0 11 9 7 2 5 6 10 1 49 49 49 49
1 2 3 1 2 3 1 2 3
OUTPUT SAMPLE:

Print to stdout the first cycle you find in each sequence. Ensure that there are no trailing empty spaces on each line you print. E.g.



1
2
3
6 3 1
49
1 2 3
The cycle detection problem is explained more widely on wiki 
Constrains: 
The elements of the sequence are integers in range [0, 99] 
The length of the sequence is in range [0, 50]
 * 
 * @author nick.hansen
 *
 */
public class DetectingCycles {

	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		// TODO uncomment this for local testing
		//		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		String line;
		while ((line = buffer.readLine()) != null && line.length() > 0) {
			line = line.trim();
			List<String> input = new ArrayList<String>(Arrays.asList(line.split(" ")));
			List<String> cycle = new ArrayList<String>();
			if (input.get(0).length() > 0){
				boolean foundCycle = false;
				for (int i = 0; i<input.size(); i++){
					if (foundCycle) break;
					String string = input.get(i);
					if (input.subList(i + 1, input.size()).contains(string)){
						//we have the start of a cycle somewhere
						cycle.add(string);
						List<String> subList = input.subList(i + 1,  input.size());
						for (String subString : subList){
							//if the cycle contains an item in our sublist, the cycle is complete
							if (cycle.contains(subString)) {
								foundCycle = true;
								break;
							} else
								cycle.add(subString);
						}
					}
				}
			}
			printArray(cycle);
		}
		buffer.close();
	}
	
	public static void printArray(List<String> ar) {
		StringBuilder builder = new StringBuilder();
		for (String n : ar) 
			builder.append(n + " ");
		System.out.println(builder.toString().trim());
	}

}
