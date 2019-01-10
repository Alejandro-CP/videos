package videos;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class Main {
	static Map<String,User> userList = new HashMap<>();

	public static void main(String[] args) {
		try {
			test1();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static void addUser(String name, String surname, String password) {
		if(checkUserName(name, surname) && checkPassword(password)) {
			String username = name + "." + surname;
			username = username.toLowerCase();
			if(userList.containsKey(username)) {
				System.out.println("L'usuari " + name + " " + surname + " ja est� registrat.\nL'usuari no s'ha creat.");
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
			System.out.println("El nom i el cognom han de tenir un car�cter com a m�nim.");
			return false;
		}else {
			return true;
		}
	}
	
	public static boolean checkPassword(String password) {
		int lowLimit = 8;
		int highLimit = 16;
		if((password.length() < lowLimit) || (password.length() > highLimit)) {
			System.out.println("La contrassenya ha de tenir un m�nim de " + lowLimit + 
					" car�cters i un m�xim de " + highLimit + " car�cters.");
			return false;
		}else {
			return true;
		}
	}
	
	// Testing creating and adding users
	public static void test1() throws InterruptedException {
		//addUser("", "L�pez", "123456");
		//addUser("Marco", "", "1234567890");
		//addUser("Marco", "L�pez", "1234567890123456789");
		addUser("Marco", "L�pez", "1234567890");
		TimeUnit.SECONDS.sleep(5);
		addUser("Marco", "L�pez", "0987654321");
		TimeUnit.SECONDS.sleep(5);
		addUser("Mar�a", "P�rez", "0987654321");
		for(Map.Entry<String, User> username : userList.entrySet()) {
			username.getValue().getUserInfo();
		}
	}

}


