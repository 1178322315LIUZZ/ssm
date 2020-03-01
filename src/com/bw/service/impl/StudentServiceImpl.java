package com.bw.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bw.dao.StudentDao;
import com.bw.entity.Student;
import com.bw.entity.Type;
import com.bw.entity.User;
import com.bw.service.StudentService;
@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDao studentDao;

	@Override
	public List<User> login(String user, String pass) {
		// TODO Auto-generated method stub
		return studentDao.login(user,pass);
	}

	@Override
	public List<Student> list(String sname, String staage, String endage,int[] cid) {
		// TODO Auto-generated method stub
		return studentDao.list(sname,staage,endage,cid);
	}

	@Override
	public List<Type> cha() {
		// TODO Auto-generated method stub
		return studentDao.cha();
	}

	@Override
	public void add(Student student, int[] mids) {
		studentDao.adds(student);
		studentDao.addg(student.getSid(),mids);
	}

	@Override
	public Student find(Integer sid) {
		return studentDao.find(sid);
	}

	@Override
	public List<Integer> findg(Integer sid) {
		// TODO Auto-generated method stub
		return studentDao.findg(sid);
	}

	@Override
	public void update(Student student, int[] mids) {
		studentDao.update(student);
		studentDao.delete(student.getSid());
		studentDao.insert(student.getSid(),mids);
	}

	@Override
	public void del(int[] sid) {
		studentDao.dels(sid);
		studentDao.delg(sid);
	}

	@Override
	public int xun(String sname) {
		// TODO Auto-generated method stub
		return studentDao.xun(sname);
	}
}
