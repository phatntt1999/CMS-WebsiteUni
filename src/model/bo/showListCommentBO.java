package model.bo;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.*;

import model.bean.Comment;
import model.bean.Article;
import model.dao.*;

public class showListCommentBO {

	showListCommentDAO showListCommentDAO = new showListCommentDAO();

	public ArrayList<Comment> getListComment(String arId) {

		return showListCommentDAO.getListComment(arId);
	}

	public long CheckDay(String arId) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Calendar d1 = Calendar.getInstance();
		Calendar d2 = Calendar.getInstance();
		Date date2 = Date.valueOf(java.time.LocalDate.now());
		Date date1 = Date.valueOf(showListCommentDAO.getDateTime(arId));
		d1.setTime(date1);
		d2.setTime(date2);
		long noDay = (d2.getTime().getTime() - d1.getTime().getTime());
		return noDay / 86400000;

	}

	public void BlockComment(String arId) {
		// TODO Auto-generated method stub
		showListCommentDAO.BlockComment(arId);
	}

	public ArrayList<Article> GetDetailArticle(String arId) {
		return showListCommentDAO.GetDetailArticle(arId);
	}
}