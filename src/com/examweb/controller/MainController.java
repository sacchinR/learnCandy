package com.examweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.examweb.bean.CandyBean;
import com.examweb.bean.Regbean;
import com.examweb.dao.CandyDao;

@Controller
public class MainController {
	
	@Autowired
	CandyDao theDao;
	
	@RequestMapping("/")
	public String home(Model theModel) {
		Regbean reg=new Regbean();
		theModel.addAttribute("register", reg);
		return "index";
	}
	@RequestMapping("/store")
	public String store(@ModelAttribute("register") Regbean reg) {
		theDao.store(reg);
		return "final";
	}
	
	@RequestMapping("/storeCandy")
	public String storeCandy(@ModelAttribute("candy") CandyBean candy ) {
		theDao.storeCandy(candy);		
		return "redirect:/login";
	}
	
	@RequestMapping("/addCandy")
	public String addCandy(@RequestParam("userId") int userId,Model theModel) {
		CandyBean candy=new CandyBean();
		candy.setUserId(userId);
		theModel.addAttribute("candy", candy);
		return "details";
	}
	
	@RequestMapping("/login")
	public String loginPage(Model theModel) {
		Regbean reg=new Regbean();
		theModel.addAttribute("login",reg);
		return "login";
	}
	
	
	@RequestMapping("/checklogin")
	public String login(@ModelAttribute("login") Regbean login,Model theModel) {
		
		int a=theDao.getUserId(login);
		theModel.addAttribute("check", a);
		if(a!=0) {
		
		List<CandyBean> candy=theDao.getCandy(login);
		
		if(candy!=null) {
			theModel.addAttribute("candies", candy);
			theModel.addAttribute("msg",0);

		}
		else {
			theModel.addAttribute("msg", "No candies found");
		}
		}
		
		
		return "success";
	}
	@RequestMapping("/deleteCandy")
	public String deleteCandy(@RequestParam("candyId") int candyId) {
		theDao.deleteCandy(candyId);
		
		return "success";
	}
	
	
}
