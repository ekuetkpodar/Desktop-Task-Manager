package ekuetkpodar.task_manager.test.Task;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import ekuetkpodar.task_manager.model.SimpleTask;
import ekuetkpodar.task_manager.model.TaskPriority;

public class TaskConstructionWithPriority {
	@Rule
	public ExpectedException expected = ExpectedException.none();

	@Test
	public void testTaskInValidDescription() {

		String Stuff = null;
		TaskPriority priority = TaskPriority.HIGH;

		this.expected.expect(IllegalArgumentException.class);
		SimpleTask school = new SimpleTask(Stuff, priority);

	}

	@Test
	public void testTaskWithIdIsValid() {

		String Stuff = "Do School Work";
		TaskPriority priority = TaskPriority.HIGH;

		SimpleTask school = new SimpleTask(Stuff, priority);
		assertEquals(school.getDescription(), Stuff);

		assertTrue(school != null);

	}
}
