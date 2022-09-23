package com.example.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
public class Config {

	@Value("${server.port}")
	private int serverPort;

	@Value("${spring.application.name}")
	private String springApplicationName;

	@Value("${spring.data.mongodb.uri}")
	private String mongoDbUri;

	public int getServerPort() {
		return serverPort;
	}

	public void setServerPort(int serverPort) {
		this.serverPort = serverPort;
	}

	public String getSpringApplicationName() {
		return springApplicationName;
	}

	public void setSpringApplicationName(String springApplicationName) {
		this.springApplicationName = springApplicationName;
	}

	public String getMongoDbUri() {
		return mongoDbUri;
	}

	public void setMongoDbUri(String mongoDbUri) {
		this.mongoDbUri = mongoDbUri;
	}
}
