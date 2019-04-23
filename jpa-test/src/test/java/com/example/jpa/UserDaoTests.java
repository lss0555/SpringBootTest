package com.example.jpa;

import com.alibaba.druid.sql.dialect.oracle.ast.OracleDataTypeIntervalYear;
import com.example.jpa.dao.UserDao;
import com.example.jpa.model.user;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTests {
	@Resource
	UserDao userDao;

	/**
	 * @Description  添加用户
	 **/
	@Test
	public void addUser() {
		user user = new user();
		user.setId(22);
		user.setPassword("lss1");
		user.setUsername("lss0555");
		user.setYue(new BigDecimal(88.88));
		userDao.save(user);
	}

	/**
	 * @Description  查询所有用户数据
	 **/
	@Test
	public void  userList(){
		List<user> userList = userDao.findAll();
		System.out.println("所有用户列表:"+userList.toString());
	}

	/**
	 * @Description  删除用户
	 **/
	@Test
	public void deleteuser(){
		userDao.deleteById(1);
	}
}
