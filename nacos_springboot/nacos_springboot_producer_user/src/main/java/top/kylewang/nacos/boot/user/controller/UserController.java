package top.kylewang.nacos.boot.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.nacos.api.config.annotation.NacosValue;

@Controller
public class UserController {

	@NacosValue(value = "${username:null}", autoRefreshed = true)
	private String username;

	@RequestMapping(value = "/getUser")
	@ResponseBody
	public String getUser() {
		return username;
	}
}