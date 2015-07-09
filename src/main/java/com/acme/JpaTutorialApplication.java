package com.acme;

import java.net.UnknownHostException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

@SpringBootApplication
public class JpaTutorialApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaTutorialApplication.class, args);
	}

	public @Bean Mongo mongo() throws UnknownHostException {
		return new MongoClient("localhost");
	}
}
