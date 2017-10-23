package com.bistu.supreme.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bistu.supreme.domain.*;

@Controller
public class IndexController {
	@RequestMapping(value = "/index")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		return mv;
	}

	@RequestMapping(value = "/sa_manual")
	public ModelAndView manual() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("sa_manual");
		return mv;
	}
	@RequestMapping(value="/sa_introduct")
	public ModelAndView introduct(){
		ModelAndView mv=new ModelAndView();
		mv.setViewName("sa_introduct");
		return mv;
	}

//	@RequestMapping(value = "/login", method = RequestMethod.POST)
//	public ResponseEntity<Map<String, String>> getUser(@RequestBody Student std) {
//		System.out.println(std);
//		System.out.println("ID" + std.getId());
//		System.out.println("name" + std.getName());
//		Map<String, String> result = new HashMap<>();
//		result.put("name", std.getName());
//		return new ResponseEntity<Map<String, String>>(result, HttpStatus.OK);
//	}
}
