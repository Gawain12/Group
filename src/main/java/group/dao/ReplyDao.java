package group.dao;

import java.util.List;

import group.entity.Reply;

public interface ReplyDao {

	int findCount();

	List<Reply> findAll(int begin, int pageSize);

	void delete(int id);

	List<Reply> findReply(int id);

	void save(Reply reply);

	void addReply(Reply reply, int userid);

}
