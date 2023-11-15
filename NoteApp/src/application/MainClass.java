package application;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MainClass {

	public static void main(String[] args) {
		// Creating file (if it doesn't already exist)
		try {
		// Setting up note date
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");  
		LocalDateTime localDate = LocalDateTime.now();
		String date = localDate.format(dtf);
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Please provide the filepath for your note");
		String filepath = scan.next();
		System.out.println("Please enter your note title");
		String title = scan.next();
		System.out.println("Please fill in your note");
		String description = scan.next();
		
		Note note = new Note();
		note.setName(title);
		note.setDate(date);
		note.setDescription(description);	
		
		// Create the directory if it doesn't exist
		File directory = new File(filepath);
		if (!directory.exists()) {
		    if (directory.mkdirs()) {
		        System.out.println("Directory created: " + directory.getAbsolutePath());
		    } else {
		        System.out.println("Failed to create directory: " + directory.getAbsolutePath());
		        return; // Exit the program if directory creation fails
		    }
		}
		
		File myNote = new File(filepath + File.separator + note.getName() +".txt");
		
		if (myNote.createNewFile()) {
	        System.out.println("File created: " + myNote.getName());
	        // Putting details in note
	        FileWriter writer = new FileWriter(myNote);
	        writer.write(title + " - " + date + "\n" + description);
	        writer.close();
	      } else {
	        System.out.println("File already exists.");
	      }
	    } catch (IOException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
	}

}
