package com.epam.learning.mapper;

import com.epam.learning.dto.TaskDto;
import com.epam.learning.entity.TaskEntity;
import com.epam.learning.utils.DateTimeUtils;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {

    public TaskEntity dtoToEntity(TaskDto taskDto) {
        TaskEntity taskEntity = new TaskEntity();
        taskEntity.setIsDeleted(false);
        dtoToEntity(taskDto, taskEntity);
        return taskEntity;
    }

    public TaskEntity dtoToEntity(TaskDto taskDto, TaskEntity taskEntity) {
        taskEntity.setId(taskDto.getId());
        taskEntity.setTitle(taskDto.getTitle());
        taskEntity.setContent(taskDto.getContent());
        taskEntity.setStatus(taskDto.getStatus());
        taskEntity.setPriority(taskDto.getPriority());
        taskEntity.setDueDate(DateTimeUtils.convertTimestampToDate(taskDto.getDueDate()));
        taskEntity.setCreateDate(DateTimeUtils.convertTimestampToDate(taskDto.getCreatedDate()));
        return taskEntity;
    }

    public TaskDto entityToDto(TaskEntity taskEntity) {
        return TaskDto.builder()
                .id(taskEntity.getId())
                .title(taskEntity.getTitle())
                .content(taskEntity.getContent())
                .status(taskEntity.getStatus())
                .priority(taskEntity.getPriority())
                .dueDate(DateTimeUtils.convertDateToTimestamp(taskEntity.getDueDate()))
                .createdDate(DateTimeUtils.convertDateToTimestamp(taskEntity.getCreateDate()))
                .build();
    }
}
