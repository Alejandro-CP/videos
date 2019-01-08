package videos;

import java.util.*;

public class Video {
	private String urlAddress;
	private String title;
	private List<String> tags;
	
	public Video(String title, List<String> tags) {
		this.title = title;
		this.tags = tags;
		//falta crear la URL del video
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
	public void modifyTitle(String newTitle) {
		title = newTitle;
	}
	public void modifyTags(List<String> newTags) {
		tags = newTags;
	}

}
