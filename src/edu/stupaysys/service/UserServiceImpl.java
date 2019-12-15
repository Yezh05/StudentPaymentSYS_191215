package edu.stupaysys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.stupaysys.dao.UserMapper;
import edu.stupaysys.po.User;
import edu.stupaysys.po.UserExample;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;
	@Override
	public User findUserById(Integer userid) {
		User user = this.userMapper.selectByPrimaryKey(userid);
		/*System.out.println(user.toString());*/
		return user;
	}
	@Override
	public List<User> findAllUser(UserExample userExample) {
		List<User> userslist = this.userMapper.selectByExample(userExample);
		/*System.out.println(userslist.toString());*/
		return userslist;
	}
	@Override
	public int delOneUser(Integer key) {
		int influnce_row = this.userMapper.deleteByPrimaryKey(key);
		return influnce_row;
	}
	@Override
	public int updateOneUser(User user) {
		int influnce_row = this.userMapper.updateByPrimaryKey(user);
		return influnce_row;
	}
	@Override
	public int addOneUser(User user) {
		int influnce_row = this.userMapper.insert(user);
		return influnce_row;
	}

}
