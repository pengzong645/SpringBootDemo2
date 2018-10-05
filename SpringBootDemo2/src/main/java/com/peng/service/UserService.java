package com.peng.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.peng.mapper.UserMapper;
import com.peng.pojo.User;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;
@Service
public class UserService {
	@Autowired
	private UserMapper userMapper;
	@Transactional(propagation=Propagation.SUPPORTS)
	public User findOne(User user) {
		System.out.println("userMapper="+userMapper);
		return userMapper.selectOne(user);
	}
	@Transactional(propagation=Propagation.REQUIRED)
	public void update(User user) {
		userMapper.updateByPrimaryKeySelective(user);
	}
	@Transactional(propagation=Propagation.REQUIRED)
	public void delete(int id) {
		userMapper.deleteByPrimaryKey(id);
	}
	public List<User> queryUserListPage(User user,Integer pageNum,Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		Example example=new Example(User.class);
		Criteria criteria = example.createCriteria();
		return userMapper.selectByExample(example);
	}
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return userMapper.selectAll();
	}
	public void saveUser(User user) {
		userMapper.insertUseGeneratedKeys(user);
		
	}

}
