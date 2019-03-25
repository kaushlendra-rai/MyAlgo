package com.kausha.algo.ds2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;

import javax.swing.plaf.TreeUI;

import com.kausha.algo.ds.DSUtil;
import com.kausha.algo.ds.TreeNode;

public class SerializeAndDeserializeATree{
	private static final String marker = "#";
	private static final String delimeter = " ";
	public static int index=0;	
	public static void main(String[] args)  throws Exception{
		String fileName = "C://kaushal//workspace//Mytest//data//BinaryTree.ser"; 
		TreeNode node = DSUtil.getBinaryTree();
		StringBuilder content = new StringBuilder();
		getFlatBinaryTreeRepresentation(node, content);
		
		writeToFile(content.toString(), fileName);
		
		String fileContent = readFromFile(fileName);
		System.out.println(fileContent);
		TreeNode treeNode = new TreeNode();
		loadBinaryTree(fileContent.split(delimeter), 0, treeNode);
		System.out.println("\nOriginal::");
		DSUtil.printTree(node);
		System.out.println("\nProcessed::");
		DSUtil.printTree(treeNode);
	}
	
	private static TreeNode loadBinaryTree(String[] fileContent, int index1, TreeNode treeNode) {
		if(index == fileContent.length)
			return null;
		
		treeNode.setValue(Integer.parseInt(fileContent[index]));
		
		if(!marker.equals(fileContent[++index])){
			TreeNode left = loadBinaryTree(fileContent, index, new TreeNode());
			treeNode.left = left;
		}
		
		if(!marker.equals(fileContent[++index])){
			TreeNode right = loadBinaryTree(fileContent, index, new TreeNode());
			treeNode.right = right;
		}
		return treeNode;
	}

	private static void getFlatBinaryTreeRepresentation(TreeNode node, StringBuilder content) {
		if(node == null)
			content.append(marker).append(delimeter);
		else{
			content.append(node.value).append(delimeter);
			getFlatBinaryTreeRepresentation(node.left, content);
			getFlatBinaryTreeRepresentation(node.right, content);
		}
	}

	private static void writeToFile(String content, String fileName){
		FileOutputStream fop = null;
		File file;
		
		try {

			file = new File(fileName);
			fop = new FileOutputStream(file);

			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}
			
			fop.write(content.getBytes());
			fop.flush();
			fop.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	private static String readFromFile(String fileName) throws Exception{
		FileInputStream fisData = new FileInputStream(fileName);
		BufferedReader reader = new BufferedReader(new InputStreamReader(fisData));
		
		StringBuilder fileContent = new StringBuilder();
		String line;
	    while((line = reader.readLine()) != null){
	    	fileContent.append(line);
	    }
	    
	    reader.close();
	    fisData.close();
	    
	    return fileContent.toString();
	}
}