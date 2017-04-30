package edu.westga.cs1302.task_manager.test.PriorityOrder;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.Test;

import edu.westga.cs1302.task_manager.model.Agenda;
import edu.westga.cs1302.task_manager.model.PriorityOrder;
import edu.westga.cs1302.task_manager.model.Task;
import edu.westga.cs1302.task_manager.model.TaskPriority;

public class PriorityOrderNext {

	@Test
	public void PriorityOrderNextWithOnlyOneTask() {

		Task school = new Task("Study", TaskPriority.HIGH);

		ArrayList<Task> collection = new ArrayList<Task>();
		collection.add(school);
		PriorityOrder priority = new PriorityOrder(collection);

		assertEquals(school, priority.next());
	}

	@Test
	public void PriorityOrderNextWithHighPriorityInMiddle() {

		Task school = new Task("Study", TaskPriority.HIGH);
		Task work = new Task("web", TaskPriority.MEDIUM);
		Task other = new Task("games", TaskPriority.LOW);

		ArrayList<Task> collection = new ArrayList<Task>();
		collection.add(work);
		collection.add(school);
		collection.add(other);
		PriorityOrder priority = new PriorityOrder(collection);

		assertEquals(school, priority.next());
	}

	@Test
	public void PriorityOrderNextWithHighPriorityInEnd() {

		Task school = new Task("Study", TaskPriority.HIGH);
		Task work = new Task("web", TaskPriority.MEDIUM);
		Task other = new Task("games", TaskPriority.LOW);

		ArrayList<Task> collection = new ArrayList<Task>();
		collection.add(work);
		collection.add(other);
		collection.add(school);
		PriorityOrder priority = new PriorityOrder(collection);

		assertEquals(school, priority.next());
		assertEquals(work, priority.next());
	}

	@Test
	public void PriorityOrderNextTestMeduim() {

		Task school = new Task("Study", TaskPriority.HIGH);
		Task work = new Task("web", TaskPriority.MEDIUM);
		Task other = new Task("games", TaskPriority.LOW);

		ArrayList<Task> collection = new ArrayList<Task>();
		collection.add(work);
		collection.add(other);
		collection.add(school);
		PriorityOrder priority = new PriorityOrder(collection);

		priority.next();
		assertEquals(work, priority.next());
	}

	@Test
	public void PriorityOrderNextTestLow() {

		Task school = new Task("Study", TaskPriority.HIGH);
		Task work = new Task("web", TaskPriority.MEDIUM);
		Task other = new Task("games", TaskPriority.LOW);

		ArrayList<Task> collection = new ArrayList<Task>();
		collection.add(work);
		collection.add(other);
		collection.add(school);
		PriorityOrder priority = new PriorityOrder(collection);

		priority.next();
		priority.next();
		assertEquals(other, priority.next());
	}

	@Test
	public void PriorityOrderNextWithTwoOfSamePriority() {

		Task school = new Task("Studys", TaskPriority.HIGH);

		Task work = new Task("web", TaskPriority.HIGH);

		ArrayList<Task> collection = new ArrayList<Task>();
		int id;
		if (school.getId() > work.getId()) {
			id = work.getId();
		} else {
			id = school.getId();
		}
		collection.add(school);
		collection.add(work);
		PriorityOrder priority = new PriorityOrder(collection);

		assertEquals(id, priority.next().getId());
	}

}
