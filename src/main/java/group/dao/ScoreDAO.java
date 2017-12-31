package group.dao;

import java.util.List;

import group.entity.Score;
import group.entity.User;

public interface ScoreDAO extends BaseDao<Score>{
	public List<Score> findByTitle(String title);
}
