package com.example.discovery.producer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@SpringBootApplication
public class ProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProducerApplication.class, args);
	}
}

@RestController
class Controller {

    @Value("${instance.index}")
    private String instanceIndex;

    @GetMapping("/")
    public String get(){
        return "instance " + instanceIndex;
    }
}

