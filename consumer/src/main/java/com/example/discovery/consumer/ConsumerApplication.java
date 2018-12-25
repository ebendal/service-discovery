package com.example.discovery.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class ConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerApplication.class, args);
	}
}

@RestController
class Controller {

	private final ProducerClient client;

	Controller(ProducerClient client) {
		this.client = client;
	}

	@GetMapping("/")
	public String get(){
		return "Produced by: " + client.get();
	}
}

@FeignClient(name = "service-discovery-producer")
interface ProducerClient {

	@GetMapping("/")
	String get();
}

