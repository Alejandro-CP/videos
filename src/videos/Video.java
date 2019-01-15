package videos;

import java.net.*;
import java.util.*;

public class Video {
	private static int videoCount;
	private int videoId;
	private int userId;
	private URL urlAddress;
	private String title;
	private List<String> tagList;
	
	public Video(int userId, String title, List<String> tagList) throws Exception{
		if(title.equals("")) throw new Exception("El títol del vídeo ha de tenir com a mínim un caràcter.");
		if(tagList.size() == 0) throw new Exception ("S'ha d'incloure com a mínim una etiqueta al vídeo.");
		videoCount++;
		videoId = videoCount;
		this.title = title;
		this.tagList = tagList;
		urlAddress = new URL("http://www.domain.es/videos/"+videoId);
		this.userId = userId;
	}
	
	public String getTitle() {
		return title;
	}
	public List<String> getTags(){
		return tagList;
	}
	public int getVideoId() {
		return videoId;
	}
	public int getCreator() {
		return userId;
	}
	public URL getURL() {
		return urlAddress;
	}
}
