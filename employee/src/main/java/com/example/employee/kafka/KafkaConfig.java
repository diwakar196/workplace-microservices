package com.example.employee.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfig {
	
	@Bean
	public NewTopic projectTopic() {
		return TopicBuilder.name("project_topic").build();
	}
	
	@Bean
	public NewTopic teamTopic() {
		return TopicBuilder.name("team_topic").build();
	}
}
