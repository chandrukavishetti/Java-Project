package com.chandru.io_stream.model;

import java.io.FileWriter;
import java.io.IOException;

public class File_writing {
	public static void main(String[] args) {

		String path = "D:\\monocept\\sample.txt";
		try {
			// true = append mode
			FileWriter file_writer = new FileWriter(path, true);

			file_writer.write("\nNew content added");
			file_writer.close();
		} catch (IOException e) {
			System.out.println("Error occurred: " + e.getMessage());
			}
		System.out.println("Data added successfully");
	}
}
