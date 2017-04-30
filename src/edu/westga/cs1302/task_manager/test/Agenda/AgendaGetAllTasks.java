package edu.westga.cs1302.task_manager.test.Agenda;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import edu.westga.cs1302.task_manager.model.Agenda;
import edu.westga.cs1302.task_manager.model.PriorityOrder;
import edu.westga.cs1302.task_manager.model.Task;

public class AgendaGetAllTasks {
	
	@Test
	public void TestGetAllWhenListIsEmpty() {
		ArrayList<Task> itr = new ArrayList<Task>();
		Agenda agenda = new Agenda(new PriorityOrder(itr));
		
		ArrayList<Task> task =new ArrayList<Task> ();
	
		assertEquals(agenda.getAllTask(),task);
		
		
	}
	
	
	@Test
	public void TestGetOnlyOneTaskOnTheList() {
		Task school = new Task("Study");
		ArrayList<Task> itr = new ArrayList<Task>();
		Agenda agenda = new Agenda(new PriorityOrder(itr));
		agenda.addTask(school);
		ArrayList<Task> task =new ArrayList<Task> ();
		task.add(school);
		assertEquals(agenda.getAllTask(),task);
		
		
	}
	
	@Test
	public void AgendaGetAllTaskManyTaskOnAgenda() {
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
		ArrayList<Task> task =new ArrayList<Task> ();
		task.add(school);
		task.add(school2);
		task.add(school3);
		assertEquals(agenda.getAllTask(),task);
		
		
	}

}
