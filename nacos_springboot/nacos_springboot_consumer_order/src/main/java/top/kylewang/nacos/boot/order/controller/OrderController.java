package top.kylewang.nacos.boot.order.controller;

import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Controller
public class OrderController {

	private Logger logger = LoggerFactory.getLogger(OrderController.class);

	@NacosInjected
	private NamingService namingService;

	private RestTemplate restTemplate = new RestTemplate();

	@RequestMapping(value = "/getOrder")
	@ResponseBody
	public Map<String, Object> getOrder() {
		Map<String, Object> order = new HashMap<>();
		order.put("username", queryUserName());
		order.put("money", 100.00);
		return order;
	}

	private String queryUserName() {
		try {
			if (namingService != null) {
				// 选择user_service服务的一个健康的实例（可配置负载均衡策略）
				Instance instance = namingService.selectOneHealthyInstance("user_service");
				// 拼接请求接口url并请求选取的实例
				String url = "http://" + instance.getIp() + ":" + instance.getPort() + "/user/getUser";
				ResponseEntity<String> entity = restTemplate.getForEntity(url, String.class);
				return entity.getBody();
			}
		} catch (Exception e) {
			logger.error("query user error", e);
		}
		return null;
	}
}