package edu.westga.cs1302.task_manager.test.Task;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import edu.westga.cs1302.task_manager.model.Task;
import edu.westga.cs1302.task_manager.model.TaskPriority;

public class TaskConstructionWithCost {

	@Rule public ExpectedException expected = ExpectedException.none();

	@Test
	public void TaskConstructionWithCostIsNegative() {
	
		this.expected.expect(IllegalArgumentException.class);
		Task school = new Task("Studys",TaskPriority.HIGH,  LocalDate.of(2017, 12, 31),-9);
		
	}
	
	@Test
	public void TaskConstructionWithCostIsZero() {
	
		this.expected.expect(IllegalArgumentException.class);
		Task school = new Task("Studys",TaskPriority.HIGH,  LocalDate.of(2017, 12, 31),0);
		
	}
	
	@Test
	public void TaskConstructionWithCostIsValid() {
	
		String Stuff = "Do School Work";
		Task school = new Task(Stuff,TaskPriority.HIGH, LocalDate.of(2017, 12, 31),500);
		assertEquals(500,school.getCost());
		
		
	}
}
