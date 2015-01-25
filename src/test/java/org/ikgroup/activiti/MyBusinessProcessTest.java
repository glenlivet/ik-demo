package org.ikgroup.activiti;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.validation.constraints.AssertTrue;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.activiti.engine.test.ActivitiRule;
import org.activiti.engine.test.Deployment;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/WEB-INF/spring/root-context.xml")
public class MyBusinessProcessTest {
	
	 @Autowired
	  private RuntimeService runtimeService;

	  @Autowired
	  private TaskService taskService;

	  @Autowired
	  @Rule
	  public ActivitiRule activitiSpringRule;

	  @Test
	  @Deployment
	  public void simpleProcessTest() {
	    runtimeService.startProcessInstanceByKey("oneTaskProcess");
	    List<Task> tasks = taskService.createTaskQuery().list();
	    assertEquals(true, (tasks.size() > 0));
	    assertEquals("my task", tasks.get(0).getName());

	    taskService.complete(tasks.get(0).getId());
	    System.out.println(runtimeService.createProcessInstanceQuery().count());

	  }
	
}
