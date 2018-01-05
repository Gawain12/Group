package group.dao.impl;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import group.entity.User;
import group.entity.Article;
@Repository
public class ArticleDAO extends  BaseDaoImpl<Article>  implements group.dao.ArticleDAO{
	@Autowired
    private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Article> findByTitle(String title){
		String hql = "from Article a where a.title=:title";
		 Query query = sessionFactory.getCurrentSession().createQuery(hql);  
	        query.setParameter("title", title);
	        return query.list(); 
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Article> findByUserid(int userid){

		String hql ="from Article u where u.user.userid=:userid";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);  
        query.setParameter("userid", userid);
        return query.list(); 
	}
	@Override
	public void addArticle(Article article, int userid) {
		User user = (User) sessionFactory.getCurrentSession().load(User.class, new Integer(userid));
		article.setUser(user);
		sessionFactory.getCurrentSession().save(article);
	}

	

}
