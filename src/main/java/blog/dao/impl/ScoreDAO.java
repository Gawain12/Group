package blog.dao.impl;

import java.util.List;

import blog.entity.Article;
import blog.entity.Group;
import blog.entity.Score;

public class ScoreDAO extends BaseDaoImpl<Score> implements blog.dao.ScoreDAO{
	public List<Score> findByTitle(String title){
		String hql = "from Score a where a.title like '%?%'";
		return super.find(hql, title);
	}
}
