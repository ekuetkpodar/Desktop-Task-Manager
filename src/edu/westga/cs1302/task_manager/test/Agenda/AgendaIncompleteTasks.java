package edu.westga.cs1302.task_manager.test.Agenda;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import edu.westga.cs1302.task_manager.model.Agenda;
import edu.westga.cs1302.task_manager.model.PriorityOrder;
import edu.westga.cs1302.task_manager.model.Task;

public class AgendaIncompleteTasks {

	@Rule
	public ExpectedException expected = ExpectedException.none();

	@Test
	public void AgendaIncompleteTasksIsEmpty() {
		Task school = new Task("Study");
		ArrayList<Task> itr = new ArrayList<Task>();
		Agenda agenda = new Agenda(new PriorityOrder(itr));
		ArrayList<Task> test = null;

		assertEquals(test, agenda.incompleteTasks());
		assertNull(agenda.incompleteTasks());

	}

	@Test
	public void AgendaIncompleteTasksOneInCompleteTask() {
		Task school = new Task("Study");
		school.setCompleted(true);
		ArrayList<Task> itr = new ArrayList<Task>();
		Agenda agenda = new Agenda(new PriorityOrder(itr));
		agenda.addTask(school);

		ArrayList<Task> test = new ArrayList<Task>();
		test.add(school);

		assertEquals(null, agenda.incompleteTasks());

	}

	@Test
	public void AgendaIncompleteTasksOneCompleteTask() {
		Task school = new Task("Study");
		school.setCompleted(false);
		ArrayList<Task> itr = new ArrayList<Task>();
		Agenda agenda = new Agenda(new PriorityOrder(itr));
		agenda.addTask(school);

		ArrayList<Task> test = new ArrayList<Task>();

		test.add(school);

		assertEquals(test, agenda.incompleteTasks());

	}

	@Test
	public void AgendaIncompleteTasksManyCompleteTask() {
		Task school = new Task("Study");
		Task school2 = new Task("Study2");
		Task school3 = new Task("Study3");

		school.setCompleted(false);
		school2.setCompleted(false);
		school3.setCompleted(false);
		ArrayList<Task> itr = new ArrayList<Task>();

		Agenda agenda = new Agenda(new PriorityOrder(itr));
		agenda.addTask(school);
		agenda.addTask(school2);
		agenda.addTask(school3);

		ArrayList<Task> test = new ArrayList<Task>();

		test.add(school);
		test.add(school2);
		test.add(school3);

		assertEquals(test, agenda.incompleteTasks());

	}

	@Test
	public void AgendaIncompleteTasksOneCompleteTaskInTheMiddle() {
		Task school = new Task("Study");
		Task school2 = new Task("Study2");
		Task school3 = new Task("Study3");

		school.setCompleted(true);
		school2.setCompleted(false);
		school3.setCompleted(true);
		ArrayList<Task> itr = new ArrayList<Task>();
		Agenda agenda = new Agenda(new PriorityOrder(itr));
		agenda.addTask(school);
		agenda.addTask(school2);
		agenda.addTask(school3);

		ArrayList<Task> test = new ArrayList<Task>();

		test.add(school2);

		assertEquals(test, agenda.incompleteTasks());

	}

	@Test
	public void AgendaIncompleteTasksOneompleteTaskaTTheEnd() {
		Task school = new Task("Study");
		Task school2 = new Task("Study2");
		Task school3 = new Task("Study3");

		school.setCompleted(true);
		school2.setCompleted(true);
		school3.setCompleted(false);
		ArrayList<Task> itr = new ArrayList<Task>();

		Agenda agenda = new Agenda(new PriorityOrder(itr));
		agenda.addTask(school);
		agenda.addTask(school2);
		agenda.addTask(school3);

		ArrayList<Task> test = new ArrayList<Task>();

		test.add(school3);

		assertEquals(test, agenda.incompleteTasks());

	}
}