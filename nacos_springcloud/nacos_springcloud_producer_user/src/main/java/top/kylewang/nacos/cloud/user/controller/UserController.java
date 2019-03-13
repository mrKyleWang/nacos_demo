package top.kylewang.nacos.cloud.user.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RefreshScope
public class UserController {

	@Value("${username:null}")
	private String username;

	@RequestMapping(value = "/getUser")
	@ResponseBody
	public String getUser() {
		return username;
	}
}