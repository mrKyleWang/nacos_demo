package top.kylewang.nacos.cloud.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class NacosCloudUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(NacosCloudUserApplication.class, args);
	}

}
