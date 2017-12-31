package group.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_member", schema = "group", catalog = "")
public class Member extends BaseEntity{
	private static final long serialVersionUID = -2544170046153290639L;
	
	private int memberid;
	private String membername;
	//private int groupid;
	private String groupname;
	
	  @Id
	  @GeneratedValue
	  @Column(name = "memberid", nullable = false)
	  public int getMemberid() {
			return memberid;
		}
		public void setMemberid(int memberid) {
			this.memberid = memberid;
			}
		@Basic
	    @Column(name = "membername", nullable = false, unique = true, length = 45)
		public String getMembername() {
			return membername;
		}
		public void setMembername(String membername) {
			this.membername = membername;
		}
	/*	@Basic
	    @Column(name = "groupid", nullable = false)
		public int getGroupid() {
			return groupid;
		}
		public void setGroupid(int groupid) {
			this.groupid = groupid;
		}
	*/
		@Basic
	    @Column(name = "groupname", nullable = false, unique = true, length = 45)
		public String getGroupname() {
			return groupname;
		}
		public void setGroupname(String groupname) {
			this.groupname = groupname;
		}
}
