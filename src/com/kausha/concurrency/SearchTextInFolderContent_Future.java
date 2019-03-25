package com.kausha.concurrency;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;

public class SearchTextInFolderContent_Future {
	public static void main(String[] args) throws InterruptedException, ExecutionException{
		//String path = "C:\\kaushal\\New folder\\Mytest\\src\\com\\kausha\\design";
		String path = "C:\\MyPersonal\\TestArea\\src\\com\\sas\\rai\\kaushal\\geeks";
		String expression = "ExecutorService";
		
		getMatchingText(path, expression);
		
	}

	public static List<String> getMatchingText(String path, String expression) throws InterruptedException, ExecutionException{
		List<String> result = null;
		BlockingQueue<File> queue = new LinkedBlockingQueue<File>();
		
		exploreFolders(path, queue);
		searchContent(queue, expression);
		
		return result;
	}
	
	private static void searchContent(BlockingQueue<File> queue, String query) throws InterruptedException, ExecutionException{
		ExecutorService service = Executors.newFixedThreadPool(5);
		
		while(true){
			File file = queue.take();
			Callable<List<String>> FileSearcher33 = new FileSearcher33(file, query);
			Future<List<String>> result = service.submit(FileSearcher33);
			
			List<String> records = result.get();

			for(String entry : records)
				System.out.println("Future :>>  " + entry);
		}
	}

	private static void exploreFolders(String path, BlockingQueue<File> queue) {
		ExecutorService service = Executors.newSingleThreadExecutor();
		Runnable exploreFiles = new FileExplorer33(queue, path);
		service.execute(exploreFiles);
		
		service.shutdown();
	}
}

class FileSearcher33 implements Callable<List<String>>{
	private File file;
	private String query;
	
	public FileSearcher33(File file, String query){
		this.file = file;
		this.query = "*" + query + "*";
	}
	
	public List<String> call() throws Exception {
		List<String> result = new ArrayList<String>();
		try{
			// Load file content
			Scanner scanner = new Scanner(file);
			scanner.useDelimiter("\n");
			int lineNumber = 1;
			
			while(scanner.hasNext()){
				String line = scanner.next();
				
				boolean matchFound = matchRegularExpression(query, line, 0, 0);
				if(matchFound){
					result.add("Match Found in File = " + file.getAbsolutePath() + "  , Line number = " + lineNumber);
				}
				lineNumber++;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return result;
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

class FileExplorer33 implements Runnable{
	private BlockingQueue<File> queue;
	private String path;
	
	public FileExplorer33(BlockingQueue<File> queue, String path){
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
					if(subFile.isDirectory())
						explore(queue, subFile);
					else if(subFile.isFile()){
						queue.put(subFile);
					}
				}
			}
		}else if(file.isFile()){
			queue.put(file);
		}
	}
}