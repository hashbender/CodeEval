package com.nickh.moderate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LowestCommonAcestor {

	public static class BinaryTreeNode {
		public BinaryTreeNode left;
		public BinaryTreeNode right;
		public int data;

		public BinaryTreeNode(int data) {
			this.data = data;
		}
	}

	public static boolean buildHeirarchy(List<Integer> list, int toFind, BinaryTreeNode tree) {
		if (tree == null)
			return false;

		if (tree.data == toFind)
			return true;

		if (buildHeirarchy(list, toFind, tree.left)) {
			list.add(tree.data);
			return true;
		}
		if (buildHeirarchy(list, toFind, tree.right)) {
			list.add(tree.data);
			return true;
		}
		return false;
	}

	public static void main(String[] args) throws IOException {
		/* this is dumb */
		BinaryTreeNode root = new BinaryTreeNode(30);
		root.left = new BinaryTreeNode(8);
		root.right = new BinaryTreeNode(52);
		BinaryTreeNode left = root.left;
		left.left = new BinaryTreeNode(3);
		left.right = new BinaryTreeNode(20);
		BinaryTreeNode right = left.right;
		right.left = new BinaryTreeNode(10);
		right.right = new BinaryTreeNode(29);

		// File file = new File(args[0]);
		// BufferedReader buffer = new BufferedReader(new FileReader(file));
		// TODO uncomment this for local testing
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		String line;
		while ((line = buffer.readLine()) != null && line.length() > 0) {
			line = line.trim();
			List<String> input = new ArrayList<String>(Arrays.asList(line.split(" ")));
			List<Integer> list1 = new ArrayList<Integer>();
			List<Integer> list2 = new ArrayList<Integer>();
			int in = Integer.parseInt(input.get(0));
			int in2 = Integer.parseInt(input.get(1));
			if (in == root.data || in2 == root.data) {
				System.out.println(root.data);
			} else {
				buildHeirarchy(list1, in, root);
				buildHeirarchy(list2, in2, root);
				list1.retainAll(list2);
				System.out.println(list1.get(0));
			}
		}
		buffer.close();
	}
}
