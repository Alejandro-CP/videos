package videos;

import java.util.*;

public class Main {
	static Map<String,User> userList = new HashMap<>();

	public static void main(String[] args) {
		test1();

	}
	
	public static void addUser(String name, String surname, String password) {
		if(checkUserName(name, surname) && checkPassword(password)) {
			String username = name + "." + surname;
			username = username.toLowerCase();
			if(userList.containsKey(username)) {
				System.out.println("L'usuari " + name + " " + surname + " ja està registrat.\nL'usuari no s'ha creat.");
			}else {
				userList.put(username, new User(name, surname, password));
				System.out.println("L'usuari " + name + " " + surname +" s'ha creat correctament.");
			}
			
		}else {
			System.out.println("L'usuari no s'ha creat.");
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
	
	// Testing creating and adding users
	public static void test1() {
		//addUser("", "López", "123456");
		//addUser("Marco", "", "1234567890");
		//addUser("Marco", "López", "1234567890123456789");
		addUser("Marco", "López", "1234567890");
		addUser("Marco", "López", "0987654321");
		addUser("María", "Pérez", "0987654321");
	}

}


