package ekuetkpodar.test.DeadlineOrder;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.Test;

import ekuetkpodar.task_manager.model.DeadlineOrder;
import ekuetkpodar.task_manager.model.SimpleTask;
import ekuetkpodar.task_manager.model.TaskPriority;

public class DeadlineOrderNext {

	@Test
	public void DeadlineOrderNextOnlyOneTask() {

		SimpleTask school = new SimpleTask("Studys", TaskPriority.HIGH, LocalDate.of(2017, 12, 31));

		ArrayList<SimpleTask> collection = new ArrayList<SimpleTask>();
		collection.add(school);
		DeadlineOrder priority = new DeadlineOrder(collection);
		assertEquals(school, priority.next());

	}

	@Test
	public void DeadlineOrderNextInMiddle() {

		SimpleTask school = new SimpleTask("Studys", TaskPriority.HIGH, LocalDate.of(2017, 12, 31));

		SimpleTask work = new SimpleTask("web", TaskPriority.MEDIUM, LocalDate.of(2016, 12, 31));
		SimpleTask other = new SimpleTask("games", TaskPriority.LOW, LocalDate.of(2015, 12, 31));

		ArrayList<SimpleTask> collection = new ArrayList<SimpleTask>();

		collection.add(work);
		collection.add(school);
		collection.add(other);

		DeadlineOrder priority = new DeadlineOrder(collection);

		assertEquals(school, priority.next());

	}

	@Test
	public void DeadlineOrderNextInTheEnd() {

		SimpleTask school = new SimpleTask("Studys", TaskPriority.HIGH, LocalDate.of(2017, 12, 31));

		SimpleTask work = new SimpleTask("web", TaskPriority.MEDIUM, LocalDate.of(2016, 12, 31));
		SimpleTask other = new SimpleTask("games", TaskPriority.LOW, LocalDate.of(2015, 12, 31));

		ArrayList<SimpleTask> collection = new ArrayList<SimpleTask>();

		collection.add(work);

		collection.add(other);
		collection.add(school);

		DeadlineOrder priority = new DeadlineOrder(collection);

		assertEquals(school, priority.next());

	}

	@Test
	public void DeadlineOrderNextSecondCall() {

		SimpleTask school = new SimpleTask("Studys", TaskPriority.HIGH, LocalDate.of(2017, 12, 31));

		SimpleTask work = new SimpleTask("web", TaskPriority.MEDIUM, LocalDate.of(2016, 12, 31));
		SimpleTask other = new SimpleTask("games", TaskPriority.LOW, LocalDate.of(2015, 12, 31));

		ArrayList<SimpleTask> collection = new ArrayList<SimpleTask>();

		collection.add(work);

		collection.add(other);
		collection.add(school);

		DeadlineOrder priority = new DeadlineOrder(collection);
		priority.next();

		assertEquals(work, priority.next());

	}

	@Test
	public void DeadlineOrderThirdCall() {

		SimpleTask school = new SimpleTask("Studys", TaskPriority.HIGH, LocalDate.of(2017, 12, 31));

		SimpleTask work = new SimpleTask("web", TaskPriority.MEDIUM, LocalDate.of(2016, 12, 31));
		SimpleTask other = new SimpleTask("games", TaskPriority.LOW, LocalDate.of(2015, 12, 31));

		ArrayList<SimpleTask> collection = new ArrayList<SimpleTask>();

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

		SimpleTask school = new SimpleTask("Studys", TaskPriority.HIGH, LocalDate.of(2017, 12, 31));

		SimpleTask work = new SimpleTask("web", TaskPriority.MEDIUM, LocalDate.of(2017, 12, 31));

		ArrayList<SimpleTask> collection = new ArrayList<SimpleTask>();
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
