package model.bean;

public class AccountInfor {
	private String NameUser;
	private String Email;
	private String Faculty;
	private String Avatar;
	private String ArticleName;
	private String Date_upload;
	private boolean Published;
	
	
	public String getNameUser() {
		return NameUser;
	}
	public void setNameUser(String nameUser) {
		NameUser = nameUser;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getFaculty() {
		return Faculty;
	}
	public void setFaculty(String faculty) {
		Faculty = faculty;
	}
	public String getAvatar() {
		return Avatar;
	}
	public void setAvatar(String avatar) {
		Avatar = avatar;
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
	public boolean getPublished() {
		return Published;
	}
	public void getPublished(boolean published) {
		Published = published;
	}
	
	
	
}
