package videos;

import java.util.*;

public class User {
	private static int userCount;
	private int userId;
	private String name;
	private String surname;
	private String password;
	private static final int minLength = 8;
	private static final int maxLength = 16;
	private Date registrationDate;
	
	public User(String name, String surname, String password) throws Exception{
		if(name.equals("")) throw new Exception("El nom de l'usuari ha de tenir com a mínim un caràcter");
		if(surname.equals("")) throw new Exception("El cognom de l'usuari ha de tenir com a mínim un caràcter");
		if((password.length() < minLength) || (password.length() > maxLength)) throw new Exception
		("La contrassenya ha de tenir un mínim de " + minLength + " caràcters i un màxim de " + maxLength + " caràcters.");
		userCount++;
		userId = userCount;
		this.name = name;
		this.surname = surname;
		this.password = password;
		registrationDate = new Date();
	}
	
	public String getName() {
		return name;
	}
	public String getSurame() {
		return surname;
	}
	public int getUserId() {
		return userId;
	}
	public Date getRegistrationDate() {
		return registrationDate;
	}
	
	public String changePassword(String password, String newPassword) throws Exception {
		if(this.password.equals(password)) {
			if((newPassword.length() < minLength) || (newPassword.length() > maxLength)) throw new Exception
				("La nova contrassenya ha de tenir un mínim de " + minLength + " caràcters i un màxim de " + maxLength + " caràcters.");
			this.password = newPassword;
			return "La contrassenya s'ha canviat correctament.";
		}else {
			return "No s'ha pogut canviar la contrassenya.";
		}
	}
	
	public void createVideo(String title, List<String> tagList, List<Video> videoList) throws Exception{
		videoList.add(new Video(this.userId, title, tagList));
	}
	public String printVideos(List<Video> videoList){
		String result = "La llista de vídeos de l'usuari/a " + name + " " + surname + " és:\n";
		for(Video v : videoList) {			
			if(v.getCreator() == this.userId) {
				result = result + "- " + v.getTitle() + "\n";
			}
		}
		return result;
	}

}
