package com.bw.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.bw.entity.Student;
import com.bw.entity.Type;
import com.bw.entity.User;

public interface StudentDao {
	@Select("select * from user where user=#{user} and pass=#{pass}")
	List<User> login(@Param("user")String user,@Param("pass") String pass);

	List<Student> list(@Param("sname")String sname, @Param("staage")String staage, @Param("endage")String endage, @Param("cids")int[] cid);
	@Select("select * from type")
	List<Type> cha();

	void adds(Student student);

	void addg(@Param("sid")Integer sid, @Param("mids")int[] mids);
	@Select("select * from student where sid=#{sid}")
	Student find(@Param("sid")Integer sid);
	@Select("SELECT cid from gt where sid=#{sid}")
	List<Integer> findg(@Param("sid")Integer sid);
	
	void update(Student student);
	@Delete("delete from gt where sid=#{sid}")
	void delete(@Param("sid")Integer sid);

	void insert(@Param("sid")Integer sid, @Param("mids")int[] mids);
	
	void dels(@Param("sid")int[] sid);

	void delg(@Param("sid")int[] sid);
	@Select("select count(*) from student where sname=#{sname}")
	int xun(@Param("sname")String sname);

}
