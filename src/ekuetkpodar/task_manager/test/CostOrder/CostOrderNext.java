package ekuetkpodar.task_manager.test.CostOrder;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.Test;

import ekuetkpodar.task_manager.model.CostOrder;
import ekuetkpodar.task_manager.model.SimpleTask;
import ekuetkpodar.task_manager.model.TaskPriority;

public class CostOrderNext {

	@Test
	public void CostOrderNextOneTaskInCollection() {
		SimpleTask school = new SimpleTask("Studys", TaskPriority.HIGH, LocalDate.of(2017, 12, 31), 500);

		ArrayList<SimpleTask> collection = new ArrayList<SimpleTask>();

		collection.add(school);

		CostOrder priority = new CostOrder(collection);
		assertEquals(school, priority.next());

	}

	@Test
	public void CostOrderNextMiddleOfMany() {
		SimpleTask school = new SimpleTask("Studys", TaskPriority.HIGH, LocalDate.of(2017, 12, 31), 500);

		SimpleTask work = new SimpleTask("web", TaskPriority.MEDIUM, LocalDate.of(2017, 12, 31), 250);
		SimpleTask play = new SimpleTask("games", TaskPriority.LOW, LocalDate.of(2018, 12, 31), 50);

		ArrayList<SimpleTask> collection = new ArrayList<SimpleTask>();
		collection.add(play);
		collection.add(school);
		collection.add(work);

		CostOrder priority = new CostOrder(collection);
		assertEquals(school, priority.next());

	}

	@Test
	public void CostOrderNextEndOfMany() {
		SimpleTask school = new SimpleTask("Studys", TaskPriority.HIGH, LocalDate.of(2017, 12, 31), 500);

		SimpleTask work = new SimpleTask("web", TaskPriority.MEDIUM, LocalDate.of(2017, 12, 31), 250);
		SimpleTask play = new SimpleTask("games", TaskPriority.LOW, LocalDate.of(2018, 12, 31), 50);

		ArrayList<SimpleTask> collection = new ArrayList<SimpleTask>();
		collection.add(play);

		collection.add(work);
		collection.add(school);

		CostOrder priority = new CostOrder(collection);
		assertEquals(school, priority.next());

	}

	@Test
	public void CostOrderNextGetSecondTask() {
		SimpleTask school = new SimpleTask("Studys", TaskPriority.HIGH, LocalDate.of(2017, 12, 31), 500);

		SimpleTask work = new SimpleTask("web", TaskPriority.MEDIUM, LocalDate.of(2017, 12, 31), 250);
		SimpleTask play = new SimpleTask("games", TaskPriority.LOW, LocalDate.of(2018, 12, 31), 50);

		ArrayList<SimpleTask> collection = new ArrayList<SimpleTask>();
		collection.add(play);
		collection.add(school);
		collection.add(work);

		CostOrder priority = new CostOrder(collection);
		priority.next();
		assertEquals(work, priority.next());

	}

	@Test
	public void CostOrderNextGetThirdTask() {
		SimpleTask school = new SimpleTask("Studys", TaskPriority.HIGH, LocalDate.of(2017, 12, 31), 500);

		SimpleTask work = new SimpleTask("web", TaskPriority.MEDIUM, LocalDate.of(2017, 12, 31), 250);
		SimpleTask play = new SimpleTask("games", TaskPriority.LOW, LocalDate.of(2018, 12, 31), 50);

		ArrayList<SimpleTask> collection = new ArrayList<SimpleTask>();
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
		SimpleTask school = new SimpleTask("Studys", TaskPriority.HIGH, LocalDate.of(2017, 12, 31), 500);

		SimpleTask work = new SimpleTask("web", TaskPriority.MEDIUM, LocalDate.of(2017, 12, 31), 500);

		ArrayList<SimpleTask> collection = new ArrayList<SimpleTask>();
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
