package com.newlecture.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
@RestController
@RequestMapping("/notice")
@Slf4j
public class NoticeController {
	
	@RequestMapping("/list")
	public String list() {
		return "notice list";
	}
	
	@RequestMapping("/detail")
	public String reg() {
		return "notice detail";
	}
	
}
