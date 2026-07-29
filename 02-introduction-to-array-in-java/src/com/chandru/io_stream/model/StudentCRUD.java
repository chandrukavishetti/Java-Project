package com.chandru.io_stream.model;

import java.io.*;

public class StudentCRUD {

	String filePath = "students.txt";

	public void addStudent(String record) throws IOException {

		BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true));
		writer.write(record);
		writer.newLine();
		writer.close();

		System.out.println("Student added successfully");
	}

	public void readStudents() throws IOException {

		BufferedReader reader = new BufferedReader(new FileReader(filePath));

		String line;

		while ((line = reader.readLine()) != null) {
			System.out.println(line);
		}

		reader.close();
	}

	public void updateStudent(int id, String newRecord) throws IOException {

		File file = new File(filePath);
		File tempFile = new File("temp.txt");

		BufferedReader reader = new BufferedReader(new FileReader(file));
		BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

		String line;

		while ((line = reader.readLine()) != null) {

			String[] data = line.split(",");

			if (Integer.parseInt(data[0]) == id) {
				writer.write(newRecord);
			} else {
				writer.write(line);
			}

			writer.newLine();
		}

		reader.close();
		writer.close();

		file.delete();
		tempFile.renameTo(file);

		System.out.println("Student updated successfully");
	}

	public void deleteStudent(int id) throws IOException {

		File file = new File(filePath);
		File tempFile = new File("temp.txt");

		BufferedReader reader = new BufferedReader(new FileReader(file));
		BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

		String line;

		while ((line = reader.readLine()) != null) {

			String[] data = line.split(",");

			if (Integer.parseInt(data[0]) != id) {
				writer.write(line);
				writer.newLine();
			}
		}

		reader.close();
		writer.close();

		file.delete();
		tempFile.renameTo(file);

		System.out.println("Student deleted successfully");
	}
}