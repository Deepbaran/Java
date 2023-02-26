package fileProcessing;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;

public class Application {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("myfile.txt");
		Scanner input = new Scanner(file); // Accepts input from file
		while(input.hasNextLine()) {
			String line = input.nextLine();
			System.out.println(line);
		}
		input.close();
		
		
		
		MyFileUtils myUtil = new MyFileUtils();
		try {
			myUtil.substract10FromLargeNumber(5);
		} catch(Exception e) {
			e.printStackTrace();
		}
		try {
			myUtil.add10WithLargNumber(11);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		// FileReader <- Older version
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		try {
			fileReader = new FileReader(file);
			bufferedReader = new BufferedReader(fileReader); // Goes BufferedReader goes line by line from the object
			String line = bufferedReader.readLine();
			while(line != null) {
				System.out.println(line);
				line = bufferedReader.readLine();
			}
		} catch(FileNotFoundException e) { // Use try-catch statement instead of throws. It helps better debugging
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("Problem reading " + file.getName());
		} finally { // Will always run
			try {
				if(bufferedReader != null) {
					/*
					 * Use if() to check for null pointer exception.
					 * Do not use null pointer exception catch as it's bad practice
					 */
					bufferedReader.close();
				}
				if(fileReader != null) {
					fileReader.close();
				}
			} catch (IOException e) {
				System.out.println("unable to close " + file.getName());;
			}
		}
		
		
		
		// try with resources <- Newer Version <- Java 7 feature <- Any class that implements the interface called 'AutoClosable', can be used in the try with resources block
		// We don't need to close resources(FileReader and BufferedReader) as try with resources automatically closes the resources.
		// We can create our own classes that implements the AutoClosable interface or an interface that extends the AutoClosable interface and then extend it in our class
		// In this way we can use our own class as a resource in the try with resource block
		try(FileReader fr = new FileReader(file);
				BufferedReader br = new BufferedReader(fr);) {
			String line = bufferedReader.readLine();
			while(line != null) {
				System.out.println(line);
				line = bufferedReader.readLine();
			}
		} catch(FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("Problem reading " + file.getName());
		}
		
	}

}