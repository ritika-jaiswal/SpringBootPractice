package com.exazeit;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class TestController {
	@RequestMapping("/test")
	public String handleTest() {
		return "this is project using sts";
	}
}
