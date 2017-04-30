package edu.westga.cs1302.task_manager.test.Agenda;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import edu.westga.cs1302.task_manager.model.Agenda;
import edu.westga.cs1302.task_manager.model.PriorityOrder;
import edu.westga.cs1302.task_manager.model.Task;

public class AgendaAddTask {

	
	@Rule public ExpectedException expected = ExpectedException.none();

	@Test
	public void AgendaAddTaskIsInvalid() {
		Task school = null;
		ArrayList<Task> itr = new ArrayList<Task>();
		Agenda agenda = new Agenda(new PriorityOrder(itr));
		this.expected.expect(IllegalArgumentException.class);
		agenda.addTask(school);
		
		
	}
	
	@Test
	public void AgendaAddTaskIsValid() {
		Task school = new Task("Study");
		ArrayList<Task> itr = new ArrayList<Task>();
		Agenda agenda = new Agenda(new PriorityOrder(itr));
		agenda.addTask(school);
		int id = school.getId();
		assertEquals(agenda.getTask(id),school);
		
		
	}
	
	@Test
	public void AgendaAddTaskIsMany() {
		Task school = new Task("Study");
		Task school2 = new Task("Study 2");
		Task school3 = new Task("Study 2");
		ArrayList<Task> itr = new ArrayList<Task>();
		Agenda agenda = new Agenda(new PriorityOrder(itr));
		agenda.addTask(school);
		agenda.addTask(school2);
		agenda.addTask(school3);
		int id = school.getId();
		int id2 = school2.getId();
		int id3 = school3.getId();
		assertEquals(agenda.getTask(id),school);
		assertEquals(agenda.getTask(id2),school2);
		assertEquals(agenda.getTask(id3),school3);
		
		
	}
	
	
}
