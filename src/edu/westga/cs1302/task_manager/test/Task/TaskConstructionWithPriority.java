package edu.westga.cs1302.task_manager.test.Task;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import edu.westga.cs1302.task_manager.model.Task;
import edu.westga.cs1302.task_manager.model.TaskPriority;

public class TaskConstructionWithPriority {
	@Rule
	public ExpectedException expected = ExpectedException.none();

	@Test
	public void testTaskInValidDescription() {

		String Stuff = null;
		TaskPriority priority = TaskPriority.HIGH;

		this.expected.expect(IllegalArgumentException.class);
		Task school = new Task(Stuff, priority);

	}

	@Test
	public void testTaskWithIdIsValid() {

		String Stuff = "Do School Work";
		TaskPriority priority = TaskPriority.HIGH;

		Task school = new Task(Stuff, priority);
		assertEquals(school.getDescription(), Stuff);

		assertTrue(school != null);

	}
}
