package ekuetkpodar.task_manager.test.Project;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import ekuetkpodar.task_manager.model.Project;
import ekuetkpodar.task_manager.model.SimpleTask;

public class TestgGetSimpleTask {

	@Rule
	public ExpectedException expected = ExpectedException.none();

	@Test
	public void TestgGetSimpleTaskTaskExist() {
		Project project = new Project("Finals");
		SimpleTask school = new SimpleTask("work");
		project.addTask(school);
		assertEquals(school, project.getSimpleTask(school.getId()));

	}

	@Test
	public void TestgGetSimpleTaskTaskDoesntExist() {
		Project project = new Project("Finals");
		SimpleTask school = new SimpleTask("work");

		assertEquals(null, project.getSimpleTask(8));

	}

	@Test
	public void TestgGetSimpleTaskInputIsInvalid() {
		Project project = new Project("Finals");

		this.expected.expect(IllegalArgumentException.class);
		project.getSimpleTask(-6);

	}

}
