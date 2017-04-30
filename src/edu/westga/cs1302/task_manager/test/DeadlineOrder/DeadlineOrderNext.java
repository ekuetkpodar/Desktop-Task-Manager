package edu.westga.cs1302.task_manager.test.DeadlineOrder;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.Test;


import edu.westga.cs1302.task_manager.model.DeadlineOrder;
import edu.westga.cs1302.task_manager.model.Task;
import edu.westga.cs1302.task_manager.model.TaskPriority;

public class DeadlineOrderNext {

	@Test
	public void DeadlineOrderNextOnlyOneTask() {

		Task school = new Task("Studys", TaskPriority.HIGH, LocalDate.of(2017, 12, 31));

		ArrayList<Task> collection = new ArrayList<Task>();
		collection.add(school);
		DeadlineOrder priority = new DeadlineOrder(collection);
		assertEquals(school, priority.next());

	}

	@Test
	public void DeadlineOrderNextInMiddle() {

		Task school = new Task("Studys", TaskPriority.HIGH, LocalDate.of(2017, 12, 31));

		Task work = new Task("web", TaskPriority.MEDIUM, LocalDate.of(2016, 12, 31));
		Task other = new Task("games", TaskPriority.LOW, LocalDate.of(2015, 12, 31));

		ArrayList<Task> collection = new ArrayList<Task>();

		collection.add(work);
		collection.add(school);
		collection.add(other);

		DeadlineOrder priority = new DeadlineOrder(collection);

		assertEquals(school, priority.next());

	}

	@Test
	public void DeadlineOrderNextInTheEnd() {

		Task school = new Task("Studys", TaskPriority.HIGH, LocalDate.of(2017, 12, 31));

		Task work = new Task("web", TaskPriority.MEDIUM, LocalDate.of(2016, 12, 31));
		Task other = new Task("games", TaskPriority.LOW, LocalDate.of(2015, 12, 31));

		ArrayList<Task> collection = new ArrayList<Task>();

		collection.add(work);

		collection.add(other);
		collection.add(school);

		DeadlineOrder priority = new DeadlineOrder(collection);

		assertEquals(school, priority.next());

	}
	
	@Test
	public void DeadlineOrderNextSecondCall() {

		Task school = new Task("Studys", TaskPriority.HIGH, LocalDate.of(2017, 12, 31));

		Task work = new Task("web", TaskPriority.MEDIUM, LocalDate.of(2016, 12, 31));
		Task other = new Task("games", TaskPriority.LOW, LocalDate.of(2015, 12, 31));

		ArrayList<Task> collection = new ArrayList<Task>();

		collection.add(work);

		collection.add(other);
		collection.add(school);

		DeadlineOrder priority = new DeadlineOrder(collection);
		priority.next();

		assertEquals(work, priority.next());

	}
	
	@Test
	public void DeadlineOrderThirdCall() {

		Task school = new Task("Studys", TaskPriority.HIGH, LocalDate.of(2017, 12, 31));

		Task work = new Task("web", TaskPriority.MEDIUM, LocalDate.of(2016, 12, 31));
		Task other = new Task("games", TaskPriority.LOW, LocalDate.of(2015, 12, 31));

		ArrayList<Task> collection = new ArrayList<Task>();

		collection.add(work);

		collection.add(other);
		collection.add(school);

		DeadlineOrder priority = new DeadlineOrder(collection);
		priority.next();
		priority.next();

		assertEquals(other, priority.next());

	}
	
	@Test
	public void DeadlineOrderNextSameDate() {

		Task school = new Task("Studys", TaskPriority.HIGH, LocalDate.of(2017, 12, 31));

		Task work = new Task("web", TaskPriority.MEDIUM, LocalDate.of(2017, 12, 31));

		ArrayList<Task> collection = new ArrayList<Task>();
		int id;
		if (school.getId() > work.getId()) {
			id = school.getId();
		} else {
			id = work.getId();
		}
		collection.add(school);
		collection.add(work);

		DeadlineOrder priority = new DeadlineOrder(collection);

		assertEquals(id, priority.next().getId());

	}



}
