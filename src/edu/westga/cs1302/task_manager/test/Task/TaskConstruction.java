package edu.westga.cs1302.task_manager.test.Task;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import edu.westga.cs1302.task_manager.model.Task;

public class TaskConstruction {
	@Rule public ExpectedException expected = ExpectedException.none();

	@Test
	public void testDescriptionIsInvalid() {
	
		this.expected.expect(IllegalArgumentException.class);
		Task school = new Task(null);
		
	}
	
	@Test
	public void testTaskIsValid() {
	
		String Stuff = "Do School Work";
		Task school = new Task(Stuff);
		assertEquals(school.getDescription(),Stuff);
		
	}


}
