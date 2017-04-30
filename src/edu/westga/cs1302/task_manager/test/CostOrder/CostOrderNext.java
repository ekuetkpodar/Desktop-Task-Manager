package edu.westga.cs1302.task_manager.test.CostOrder;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.Test;

import edu.westga.cs1302.task_manager.model.CostOrder;
import edu.westga.cs1302.task_manager.model.Task;
import edu.westga.cs1302.task_manager.model.TaskPriority;

public class CostOrderNext {

	@Test
	public void CostOrderNextOneTaskInCollection() {
		Task school = new Task("Studys", TaskPriority.HIGH, LocalDate.of(2017, 12, 31), 500);

		ArrayList<Task> collection = new ArrayList<Task>();

		collection.add(school);

		CostOrder priority = new CostOrder(collection);
		assertEquals(school, priority.next());

	}

	@Test
	public void CostOrderNextMiddleOfMany() {
		Task school = new Task("Studys", TaskPriority.HIGH, LocalDate.of(2017, 12, 31), 500);

		Task work = new Task("web", TaskPriority.MEDIUM, LocalDate.of(2017, 12, 31), 250);
		Task play = new Task("games", TaskPriority.LOW, LocalDate.of(2018, 12, 31), 50);

		ArrayList<Task> collection = new ArrayList<Task>();
		collection.add(play);
		collection.add(school);
		collection.add(work);

		CostOrder priority = new CostOrder(collection);
		assertEquals(school, priority.next());

	}

	@Test
	public void CostOrderNextEndOfMany() {
		Task school = new Task("Studys", TaskPriority.HIGH, LocalDate.of(2017, 12, 31), 500);

		Task work = new Task("web", TaskPriority.MEDIUM, LocalDate.of(2017, 12, 31), 250);
		Task play = new Task("games", TaskPriority.LOW, LocalDate.of(2018, 12, 31), 50);

		ArrayList<Task> collection = new ArrayList<Task>();
		collection.add(play);

		collection.add(work);
		collection.add(school);

		CostOrder priority = new CostOrder(collection);
		assertEquals(school, priority.next());

	}

	@Test
	public void CostOrderNextGetSecondTask() {
		Task school = new Task("Studys", TaskPriority.HIGH, LocalDate.of(2017, 12, 31), 500);

		Task work = new Task("web", TaskPriority.MEDIUM, LocalDate.of(2017, 12, 31), 250);
		Task play = new Task("games", TaskPriority.LOW, LocalDate.of(2018, 12, 31), 50);

		ArrayList<Task> collection = new ArrayList<Task>();
		collection.add(play);
		collection.add(school);
		collection.add(work);

		CostOrder priority = new CostOrder(collection);
		priority.next();
		assertEquals(work, priority.next());

	}

	@Test
	public void CostOrderNextGetThirdTask() {
		Task school = new Task("Studys", TaskPriority.HIGH, LocalDate.of(2017, 12, 31), 500);

		Task work = new Task("web", TaskPriority.MEDIUM, LocalDate.of(2017, 12, 31), 250);
		Task play = new Task("games", TaskPriority.LOW, LocalDate.of(2018, 12, 31), 50);

		ArrayList<Task> collection = new ArrayList<Task>();
		collection.add(play);
		collection.add(school);
		collection.add(work);

		CostOrder priority = new CostOrder(collection);
		priority.next();
		priority.next();
		assertEquals(play, priority.next());

	}

	@Test
	public void CostOrderNextWithSameCost() {
		Task school = new Task("Studys", TaskPriority.HIGH, LocalDate.of(2017, 12, 31), 500);

		Task work = new Task("web", TaskPriority.MEDIUM, LocalDate.of(2017, 12, 31), 500);

		ArrayList<Task> collection = new ArrayList<Task>();
		int id;
		if (school.getId() > work.getId()) {
			id = work.getId();
		} else {
			id = school.getId();
		}
		collection.add(school);
		collection.add(work);

		CostOrder priority = new CostOrder(collection);
		assertEquals(id, priority.next().getId());

	}

}
