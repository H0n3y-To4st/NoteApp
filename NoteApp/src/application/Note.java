package application;
//import java.time.format.DateTimeFormatter;

public class Note {
	private String name;
	private String date;
	private String description;
	
	public Note(){
		
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
        this.name = name;
    }
	
	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
        this.date = date;
    }
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
        this.description = description;
    }
}
