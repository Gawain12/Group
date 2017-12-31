package group.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import group.entity.Article;
@Repository
public class ArticleDAO extends BaseDaoImpl<Article> implements group.dao.ArticleDAO{
	public List<Article> findByTitle(String title){
		String hql = "from Article a where a.title like '%?%'";
		return super.find(hql, title);
	}
	public List<Article> findByUserid(String username){
		String hql = "from Article a where a.User.username like '%?%'";
		//String sql = "select * from t_article a, user b where a.user_id=b.user_id And b.username like '%%'"
		return super.find(hql, username);
	}
}
