package br.com.sysconfer.web.controllers;

import br.com.sysconfer.entities.Task;
import br.com.sysconfer.services.TaskDao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("taskBB")
@Scope("request")
public class TaskBackingBean {

	private static final Logger logger = LoggerFactory.getLogger(TaskBackingBean.class);

	private Task task = new Task();
	private List<Task> tasks;

	@Autowired
	private TaskDao taskDao;

	
	public String getMessage() {
		logger.debug("Returning message from task home bean");
		return "Hello from Spring";
	}	

	public Task getTask() {
		return task;
	}

	public void saveTask() {
		taskDao.save(task);
		task = new Task();
		invalidateTasks();
	}

	private void invalidateTasks() {
		tasks = null;
	}

	public List<Task> getTasks() {
		if (tasks == null) {
			tasks = taskDao.list();
		}
		return tasks;
		
	}
}
