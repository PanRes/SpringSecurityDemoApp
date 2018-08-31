package gr.pr.udemy.spring.security.enitity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "roles_normalized")
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private int id;
	
	@Basic
	@Column(name = "role_name", nullable = false, unique = true, length = 20)
	private String roleName;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name = "user_roles",
			joinColumns = {@JoinColumn(name = "role_id")},
			inverseJoinColumns = {@JoinColumn(name = "user_id")}
	)
	private List<UserEntity> users;
	
	public Role() {
	}
	
	public Role(String roleName) {
		this.roleName = roleName;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getRoleName() {
		return roleName;
	}
	
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	public List<UserEntity> getUsers() {
		return users;
	}
	
	public void addUser(UserEntity user) {
		this.users.add(user);
	}
	
	public void addUsers(List<UserEntity> users) {
		this.users.addAll(users);
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		
		Role role = (Role) o;
		
		if (getId() != role.getId()) return false;
		if (getRoleName() != null ? !getRoleName().equals(role.getRoleName()) : role.getRoleName() != null)
			return false;
		return getUsers() != null ? getUsers().equals(role.getUsers()) : role.getUsers() == null;
	}
	
	@Override
	public int hashCode() {
		int result = getId();
		result = 31 * result + (getRoleName() != null ? getRoleName().hashCode() : 0);
		result = 31 * result + (getUsers() != null ? getUsers().hashCode() : 0);
		return result;
	}
}
