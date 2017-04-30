package edu.westga.cs1302.task_manager.test.Serializer;

import static org.junit.Assert.*;

import org.junit.Test;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import edu.westga.cs1302.task_manager.model.Serializer;
import edu.westga.cs1302.task_manager.model.Task;
import edu.westga.cs1302.task_manager.model.TaskPriority;

public class serializeATask {
	@Rule public ExpectedException expected = ExpectedException.none();

	@Test
	public void serializeATaskWithAInvalidTask() {
		Task task = null;
		Serializer print = new Serializer();
		this.expected.expect(IllegalArgumentException.class);
		print.serializeATask(task);
	
	}
	
	@Test
	public void serializeATaskWithOnlyDescription() {
		Task school = new Task("Read");
		Serializer print = new Serializer();
		String test = "Read"+"\t"+school.getId()+"\t";

		assertEquals(test,print.serializeATask(school));
	}
	
	@Test
	public void serializeATaskWithPriority() {
		Task school = new Task("Read",TaskPriority.HIGH);
		Serializer print = new Serializer();
		String test = "Read"+"\t"+school.getId()+"\t"+TaskPriority.HIGH+"\t";
		assertEquals(test,print.serializeATask(school));
	}
	
	@Test
	public void serializeATaskWithDate() {
		Task school = new Task("Read",TaskPriority.HIGH, LocalDate.of(2017, 12, 31));
		Serializer print = new Serializer();
		String test = "Read"+"\t"+school.getId()+"\t"+TaskPriority.HIGH+"\t"+ LocalDate.of(2017, 12, 31)+"\t";
		assertEquals(test,print.serializeATask(school));
	}
	
	@Test
	public void serializeATaskWithCost() {
		Task school = new Task("Read",TaskPriority.HIGH, LocalDate.of(2017, 12, 31),500);
		Serializer print = new Serializer();
		String test = "Read"+"\t"+school.getId()+"\t"+TaskPriority.HIGH+"\t"+ LocalDate.of(2017, 12, 31)+"\t"+500+"\t";
		assertEquals(test,print.serializeATask(school));
	}





}
