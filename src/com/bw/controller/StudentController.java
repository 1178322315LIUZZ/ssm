package com.bw.controller;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.bw.entity.Student;
import com.bw.entity.Type;
import com.bw.entity.User;
import com.bw.service.StudentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
public class StudentController {

	@Autowired
	private StudentService service;
	
	
	@RequestMapping("login.do")
	public String login(String user,String pass,HttpSession session) {
		List<User> us=service.login(user,pass);
		if(us!=null &&us.size()>0 ) {
			session.setAttribute("login", us);
			return "redirect:list.do";
		}else {
			session.setAttribute("err", "’À∫≈√‹¬Î¥ÌŒÛ");
			return "index";
		}	
	}
	
	@RequestMapping("list.do")
	public String list(Model m,@RequestParam(defaultValue = "1")int pageNum,String sname,String staage,String endage,int[] cid) {
		PageHelper.startPage(pageNum, 2);
		List<Student> list=service.list(sname,staage,endage,cid);
		PageInfo<Student> page=new PageInfo<Student>(list);
		m.addAttribute("g", list);
		m.addAttribute("pg", page);
		m.addAttribute("sname", sname);
		m.addAttribute("staage", staage);
		m.addAttribute("endage", endage);
		return "view/list";
	}
	
	@RequestMapping("add.do")
	public String add(Model m) {
		m.addAttribute("g", new Student());
		return "view/add";
	}
	
	@RequestMapping("cha.do")
	@ResponseBody
	public List<Type> cha() {
		return service.cha();
	}
	
	@RequestMapping("addyan.do")
	public String addyan(@Validated @ModelAttribute("g") Student student,BindingResult result,@RequestParam("f") MultipartFile file,int[] mids,Model m) throws Exception {
		if(result.hasErrors()) {
			return "view/add";
		}
		if(file.getSize()>0) {
			String path="d://img";
			String filename = file.getOriginalFilename();
			File file2 = new File(path, filename);
			file.transferTo(file2);
			student.setUrl("/img/"+filename);
		}
		service.add(student,mids);
		return "redirect:list.do";
	}
	
	@RequestMapping("find.do")
	public String find(Integer sid,Model m) {
		Student student=service.find(sid);
		List<Integer> id=service.findg(sid);
		m.addAttribute("g", student);
		m.addAttribute("id", id);
		return "view/update";	
	}
	
	@RequestMapping("update.do")
	public String update(@Validated @ModelAttribute("g") Student student,BindingResult result,@RequestParam("f") MultipartFile file,int[] mids,Model m) throws Exception {
		if(result.hasErrors()) {
			return "view/update";
		}
		if(file.getSize()>0) {
			String path="d://img";
			String filename = file.getOriginalFilename();
			File file2 = new File(path, filename);
			file.transferTo(file2);
			student.setUrl("/img/"+filename);
		}
		service.update(student,mids);
		return "redirect:list.do";
	}
	
	
	@RequestMapping("del.do")
	public String del(int[] sid) {
		service.del(sid);
		return "redirect:list.do";	
	}
	
	@RequestMapping("xun.do")
	@ResponseBody
	public int xun(String sname){
		return service.xun(sname);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
