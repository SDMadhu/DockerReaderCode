package com.github.thstock.djp.main;

import java.io.File;
import java.io.IOException;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;

import com.github.thstock.djp.Dockerfile;

public class MainApp {
	
	
	public static void main(String[] args) throws IOException, GitAPIException {
		
		String repoUrl = "https://github.com/SDMadhu/dockerexample.git";
		
		
		
		
		 File path1 = File.createTempFile("Abc123", "");
	        if(!path1.delete()) {
	            throw new IOException("Could not delete temporary file " + path1);
	        }
	       
		
		
		try {
		     System.out.println("Cloning "+repoUrl+" into "+repoUrl);
		     Git.cloneRepository()
		         .setURI(repoUrl)
		         
		         .setDirectory(path1)
		        
		         .call();
		     System.out.println("Completed Cloning");
		 } catch (GitAPIException e) {
		     System.out.println("Exception occurred while cloning repo");
		     e.printStackTrace();
		 }
		
		

		String tmp = path1+"/Dockerfile";
		
		
		Dockerfile dockerFile = new Dockerfile(new File(tmp), true);
		
		
		dockerFile.getFrom();
		dockerFile.getCmd();
		dockerFile.getExpose();
		
		
		
		System.out.println("Success");
		
	
		
	}

}
