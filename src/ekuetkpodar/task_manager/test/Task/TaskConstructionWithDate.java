package ekuetkpodar.task_manager.test.Task;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import ekuetkpodar.task_manager.model.SimpleTask;
import ekuetkpodar.task_manager.model.TaskPriority;

public class TaskConstructionWithDate {

	@Rule public ExpectedException expected = ExpectedException.none();

	@Test
	public void testDescriptionIsInvalid() {
	
		this.expected.expect(IllegalArgumentException.class);
		SimpleTask school = new SimpleTask("Studys",TaskPriority.HIGH, null);
		
	}
	
	@Test
	public void testTaskIsValid() {
	
		String Stuff = "Do School Work";
		SimpleTask school = new SimpleTask(Stuff,TaskPriority.HIGH, LocalDate.of(2017, 12, 31));
		assertEquals(school.getDescription(),Stuff);
		assertEquals(LocalDate.of(2017, 12, 31),school.getDate());
		assertTrue(school.getDate() != null);
		
	}
}
