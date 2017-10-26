package com.bistu.supreme.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class IndexController {
	@RequestMapping(value = "/index")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		return mv;
	}
	@RequestMapping(value = "/sa-main")
	public ModelAndView main() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("sa-main");
		return mv;
	}

	@RequestMapping(value = "/sa-handbook")
	public ModelAndView manual() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("sa-handbook");
		return mv;
	}
	@RequestMapping(value="/sa-introduce")
	public ModelAndView introduct(){
		ModelAndView mv=new ModelAndView();
		mv.setViewName("sa-introduce");
		return mv;
	}

}
