package blog.service;

import java.util.List;

import blog.entity.Article;
import blog.util.PageBean;

public interface ArticleService {

	PageBean<Article> findAll(Integer currPage);

	Article findById(int article_id);
	
	List<Article> findByTitle(String title);

	void update(Article article);

	void delete(Article article);

	void save(Article article);
}
