package fileProcessing;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Application3 {

	public static void main(String[] args) {
		File file = new File("myfile2.txt");
		try {
			if(file.createNewFile()) {
				System.out.println("File is created: " + file.getName());
			} else {
				System.out.println("File already exists");
			}
		} catch (IOException e) {
			System.out.println("Problem reading " + file.getName());
		}
		
		try(FileWriter writer = new FileWriter(file);) {
			writer.write("Hello Deepbaran Kar");
		} catch(IOException e) {
			System.out.println("Problem reading " + file.getName());
		}
	}

}
