package com.rp.sec01.assignment;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import reactor.core.publisher.Mono;

public class FileService_mine {
	public static void main(String[] args) {
		
		
		Mono<String> fileCreationContent = Mono.fromSupplier(()->{
			StringBuilder content = new StringBuilder();
			content.append(com.rp.courseutil.Util.faker().name().firstName());
			content.append("\n");
			content.append(com.rp.courseutil.Util.faker().name().firstName());
			try {
				File newFile = new File("MyNames.txt");
				if(newFile.exists() && newFile.delete()) {}
				if(newFile.createNewFile()) {
				BufferedWriter writer = new BufferedWriter(new FileWriter(newFile));
			    writer.write(content.toString());
				writer.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return content.toString();
		});
		
		
		fileCreationContent.subscribe(com.rp.courseutil.Util.onNext(),com.rp.courseutil.Util.onError()
				,com.rp.courseutil.Util.onComplete());
		
		Mono<String> fileReadContent = Mono.fromSupplier(()->{
			StringBuilder content = new StringBuilder();
			try {
				File newFile = new File("MyNames.txt");
				if(newFile.exists()) {
					BufferedReader reader = new BufferedReader(new FileReader(newFile));					
					String st;
			        while ((st = reader.readLine()) != null)
			        	content.append(st+"\n");		
					
			        reader.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return content.toString();
		});
		
		
		fileReadContent.subscribe(com.rp.courseutil.Util.onNext(),com.rp.courseutil.Util.onError()
				,com.rp.courseutil.Util.onComplete());
		
		
		Mono<Boolean> deleteFile = Mono.fromSupplier(()->{
				File newFile = new File("MyNames.txt");
				if(newFile.exists()) {
					return true;
				}
			
			return false;
		});
		
		
		deleteFile.subscribe(com.rp.courseutil.Util.onNext(),com.rp.courseutil.Util.onError()
				,com.rp.courseutil.Util.onComplete());

	}
	
	
}
