package edu.westga.cs1302.task_manager.test.Task;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import edu.westga.cs1302.task_manager.model.SimpleTask;

public class TaskConstruction {
	@Rule public ExpectedException expected = ExpectedException.none();

	@Test
	public void testDescriptionIsInvalid() {
	
		this.expected.expect(IllegalArgumentException.class);
		SimpleTask school = new SimpleTask(null);
		
	}
	
	@Test
	public void testTaskIsValid() {
	
		String Stuff = "Do School Work";
		SimpleTask school = new SimpleTask(Stuff);
		assertEquals(school.getDescription(),Stuff);
		
	}


}
