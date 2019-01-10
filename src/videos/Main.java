package videos;

import java.util.*;
//import java.util.concurrent.TimeUnit;

public class Main {
	static Map<String, User> userList = new HashMap<>();
	static Map<Integer, Video> videoList = new HashMap<>();
	static List<String> genericTagList = new ArrayList<>(Arrays.asList("Animals", "Gatets", "Mamífers", "Gats"));

	public static void main(String[] args) {
		//test1();
		test2();
		}
	
	public static void addUser(String name, String surname, String password) {
		if(checkUserName(name, surname) && checkPassword(password)) {
			if(userList.containsKey(getUsername(name, surname))) {
				System.out.println("L'usuari " + name + " " + surname + " ja està registrat.\nL'usuari no s'ha creat.\n");
			}else {
				userList.put(getUsername(name, surname), new User(name, surname, password));
				System.out.println("L'usuari " + name + " " + surname +" s'ha creat correctament.\n");
			}		
		}else {
			System.out.println("L'usuari no s'ha creat.\n");
		}
	}
	
	public static boolean checkUserName(String name, String surname) {
		if ((name.length() < 1) || (surname.length() < 1 )) {
			System.out.println("El nom i el cognom han de tenir un caràcter com a mínim.");
			return false;
		}else {
			return true;
		}
	}
	
	public static boolean checkPassword(String password) {
		int lowLimit = 8;
		int highLimit = 16;
		if((password.length() < lowLimit) || (password.length() > highLimit)) {
			System.out.println("La contrassenya ha de tenir un mínim de " + lowLimit + 
					" caràcters i un màxim de " + highLimit + " caràcters.");
			return false;
		}else {
			return true;
		}
	}
	
	public static boolean correctPassword(String name, String surname, String password) {
		if(userList.get(getUsername(name, surname)).checkPassword(password)) {
			return true;
		}else {
			return false;
		}
	}
	
	public static String getUsername(String name, String surname) {
		String username = name + "." + surname;
		return username.toLowerCase();
	}
	
	public static void addVideo(String name, String surname, String password, String title, List<String> tags) {
		if(correctPassword(name, surname, password)) {
			userList.get(getUsername(name, surname)).createVideo(getUsername(name, surname), title, tags, videoList);
			System.out.println("El vídeo s'ha creat correctament.\n");
		}else {
			System.out.println("Contrassenya incorrecta. El vídeo no s'ha creat.\n");
		}
	}
	
	// Testing creating and adding users
	/*public static void test1(){
		try {
			addUser("", "López", "123456");
			TimeUnit.SECONDS.sleep(2);
			addUser("Marco", "", "1234567890");
			TimeUnit.SECONDS.sleep(2);
			addUser("Marco", "López", "1234567890123456789");
			TimeUnit.SECONDS.sleep(2);
			addUser("Marco", "López", "1234567890");
			TimeUnit.SECONDS.sleep(2);
			addUser("Marco", "López", "0987654321");
			TimeUnit.SECONDS.sleep(2);
			addUser("María", "Pérez", "0987654321");
			for(Map.Entry<String, User> username : userList.entrySet()) {
				username.getValue().getUserInfo();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	// Testing creation and addition of videos
	public static void test2() {
		addUser("Marco", "López", "1234567890");
		addVideo("Marco", "López", "1234567890", "Video1", genericTagList);
		addVideo("Marco", "López", "1234576890", "Video1", genericTagList);
		addVideo("Marco", "López", "1234567890", "Video2", genericTagList);
	}

}


