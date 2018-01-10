package group.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import group.entity.Reply;
import group.entity.User;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

@Repository
public class ReplyDao extends HibernateDaoSupport implements group.dao.ReplyDao{
	@Autowired
    private SessionFactory sessionFactory;
	
	@Override
	public int findCount() {
		String hql = "select count(*) from Reply";
		@SuppressWarnings("unchecked")
		List<Long> list = (List<Long>) this.getHibernateTemplate().find(hql);
		System.out.println("articleDao.findCount()");
		if(list.size()>0){
			return list.get(0).intValue();
		}
		return 0;
	}

	@Override
	public List<Reply> findAll(int begin, int pageSize) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Reply.class);
		// 查询分页数据
		@SuppressWarnings("unchecked")
		List<Reply> list = (List<Reply>) this.getHibernateTemplate().findByCriteria(criteria,begin,pageSize);
		System.out.println("ReplyDao.findAll()");
		return list;
	}

	@Override
	public void delete(int id) {
		Reply a = this.getHibernateTemplate().get(Reply.class, id);
		this.getHibernateTemplate().delete(a);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Reply> findReply(int id) {
		String hql ="from Reply where article_id=?";
		return (List<Reply>) this.getHibernateTemplate().find(hql,id);
	}

	@Override
	public void save(Reply reply) {
		this.getHibernateTemplate().save(reply);
	}
	@Override
	public void addReply(Reply reply, int userid) {
		User user = (User) sessionFactory.getCurrentSession().load(User.class, new Integer(userid));
		reply.setUser(user);
		sessionFactory.getCurrentSession().save(reply);
	}

}
