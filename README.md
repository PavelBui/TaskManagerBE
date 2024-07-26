# TaskManagerBE

REST API that allows to manage tasks. 


## How to run:
- Pre-installation of Maven and jdk17 is required
- Clone the Git repository: `https://github.com/PavelBui/TaskManagerBE` (main branch)
- Run the command `mvn clean package` in the root folder
- Run the command `java -jar TaskManagerBE-1.0-SNAPSHOT.jar` in the `target` folder

## Parameters
- **Port** - 8081
- **URL** - http://localhost:8081
- **Swagger** - http://localhost:8081/swagger-ui/index.html
- **DB console** - http://localhost:8081/h2-console

## DB console connection parameters
- **Driver Class** - org.h2.Driver
- **JDBC URL** - jdbc:h2:mem:dcbapp
- **User Name** - sa
- **Password** - password

## Endpoints
- **Create task** - POST request http://localhost:8081/tasks
    - `RequestBody: TaskDto`
    - `ResponseBody: String` (Task was created successfully)
- **Get task** - GET request http://localhost:8081/tasks/{id}
    - `PathVariable: task id`
    - `ResponseBody: TaskDto`
- **Get all tasks** - GET request http://localhost:8081/tasks
    - `ResponseBody: List of TaskDto`
- **Update task** - PUT request http://localhost:8081/tasks/{id}
    - `PathVariable: task id`
    - `RequestBody: TaskDto`
    - `ResponseBody: TaskDto`
- **Delete task** - DELETE request http://localhost:8081/tasks/{id}
    - `PathVariable: task id`
    - `ResponseBody: String` (Task was deleted successfully)

## TaskDto (example)
```json
{
    "id": 0,
    "title": "string",
    "content": "string",
    "priority": "LOW",
    "status": "DONE",
    "createdDate": 0,
    "dueDate": 0
}
```

## Priority (available values)
- **LOW**
- **MEDIUM**
- **TOP**

## Status (available values)
- **TODO**
- **IN_PROGRESS**
- **REVIEW**
- **DONE**

## DateTime format
- **Pattern** - timestamp
- **Usage** - createdDate, dueDate