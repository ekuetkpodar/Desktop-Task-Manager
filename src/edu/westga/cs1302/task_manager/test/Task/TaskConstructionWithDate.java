package edu.westga.cs1302.task_manager.test.Task;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import edu.westga.cs1302.task_manager.model.Task;
import edu.westga.cs1302.task_manager.model.TaskPriority;

public class TaskConstructionWithDate {

	@Rule public ExpectedException expected = ExpectedException.none();

	@Test
	public void testDescriptionIsInvalid() {
	
		this.expected.expect(IllegalArgumentException.class);
		Task school = new Task("Studys",TaskPriority.HIGH, null);
		
	}
	
	@Test
	public void testTaskIsValid() {
	
		String Stuff = "Do School Work";
		Task school = new Task(Stuff,TaskPriority.HIGH, LocalDate.of(2017, 12, 31));
		assertEquals(school.getDescription(),Stuff);
		assertEquals(LocalDate.of(2017, 12, 31),school.getDate());
		assertTrue(school.getDate() != null);
		
	}
}
