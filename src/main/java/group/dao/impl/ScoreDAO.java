package group.dao.impl;

import java.util.List;

import group.entity.Article;
import group.entity.Group;
import group.entity.Score;

public class ScoreDAO extends BaseDaoImpl<Score> implements group.dao.ScoreDAO{
	public List<Score> findByTitle(String title){
		String hql = "from Score a where a.title like '%?%'";
		return super.find(hql, title);
	}
}
