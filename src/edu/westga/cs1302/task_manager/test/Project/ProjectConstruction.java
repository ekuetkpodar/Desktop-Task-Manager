package edu.westga.cs1302.task_manager.test.Project;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import edu.westga.cs1302.task_manager.model.Project;
import edu.westga.cs1302.task_manager.model.SimpleTask;
import edu.westga.cs1302.task_manager.model.TaskPriority;

public class ProjectConstruction {


	@Rule public ExpectedException expected = ExpectedException.none();

	@Test
	public void ProjectConstructionDescripitionIsInvalid() {
	
		this.expected.expect(IllegalArgumentException.class);
		Project project = new Project(null);
		
		
	}
	
	
	
	@Test
	public void ProjectConstructionDateIsInvalid() {
	
		this.expected.expect(IllegalArgumentException.class);
		Project project = new Project("Study",TaskPriority.HIGH,null);
	
		
	}
	
	
	@Test
	public void ProjectConstructionCostIsInvalid() {
	
		this.expected.expect(IllegalArgumentException.class);
		Project project = new Project("Study",TaskPriority.HIGH, LocalDate.of(2017, 12, 31),-3);
	
		
	}
	
	@Test
	public void ProjectConstructionDescriptionIsvalid() {
	
		
		Project project = new Project("Study");
		assertEquals("Study",project.getDescription());
		
		
		
	}
	
	
	@Test
	public void ProjectConstructionPriorityIsvalid() {
	
		
		Project project = new Project("Study",TaskPriority.HIGH);
		assertEquals(TaskPriority.HIGH,project.getPriority());
		
		
		
	}
	
	@Test
	public void ProjectConstructionDateIsvalid() {
	
		
		Project project = new Project("Study",TaskPriority.HIGH, LocalDate.of(2017, 12, 31));
		assertEquals(LocalDate.of(2017, 12, 31),project.getDate());
		
		
		
	}
	
	
	
	@Test
	public void ProjectConstructionDescriptionIsvalidd() {
	
		
		Project project = new Project("Study",TaskPriority.HIGH, LocalDate.of(2017, 12, 31),73);
		assertEquals(73,project.getCost());
		
		
		
	}
	
}
