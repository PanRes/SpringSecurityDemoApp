package gr.pr.udemy.spring.security.enitity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users_normalized")
@NamedQueries({
		@NamedQuery(name = "User.findAll", query = "FROM UserEntity u"),
		@NamedQuery(name = "User.findUserByUserName", query = "FROM UserEntity u where u.userName = :userName"),
})
public class UserEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private int id;
	
	@Basic
	@Column(name = "user_name",unique = true,nullable = false,length = 20)
	private String userName;
	
	@Basic
	@Column(name = "password", nullable = false,length = 70)
	private String password;
	
	@Basic
	@Column(name = "enabled", nullable = false)
	private boolean enabled;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name = "user_roles",
			joinColumns = {@JoinColumn(name = "user_id")},
			inverseJoinColumns = {@JoinColumn(name = "role_id")}
	)
	private List<Role> roles;
	
	public UserEntity() {
	}
	
	public UserEntity(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean isEnabled() {
		return enabled;
	}
	
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	public List<Role> getRoles() {
		return roles;
	}
	
	public void addRole(Role role) {
		this.roles.add(role);
	}
	
	public void addRoles(List<Role> roles) {
		this.roles.addAll(roles);
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		
		UserEntity user = (UserEntity) o;
		
		if (getId() != user.getId()) return false;
		if (isEnabled() != user.isEnabled()) return false;
		if (getUserName() != null ? !getUserName().equals(user.getUserName()) : user.getUserName() != null)
			return false;
		if (getPassword() != null ? !getPassword().equals(user.getPassword()) : user.getPassword() != null)
			return false;
		return getRoles() != null ? getRoles().equals(user.getRoles()) : user.getRoles() == null;
	}
	
	@Override
	public int hashCode() {
		int result = getId();
		result = 31 * result + (getUserName() != null ? getUserName().hashCode() : 0);
		result = 31 * result + (getPassword() != null ? getPassword().hashCode() : 0);
		result = 31 * result + (isEnabled() ? 1 : 0);
		result = 31 * result + (getRoles() != null ? getRoles().hashCode() : 0);
		return result;
	}
}
