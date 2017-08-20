package ekuetkpodar.task_manager.test.Project;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import ekuetkpodar.task_manager.model.Project;
import ekuetkpodar.task_manager.model.SimpleTask;
import ekuetkpodar.task_manager.model.TaskPriority;

public class TestAddTask {

	@Rule
	public ExpectedException expected = ExpectedException.none();

	@Test
	public void TestAddTaskInvalid() {
		Project project = new Project("Finals");
		SimpleTask school = null;

		this.expected.expect(IllegalArgumentException.class);
		project.addTask(school);

	}

	@Test
	public void TestAddTaskValid() {
		Project project = new Project("Finals");
		SimpleTask school = new SimpleTask("work");
		project.addTask(school);
		assertEquals(school, project.getSimpleTask(school.getId()));

	}
	
	
}
