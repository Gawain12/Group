package blog.dao;

import java.util.List;

import blog.entity.Score;
import blog.entity.User;

public interface ScoreDAO extends BaseDao<Score>{
	public List<Score> findByTitle(String title);
}
