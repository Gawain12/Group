package blog.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_leader", schema = "group", catalog = "")
public class Leader extends BaseEntity{
	private static final long serialVersionUID = -2544170046153290639L;
	
	private int userid;
	private String username;
	private int groupid;
	
	 @Id
	 @GeneratedValue
	 @Column(name = "userid", nullable = false)
	 public int getUserid() {
			return userid;
		}
		public void setUserid(int userid) {
			this.userid = userid;
		}
		@Basic
	    @Column(name = "username", nullable = false, unique = true, length = 45)
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		@Basic
	    @Column(name = "groupid", nullable = false, unique = true, length = 45)
		public int getGroupid() {
			return groupid;
		}
		public void setGroupid(int groupid) {
			this.groupid = groupid;
		}	
}
