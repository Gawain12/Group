package blog.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import blog.dao.MemberDAO;
import blog.dao.ScoreDAO;
import blog.entity.Member;
import blog.entity.Score;
@Transactional
@Service
public class ScoreService implements blog.service.ScoreService{
	
	@Resource
	private ScoreDAO scoredao;
	public void findAll(){
		scoredao.findAll();
	}
	
	public void update(Score score) {
		scoredao.update(score);
		
	}
	/**
	 * 删除文章
	 */
	public void delete(Score score) {
		scoredao.delete(score);
		
	}
	/**
	 * 添加文章
	 */
	public void save(Score score) {
		scoredao.save(score);
	}
}
