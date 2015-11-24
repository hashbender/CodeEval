package com.nickh.easy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * 
 * @author nick.hansen
 *
 */
public class FizzBuzz {
    public static void main (String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();
            int length = Integer.parseInt(line.split(" ")[2]);
            int div1 = Integer.parseInt(line.split(" ")[0]);
            int div2 = Integer.parseInt(line.split(" ")[1]);
            StringBuilder builder = new StringBuilder();
            for (int i = 1; i <= length; i++){
            	if (i%div1 == 0 && i%div2 ==0) builder.append("FB ");
            	else if (i%div1 == 0 ) builder.append("F ");
            	else if (i%div2 == 0 ) builder.append("B ");
            	else builder.append(i).append(" ");
            }
            builder.deleteCharAt(builder.length()-1);
            System.out.println(builder.toString());
        }
        buffer.close();
    }
    
}
