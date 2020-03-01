package com.bw.service;

import java.util.List;

import com.bw.entity.Student;
import com.bw.entity.Type;
import com.bw.entity.User;

public interface StudentService {

	List<User> login(String user, String pass);

	List<Student> list(String sname, String staage, String endage, int[] cid);

	List<Type> cha();

	void add(Student student, int[] mids);

	Student find(Integer sid);

	List<Integer> findg(Integer sid);

	void update(Student student, int[] mids);

	void del(int[] sid);

	int xun(String sname);


}
