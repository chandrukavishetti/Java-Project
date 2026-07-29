package com.chandru.io_stream.model;
import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;

public class File_reading {
	public static void main(String[] args) {
		
		String path = "D:\\monocept\\sample.txt";   // Make sure file exists
		
		try {
			FileReader file_reader = new FileReader(path);
			BufferedReader buffer_reader = new BufferedReader(file_reader);

			String line;

			while ((line = buffer_reader.readLine()) != null) {
				System.out.println(line);
			}

			buffer_reader.close();
			
		} catch (IOException e) {
			System.out.println("Error occurred: " + e.getMessage());
		}
	}
}
