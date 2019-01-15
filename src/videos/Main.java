package videos;

import java.util.*;

public class Main {
	static List<Video> videoList = new ArrayList<>();
	static List<String> genericTagList = new ArrayList<>(Arrays.asList("Animals", "Gatets", "Mamífers", "Gats"));
	//static List<String> voidTagList = new ArrayList<>();
	//static List<String> nullTagList;

	public static void main(String[] args) throws Exception {
		User user1 = new User("Juan", "Moreno", "0123456789");
		User user2 = new User("Pedro", "López", "1234567890");
		User user3 = new User("Monica", "Moreno", "9876543210");
		//System.out.println(user1.getName() + " " + user1.getSurame() + ". ID:  " + user1.getUserId() + "\nData registre: " + user1.getRegistrationDate());
		//System.out.println(user1.modPassword("0123456789", "1234567890"));
		user1.createVideo("Vídeo 1.1", genericTagList, videoList);
		user1.createVideo("Vídeo 1.2", genericTagList, videoList);
		user1.createVideo("Vídeo 1.3", genericTagList, videoList);
		user2.createVideo("Vídeo 2.1", genericTagList, videoList);
		user2.createVideo("Vídeo 2.2", genericTagList, videoList);
		user3.createVideo("Vídeo 3.1", genericTagList, videoList);
		/*int i = 2;
		System.out.println(videoList.get(i).getTitle() + "\n" + videoList.get(i).getCreator() + "\n" 
		+ videoList.get(i).getVideoId() + "\n" + videoList.get(i).getURL() + "\n" + videoList.get(i).getTags());*/
		System.out.println(user1.printVideos(videoList));
		System.out.println(user2.printVideos(videoList));
		System.out.println(user3.printVideos(videoList));

	}

}


