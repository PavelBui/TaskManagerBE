package com.epam.learning.controller.impl;

import com.epam.learning.controller.TaskController;
import com.epam.learning.dto.TaskDto;
import com.epam.learning.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class TaskControllerImpl implements TaskController {

    private TaskService taskService;

    @Override
    public ResponseEntity<String> createTask(TaskDto taskDto) {
        taskDto.setId(null);
        return ResponseEntity.ok(taskService.createTask(taskDto));
    }

    @Override
    public ResponseEntity<TaskDto> updateTask(Integer id, TaskDto taskDto) {
        taskDto.setId(id);
        return ResponseEntity.ok(taskService.updateTask(id, taskDto));
    }

    @Override
    public ResponseEntity<String> deleteTask(Integer id) {
        return ResponseEntity.ok(taskService.deleteTask(id));
    }

    @Override
    public ResponseEntity<TaskDto> getTask(Integer id) {
        return ResponseEntity.ok(taskService.getTask(id));
    }

    @Override
    public ResponseEntity<List<TaskDto>> getAllTask() {
        return ResponseEntity.ok(taskService.getAllTask());
    }
}
