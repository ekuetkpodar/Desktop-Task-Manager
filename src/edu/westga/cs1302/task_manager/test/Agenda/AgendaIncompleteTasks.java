package edu.westga.cs1302.task_manager.test.Agenda;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import edu.westga.cs1302.task_manager.model.Agenda;
import edu.westga.cs1302.task_manager.model.PriorityOrder;
import edu.westga.cs1302.task_manager.model.SimpleTask;

public class AgendaIncompleteTasks {

	@Rule
	public ExpectedException expected = ExpectedException.none();

	@Test
	public void AgendaIncompleteTasksIsEmpty() {
		SimpleTask school = new SimpleTask("Study");
		ArrayList<SimpleTask> itr = new ArrayList<SimpleTask>();
		Agenda agenda = new Agenda(new PriorityOrder(itr));
		ArrayList<SimpleTask> test = null;

		assertEquals(test, agenda.incompleteTasks());
		assertNull(agenda.incompleteTasks());

	}

	@Test
	public void AgendaIncompleteTasksOneInCompleteTask() {
		SimpleTask school = new SimpleTask("Study");
		school.setCompleted(true);
		ArrayList<SimpleTask> itr = new ArrayList<SimpleTask>();
		Agenda agenda = new Agenda(new PriorityOrder(itr));
		agenda.addTask(school);

		ArrayList<SimpleTask> test = new ArrayList<SimpleTask>();
		test.add(school);

		assertEquals(null, agenda.incompleteTasks());

	}

	@Test
	public void AgendaIncompleteTasksOneCompleteTask() {
		SimpleTask school = new SimpleTask("Study");
		school.setCompleted(false);
		ArrayList<SimpleTask> itr = new ArrayList<SimpleTask>();
		Agenda agenda = new Agenda(new PriorityOrder(itr));
		agenda.addTask(school);

		ArrayList<SimpleTask> test = new ArrayList<SimpleTask>();

		test.add(school);

		assertEquals(test, agenda.incompleteTasks());

	}

	@Test
	public void AgendaIncompleteTasksManyCompleteTask() {
		SimpleTask school = new SimpleTask("Study");
		SimpleTask school2 = new SimpleTask("Study2");
		SimpleTask school3 = new SimpleTask("Study3");

		school.setCompleted(false);
		school2.setCompleted(false);
		school3.setCompleted(false);
		ArrayList<SimpleTask> itr = new ArrayList<SimpleTask>();

		Agenda agenda = new Agenda(new PriorityOrder(itr));
		agenda.addTask(school);
		agenda.addTask(school2);
		agenda.addTask(school3);

		ArrayList<SimpleTask> test = new ArrayList<SimpleTask>();

		test.add(school);
		test.add(school2);
		test.add(school3);

		assertEquals(test, agenda.incompleteTasks());

	}

	@Test
	public void AgendaIncompleteTasksOneCompleteTaskInTheMiddle() {
		SimpleTask school = new SimpleTask("Study");
		SimpleTask school2 = new SimpleTask("Study2");
		SimpleTask school3 = new SimpleTask("Study3");

		school.setCompleted(true);
		school2.setCompleted(false);
		school3.setCompleted(true);
		ArrayList<SimpleTask> itr = new ArrayList<SimpleTask>();
		Agenda agenda = new Agenda(new PriorityOrder(itr));
		agenda.addTask(school);
		agenda.addTask(school2);
		agenda.addTask(school3);

		ArrayList<SimpleTask> test = new ArrayList<SimpleTask>();

		test.add(school2);

		assertEquals(test, agenda.incompleteTasks());

	}

	@Test
	public void AgendaIncompleteTasksOneompleteTaskaTTheEnd() {
		SimpleTask school = new SimpleTask("Study");
		SimpleTask school2 = new SimpleTask("Study2");
		SimpleTask school3 = new SimpleTask("Study3");

		school.setCompleted(true);
		school2.setCompleted(true);
		school3.setCompleted(false);
		ArrayList<SimpleTask> itr = new ArrayList<SimpleTask>();

		Agenda agenda = new Agenda(new PriorityOrder(itr));
		agenda.addTask(school);
		agenda.addTask(school2);
		agenda.addTask(school3);

		ArrayList<SimpleTask> test = new ArrayList<SimpleTask>();

		test.add(school3);

		assertEquals(test, agenda.incompleteTasks());

	}
}