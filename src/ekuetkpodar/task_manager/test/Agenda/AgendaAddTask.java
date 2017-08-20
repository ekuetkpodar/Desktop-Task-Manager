package ekuetkpodar.task_manager.test.Agenda;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import ekuetkpodar.task_manager.model.Agenda;
import ekuetkpodar.task_manager.model.PriorityOrder;
import ekuetkpodar.task_manager.model.SimpleTask;

public class AgendaAddTask {

	
	@Rule public ExpectedException expected = ExpectedException.none();

	@Test
	public void AgendaAddTaskIsInvalid() {
		SimpleTask school = null;
		ArrayList<SimpleTask> itr = new ArrayList<SimpleTask>();
		Agenda agenda = new Agenda(new PriorityOrder(itr));
		this.expected.expect(IllegalArgumentException.class);
		agenda.addTask(school);
		
		
	}
	
	@Test
	public void AgendaAddTaskIsValid() {
		SimpleTask school = new SimpleTask("Study");
		ArrayList<SimpleTask> itr = new ArrayList<SimpleTask>();
		Agenda agenda = new Agenda(new PriorityOrder(itr));
		agenda.addTask(school);
		int id = school.getId();
		assertEquals(agenda.getTask(id),school);
		
		
	}
	
	@Test
	public void AgendaAddTaskIsMany() {
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
		assertEquals(agenda.getTask(id),school);
		assertEquals(agenda.getTask(id2),school2);
		assertEquals(agenda.getTask(id3),school3);
		
		
	}
	
	
}
