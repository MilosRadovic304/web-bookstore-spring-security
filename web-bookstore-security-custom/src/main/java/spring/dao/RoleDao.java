package spring.dao;

import spring.entity.Role;

public interface RoleDao {

	public Role findRoleByName(String theRoleName);
	
}
