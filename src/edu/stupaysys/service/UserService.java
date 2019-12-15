package edu.stupaysys.service;

import java.util.List;

import edu.stupaysys.po.User;
import edu.stupaysys.po.UserExample;

public interface UserService {
	public User findUserById(Integer userid);
	public List<User> findAllUser(UserExample userExample);
	public int delOneUser(Integer key) ;
	public int updateOneUser(User user);
	public int addOneUser(User user);
}
