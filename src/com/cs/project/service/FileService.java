package com.cs.project.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileService {

	/**
	 * 
	 * @param fromRead
	 * @return
	 * @throws IOException 
	 */
	public String readFromFile(String fromRead) throws IOException {

		StringBuilder buf = new StringBuilder();
		BufferedReader br = new BufferedReader(new FileReader(fromRead));

		String currentLine;
		while ((currentLine = br.readLine()) != null) {
			buf.append(currentLine + "\n");
		}
		br.close();
		return buf.toString();

	}

	/**
	 * 
	 * @param message
	 * @param toWrite
	 */
	public void writeToFile(StringBuffer message, String toWrite) {

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(toWrite))) {
			bw.write(message.toString());
		} catch (IOException ex) {
			System.out.println("Error!");
		}

	}
}
