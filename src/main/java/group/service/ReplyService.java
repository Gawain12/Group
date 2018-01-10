package group.service;

import java.util.List;

import group.entity.Reply;
import group.util.PageBean;

public interface ReplyService {

	PageBean<Reply> findAllReply(int currPage);

	void delete(int id);

	List<Reply> findReply(int id);

	void save(Reply reply);

	void addReply(Reply reply, int userid);


}
