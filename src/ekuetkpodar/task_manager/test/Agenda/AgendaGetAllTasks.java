package ekuetkpodar.task_manager.test.Agenda;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import ekuetkpodar.task_manager.model.Agenda;
import ekuetkpodar.task_manager.model.PriorityOrder;
import ekuetkpodar.task_manager.model.SimpleTask;

public class AgendaGetAllTasks {
	
	@Test
	public void TestGetAllWhenListIsEmpty() {
		ArrayList<SimpleTask> itr = new ArrayList<SimpleTask>();
		Agenda agenda = new Agenda(new PriorityOrder(itr));
		
		ArrayList<SimpleTask> task =new ArrayList<SimpleTask> ();
	
		assertEquals(agenda.getAllTask(),task);
		
		
	}
	
	
	@Test
	public void TestGetOnlyOneTaskOnTheList() {
		SimpleTask school = new SimpleTask("Study");
		ArrayList<SimpleTask> itr = new ArrayList<SimpleTask>();
		Agenda agenda = new Agenda(new PriorityOrder(itr));
		agenda.addTask(school);
		ArrayList<SimpleTask> task =new ArrayList<SimpleTask> ();
		task.add(school);
		assertEquals(agenda.getAllTask(),task);
		
		
	}
	
	@Test
	public void AgendaGetAllTaskManyTaskOnAgenda() {
		SimpleTask school = new SimpleTask("Study");
		SimpleTask school2 = new SimpleTask("Study 2");
		SimpleTask school3 = new SimpleTask("Study 2");
		ArrayList<SimpleTask> itr = new ArrayList<SimpleTask>();
		Agenda agenda = new Agenda(new PriorityOrder(itr));
		agenda.addTask(school);
		agenda.addTask(school2);
		agenda.addTask(school3);
		int id = school.getId();
		int id2 = school2.getId();
		int id3 = school3.getId();
		ArrayList<SimpleTask> task =new ArrayList<SimpleTask> ();
		task.add(school);
		task.add(school2);
		task.add(school3);
		assertEquals(agenda.getAllTask(),task);
		
		
	}

}
