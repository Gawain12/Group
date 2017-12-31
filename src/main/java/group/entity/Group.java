package group.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_group", schema = "group", catalog = "")
public class Group {
	private static final long serialVersionUID = -2544170046153290639L;
	
	private int groupid;
	private String groupname;
	private String username;
	
	 @Id
	 @GeneratedValue
	 @Column(name = "groupid", nullable = false)
	 public int getGroupid() {
			return groupid;
		}
		public void setGroupid(int groupid) {
			this.groupid = groupid;
		}
		@Basic
	    @Column(name = "groupname", nullable = false, unique = true, length = 45)
		public String getGroupname() {
			return groupname;
		}
		public void setGroupname(String groupname) {
			this.groupname = groupname;
		}
		@Basic
	    @Column(name = "username", nullable = false, unique = true, length = 45)
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		/*public static long getSerialversionuid() {
			return serialVersionUID;
		}*/
}
