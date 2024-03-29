package group.dao;

import java.awt.print.Book;
import java.sql.Date;
import java.util.List;

import group.entity.Article;
import group.entity.User;

public interface ArticleDAO extends BaseDao<Article>{
	public List<Article> findByTitle(String title);
	public List<Article> findByUserid(int userid);
	public void addArticle(Article article, int userid);
	
}
