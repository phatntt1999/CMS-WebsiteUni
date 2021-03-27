package model.bean;

public class Comment {
	private String id_Comment;
	private String ContentComment;
	private String id_Author;
	private String id_Articles;

	public String getid_Articles() {
		return id_Articles;
	}

	public void setid_Articles(String id_articles) {
		this.id_Articles = id_articles;
	}

	public String getid_Comment() {
		return id_Comment;
	}

	public void setid_Comment(String id_Comment) {
		this.id_Comment = id_Comment;
	}

	public String getContentComment() {
		return ContentComment;
	}

	public void setContentComment(String contentcomment) {
		this.ContentComment = contentcomment;
	}


	public String getid_Author() {
		return id_Author;
	}

	public void setid_Author(String id_author) {
		this.id_Author = id_author;
	}}