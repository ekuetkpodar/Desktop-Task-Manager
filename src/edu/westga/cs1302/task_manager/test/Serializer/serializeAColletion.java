package edu.westga.cs1302.task_manager.test.Serializer;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import edu.westga.cs1302.task_manager.model.Serializer;
import edu.westga.cs1302.task_manager.model.SimpleTask;
import edu.westga.cs1302.task_manager.model.TaskPriority;

public class serializeAColletion {

	@Rule public ExpectedException expected = ExpectedException.none();

	@Test
	public void serializeAColletionWithAInvalidTask() {
		ArrayList<SimpleTask>task = null;
		Serializer print = new Serializer();
		this.expected.expect(IllegalArgumentException.class);
		print.serializeAColletion(task);
	
	}
	
	@Test
	public void serializeAColletionWithOneTaskiNCollection() {
		
		String output = "*************Task Beginning*************" + "\n";
		SimpleTask school = new SimpleTask("Read",TaskPriority.HIGH, LocalDate.of(2017, 12, 31),500);
		
		ArrayList<SimpleTask> collection = new ArrayList<SimpleTask> ();
		collection.add(school);
		Serializer print = new Serializer();
		String test = "Read"+"\t"+school.getId()+"\t"+TaskPriority.HIGH+"\t"+ LocalDate.of(2017, 12, 31)+"\t"+500+"\t";
		output += test+"\n";
		output += "*************Task       End*************";
		assertEquals(output,print.serializeAColletion(collection));
	}
	
	
	@Test
	public void serializeAColletionWithTwoTaskiNCollection() {
		
		String output = "*************Task Beginning*************" + "\n";
		SimpleTask school = new SimpleTask("Read",TaskPriority.HIGH, LocalDate.of(2017, 12, 31),500);
		SimpleTask work = new SimpleTask("web", TaskPriority.MEDIUM, LocalDate.of(2017, 12, 31), 250);
		
		ArrayList<SimpleTask> collection = new ArrayList<SimpleTask> ();
		collection.add(school);
		collection.add(work);
		Serializer print = new Serializer();
		String test = "Read"+"\t"+school.getId()+"\t"+TaskPriority.HIGH+"\t"+ LocalDate.of(2017, 12, 31)+"\t"+500+"\t";
		output += test+"\n";
		output += "web"+"\t"+work.getId()+"\t" +TaskPriority.MEDIUM+"\t"+ LocalDate.of(2017, 12, 31)+"\t"+ 250+"\t"+"\n";
		output += "*************Task       End*************";
		assertEquals(output,print.serializeAColletion(collection));
	}
	
	
	
	@Test
	public void serializeAColletionWithThreeTaskiNCollection() {
		
		String output = "*************Task Beginning*************" + "\n";
		SimpleTask school = new SimpleTask("Read",TaskPriority.HIGH, LocalDate.of(2017, 12, 31),500);
		SimpleTask work = new SimpleTask("web", TaskPriority.MEDIUM, LocalDate.of(2017, 12, 31), 250);
		SimpleTask other = new SimpleTask("games", TaskPriority.LOW, LocalDate.of(2018, 12, 31), 50);
		
		ArrayList<SimpleTask> collection = new ArrayList<SimpleTask> ();
		collection.add(school);
		collection.add(work);
		collection.add(other);
		
		Serializer print = new Serializer();
		String test = "Read"+"\t"+school.getId()+"\t"+TaskPriority.HIGH+"\t"+ LocalDate.of(2017, 12, 31)+"\t"+500+"\t";
		output += test+"\n";
		output += "web"+"\t"+work.getId()+"\t" +TaskPriority.MEDIUM+"\t"+ LocalDate.of(2017, 12, 31)+"\t"+ 250+"\t"+"\n";
		output += "games"+"\t"+other.getId()+"\t"+ TaskPriority.LOW +"\t"+ LocalDate.of(2018, 12, 31)+"\t"+ 50+"\t"+"\n";
		output += "*************Task       End*************";
		assertEquals(output,print.serializeAColletion(collection));
	}


}