package ekuetkpodar.task_manager.test.PriorityOrder;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.Test;

import ekuetkpodar.task_manager.model.Agenda;
import ekuetkpodar.task_manager.model.PriorityOrder;
import ekuetkpodar.task_manager.model.SimpleTask;
import ekuetkpodar.task_manager.model.TaskPriority;

public class PriorityOrderNext {

	@Test
	public void PriorityOrderNextWithOnlyOneTask() {

		SimpleTask school = new SimpleTask("Study", TaskPriority.HIGH);

		ArrayList<SimpleTask> collection = new ArrayList<SimpleTask>();
		collection.add(school);
		PriorityOrder priority = new PriorityOrder(collection);

		assertEquals(school, priority.next());
	}

	@Test
	public void PriorityOrderNextWithHighPriorityInMiddle() {

		SimpleTask school = new SimpleTask("Study", TaskPriority.HIGH);
		SimpleTask work = new SimpleTask("web", TaskPriority.MEDIUM);
		SimpleTask other = new SimpleTask("games", TaskPriority.LOW);

		ArrayList<SimpleTask> collection = new ArrayList<SimpleTask>();
		collection.add(work);
		collection.add(school);
		collection.add(other);
		PriorityOrder priority = new PriorityOrder(collection);

		assertEquals(school, priority.next());
	}

	@Test
	public void PriorityOrderNextWithHighPriorityInEnd() {

		SimpleTask school = new SimpleTask("Study", TaskPriority.HIGH);
		SimpleTask work = new SimpleTask("web", TaskPriority.MEDIUM);
		SimpleTask other = new SimpleTask("games", TaskPriority.LOW);

		ArrayList<SimpleTask> collection = new ArrayList<SimpleTask>();
		collection.add(work);
		collection.add(other);
		collection.add(school);
		PriorityOrder priority = new PriorityOrder(collection);

		assertEquals(school, priority.next());
		assertEquals(work, priority.next());
	}

	@Test
	public void PriorityOrderNextTestMeduim() {

		SimpleTask school = new SimpleTask("Study", TaskPriority.HIGH);
		SimpleTask work = new SimpleTask("web", TaskPriority.MEDIUM);
		SimpleTask other = new SimpleTask("games", TaskPriority.LOW);

		ArrayList<SimpleTask> collection = new ArrayList<SimpleTask>();
		collection.add(work);
		collection.add(other);
		collection.add(school);
		PriorityOrder priority = new PriorityOrder(collection);

		priority.next();
		assertEquals(work, priority.next());
	}

	@Test
	public void PriorityOrderNextTestLow() {

		SimpleTask school = new SimpleTask("Study", TaskPriority.HIGH);
		SimpleTask work = new SimpleTask("web", TaskPriority.MEDIUM);
		SimpleTask other = new SimpleTask("games", TaskPriority.LOW);

		ArrayList<SimpleTask> collection = new ArrayList<SimpleTask>();
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

		SimpleTask school = new SimpleTask("Studys", TaskPriority.HIGH);

		SimpleTask work = new SimpleTask("web", TaskPriority.HIGH);

		ArrayList<SimpleTask> collection = new ArrayList<SimpleTask>();
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
