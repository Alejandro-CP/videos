package videos;

import java.util.*;

public class Video {
	private static int idCount;
	private String urlAddress;
	private String title;
	private int videoId;
	private List<String> tags;
	private String username;
	
	public Video(String username, String title, List<String> tags) {
		idCount++;
		setTitle(title);
		setTags(tags);
		videoId = idCount;
		urlAddress = "https://domain.com/videos/" + videoId;
		this.username = username;
	}
	
	public String getTitle() {
		return title;
	}
	public String getURL() {
		return urlAddress;
	}
	public List<String> getTags(){
		return tags;
	}
	public void setTitle(String newTitle) {
		title = newTitle;
	}
	public void setTags(List<String> newTags) {
		tags = newTags;
	}
	public String getUserName() {
		return username;
	}
	public int getVideoId() {
		return videoId;
	}
	public void getVideoInfo() {
		System.out.println("Títol: " + title + ". Usuari: " + username + ". URL: " + urlAddress + ". Tags: " + tags + ".");
	}

}
