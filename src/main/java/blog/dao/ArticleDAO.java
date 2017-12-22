package blog.dao;

import java.awt.print.Book;
import java.util.List;

import blog.entity.Article;
import blog.entity.User;

public interface ArticleDAO extends BaseDao<Article>{
	public List<Article> findByTitle(String title);
	
}
