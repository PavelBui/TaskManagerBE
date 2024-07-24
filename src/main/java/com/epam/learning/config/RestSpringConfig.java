package com.epam.learning.config;

import com.epam.learning.entity.TaskEntity;
import com.epam.learning.enums.Priority;
import com.epam.learning.enums.Status;
import com.epam.learning.repository.TaskRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.time.LocalDateTime;

@Configuration
public class RestSpringConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("Task-Manager-API")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.epam.learning.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    @Bean
    CommandLineRunner initDatabase(TaskRepository taskRepository) {
        return args -> {
            var task1 = taskRepository.save(
                    new TaskEntity(null,
                            "To write an article",
                            "Write an article for the scientific and practical conference \"Is there life on Mars\"",
                            Status.TODO,
                            Priority.MEDIUM,
                            LocalDateTime.of(2024, 7,18, 12, 0),
                            LocalDateTime.of(2024, 8,3, 23, 59),
                            null,
                            false
                    )
            );
            var task2 = taskRepository.save(
                    new TaskEntity(null,
                            "Any title",
                            "Any content",
                            Status.TODO,
                            Priority.LOW,
                            LocalDateTime.of(2024, 7,18, 13, 0),
                            LocalDateTime.of(2024, 12,31, 23, 59),
                            null,
                            false
                    )
            );
            var task3 = taskRepository.save(
                    new TaskEntity(null,
                            "Test title",
                            "Test content",
                            Status.IN_PROGRESS,
                            Priority.TOP,
                            LocalDateTime.of(2024, 7,18, 14, 0),
                            LocalDateTime.of(2024, 10 ,10, 10, 0),
                            null,
                            false
                    )
            );
        };
    }
}
