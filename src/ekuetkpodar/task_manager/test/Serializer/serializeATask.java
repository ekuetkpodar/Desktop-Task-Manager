package ekuetkpodar.task_manager.test.Serializer;

import static org.junit.Assert.*;

import org.junit.Test;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import ekuetkpodar.task_manager.model.Serializer;
import ekuetkpodar.task_manager.model.SimpleTask;
import ekuetkpodar.task_manager.model.TaskPriority;

public class serializeATask {
	@Rule
	public ExpectedException expected = ExpectedException.none();

	@Test
	public void serializeATaskWithAInvalidTask() {
		SimpleTask task = null;
		Serializer print = new Serializer();
		this.expected.expect(IllegalArgumentException.class);
		print.serializeATask(task);

	}

	@Test
	public void serializeATaskWithOnlyDescription() {
		SimpleTask school = new SimpleTask("Read");
		Serializer print = new Serializer();
		String test = "Read" + "\t" + school.getId() + "\t";

		assertEquals(test, print.serializeATask(school));
	}

	@Test
	public void serializeATaskWithPriority() {
		SimpleTask school = new SimpleTask("Read", TaskPriority.HIGH);
		Serializer print = new Serializer();
		String test = "Read" + "\t" + school.getId() + "\t" + TaskPriority.HIGH + "\t";
		assertEquals(test, print.serializeATask(school));
	}

	@Test
	public void serializeATaskWithDate() {
		SimpleTask school = new SimpleTask("Read", TaskPriority.HIGH, LocalDate.of(2017, 12, 31));
		Serializer print = new Serializer();
		String test = "Read" + "\t" + school.getId() + "\t" + TaskPriority.HIGH + "\t" + LocalDate.of(2017, 12, 31)
				+ "\t";
		assertEquals(test, print.serializeATask(school));
	}

	@Test
	public void serializeATaskWithCost() {
		SimpleTask school = new SimpleTask("Read", TaskPriority.HIGH, LocalDate.of(2017, 12, 31), 500);
		Serializer print = new Serializer();
		String test = "Read" + "\t" + school.getId() + "\t" + TaskPriority.HIGH + "\t" + LocalDate.of(2017, 12, 31)
				+ "\t" + 500 + "\t";
		assertEquals(test, print.serializeATask(school));
	}

}
