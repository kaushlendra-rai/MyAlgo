package com.kausha.concurrency;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class SearchTextInFolderContent {

	private static boolean explorationDone = false;
	
	public static boolean isExplorationDone() {
		return explorationDone;
	}

	public static void setExplorationDone(boolean explorationDone) {
		SearchTextInFolderContent.explorationDone = explorationDone;
	}

	public static void main(String[] args) {
		
		//SearchTextInFolderContent searchTextInFolderContent = new SearchTextInFolderContent();
		BlockingQueue<File> queue = new LinkedBlockingQueue<File>(); 
		//String path = "C:\\kaushal\\New folder\\Mytest\\src\\com\\kausha\\design";
		String path = "C:\\MyPersonal\\TestArea\\src\\com\\sas\\rai\\kaushal\\geeks";
		String expression = "ExecutorService";
		exploreFolders(path, queue);
		int temp = 0;
		while(temp < 20){
			searchContent(queue, expression);
			temp++;
		}
	}

	private static List<String> searchContent(BlockingQueue<File> queue, String query) {
		ExecutorService service = Executors.newFixedThreadPool(5);
		
		//File file = queue.take();
		Runnable fileSearcher = new FileSearcher(queue, query);
		service.execute(fileSearcher);
		return null;
	}

	private static void exploreFolders(String path, BlockingQueue<File> queue) {
		ExecutorService service = Executors.newSingleThreadExecutor();
		Runnable exploreFiles = new FileExplorer(queue, path);
		service.execute(exploreFiles);
		
		service.shutdown();
		
	}
}

class FileSearcher implements Runnable{
	private BlockingQueue<File> queue;
	private String query;
	
	public FileSearcher(BlockingQueue<File> queue, String query){
		this.queue = queue;
		this.query = "*" + query + "*";
	}
	
	public void run() {
		try{
			File file = queue.take();
		System.out.println("Searching in File = " + file.getName());	
			// Load file content
			Scanner scanner = new Scanner(file);
			scanner.useDelimiter("\n");
			int lineNumber = 1;
		
			
			while(scanner.hasNext()){
				String line = scanner.next();
				
				boolean matchFound = matchRegularExpression(query, line, 0, 0);
				if(matchFound){
					System.out.println("Match Found in File = "  + file.getName() + "  , path = " + file.getAbsolutePath() + "  , Line number = " + lineNumber);
				}
				lineNumber++;
			}
		}catch(InterruptedException e){
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private static boolean matchRegularExpression(String expression, String line, int queryIndex, int lineIndex) {
		boolean matchFound = false;
		// Terminal Condition
		// If the String has so far matched and last character of query is '*', return match Found = true
		
		if(expression.length()-1 == queryIndex && expression.charAt(queryIndex) == '*')
			return true;
		
		if(queryIndex == expression.length() && lineIndex <= line.length())
			return true;
		
		if(queryIndex < expression.length() && lineIndex == line.length())
			return false;
		
		if(queryIndex == expression.length() || lineIndex == line.length())
			return false;
		
		if(expression.charAt(queryIndex) == '*'){
			matchFound = matchRegularExpression(expression, line, queryIndex, lineIndex + 1);
			
			if(!matchFound)
				matchFound = matchRegularExpression(expression, line, queryIndex+1, lineIndex);
		}else if(expression.charAt(queryIndex) == '?'){
			matchFound = matchRegularExpression(expression, line, queryIndex+1, lineIndex + 1);
		}else if(expression.charAt(queryIndex) == line.charAt(lineIndex)){
			matchFound = matchRegularExpression(expression, line, queryIndex+1, lineIndex + 1);
		}
		
		return matchFound;
	}
}

class FileExplorer implements Runnable{
	private BlockingQueue<File> queue;
	private String path;
	
	
	public FileExplorer(BlockingQueue<File> queue, String path){
		this.queue = queue;
		this.path = path;
	}
	
	public void run(){
		File file = new File(path);
		
		try{
			explore(queue, file);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	
	private void explore(BlockingQueue<File> queue, File file) throws InterruptedException{
		if(file.isDirectory()){
			File[] files =  file.listFiles();
			
			if(files != null && files.length > 0){
				for(File subFile : files){
					if(subFile.isDirectory()){
						explore(queue, subFile);
					}else if(subFile.isFile()){
						queue.put(subFile);
						System.out.println("Adding File 1 = " + subFile.getName());
					}
				}
			}
		}else if(file.isFile()){
			System.out.println("Adding File 2 = " + file.getName());
			queue.put(file);
		}
	}
}