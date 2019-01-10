package videos;

import java.util.*;

public class User {
	private String name;
	private String surname;
	private String password;
	private Date registrationDate;
	
	public User(String name, String surname, String password) {
		this.name = name;
		this.surname = surname;
		this.password = password;
		registrationDate = new Date();
	}
	
	public String getUserName() {
		return name + "." + surname;
	}
	public Date getRegistrationDate() {
		return registrationDate;
	}
	
	public boolean checkPassword(String password) {
		if(this.password.equals(password)) {
			return true;
		}else {
			return false;
		}
	}
	
	public void modifyPassword(String password, String newPassword) {
		if(this.password.equals(password)) {
			this.password = newPassword;
			System.out.println("Contrassenya canviada correctament.");
		}else {
			System.out.println("Contrassenya incorrecta.\n" + "No s'ha canviat la contrassenya.");
		}
	}
	public void getUserInfo() {
		System.out.println("Usuari: " + name + " " + surname + ". Data de registre: " + registrationDate + ".\n");
	}
	
	public void createVideo(String username, String title, List<String> tags, Map<Integer,Video> videoList) {
		Video createdVideo = new Video(username, title, tags);
		videoList.put(createdVideo.getVideoId(), createdVideo);
	}
}
