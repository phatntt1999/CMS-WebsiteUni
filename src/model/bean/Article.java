package model.bean;

public class Article {
	private String id_Articles;
	private String ArticleName;
	private String Date_upload;
	private String id_Faculty;
	private String id_Author;
	private String id_Coordinator;
	private boolean Published;
	private boolean IsNow;
	private boolean StatusComment;
	
	public String getid_Articles() {
		return id_Articles;
	}
	public void setid_Articles(String id_articles) {
		id_Articles = id_articles;
	}
	
	public String getArticleName() {
		return ArticleName;
	}
	public void setArticleName(String articleName) {
		ArticleName = articleName;
	}
	
	public String getDate_upload() {
		return Date_upload;
	}
	public void setDate_upload(String date_upload) {
		Date_upload = date_upload;
	}
	public String getId_Faculty() {
		return id_Faculty;
	}
	public void setId_Faculty(String id_Faculty) {
		this.id_Faculty = id_Faculty;
	}
	public String getId_Author() {
		return id_Author;
	}
	public void setId_Author(String id_Author) {
		this.id_Author = id_Author;
	}
	public String getId_Coordinator() {
		return id_Coordinator;
	}
	public void setId_Coordinator(String id_Coordinator) {
		this.id_Coordinator = id_Coordinator;
	}
	public boolean getPublished() {
		return Published;
	}
	public void setPublished(boolean published) {
		Published = published;
	}
	public boolean getIsNow() {
		return IsNow;
	}
	public void setIsNow(boolean isNow) {
		IsNow = isNow;
	}
	public boolean getStatusComment() {
		return StatusComment;
	}
	public void setStatusComment(boolean statusComment) {
		StatusComment = statusComment;
	}
	
	
	
}
