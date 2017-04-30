package edu.westga.cs1302.task_manager.test.Project;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

import edu.westga.cs1302.task_manager.model.Project;
import edu.westga.cs1302.task_manager.model.SimpleTask;
import edu.westga.cs1302.task_manager.model.TaskPriority;

public class TestGetCost {

	@Test
	public void TestGetCostCollectionIsEmpty() {
		Project project = new Project("Study", TaskPriority.HIGH, LocalDate.of(2017, 12, 31), 100);

		assertEquals(100, project.getCost());

	}

	@Test
	public void TestGetCostWithOneTask() {
		Project project = new Project("Study", TaskPriority.HIGH, LocalDate.of(2017, 12, 31), 100);
		SimpleTask school = new SimpleTask("work", TaskPriority.HIGH, LocalDate.of(2017, 12, 31), 100);
		project.addTask(school);
		assertEquals(200, project.getCost());

	}

	@Test
	public void TestGetCostWithTwoTask() {
		Project project = new Project("Study", TaskPriority.HIGH, LocalDate.of(2017, 12, 31), 100);
		SimpleTask school = new SimpleTask("work", TaskPriority.HIGH, LocalDate.of(2017, 12, 31), 100);
		SimpleTask school1 = new SimpleTask("work", TaskPriority.HIGH, LocalDate.of(2017, 12, 31), 200);
		project.addTask(school);
		project.addTask(school1);
		assertEquals(400, project.getCost());

	}

	@Test
	public void TestGetCostWithThreeTask() {
		Project project = new Project("Study", TaskPriority.HIGH, LocalDate.of(2017, 12, 31), 100);
		SimpleTask school = new SimpleTask("work", TaskPriority.HIGH, LocalDate.of(2017, 12, 31), 100);
		SimpleTask school1 = new SimpleTask("work", TaskPriority.HIGH, LocalDate.of(2017, 12, 31), 200);
		SimpleTask school2 = new SimpleTask("work", TaskPriority.HIGH, LocalDate.of(2017, 12, 31), 200);
		project.addTask(school);
		project.addTask(school1);
		project.addTask(school2);
		assertEquals(600, project.getCost());

	}

	@Test
	public void TestGetCostWithTwoProjectandTask() {
		Project project = new Project("Study", TaskPriority.HIGH, LocalDate.of(2017, 12, 31), 100);
		SimpleTask school = new SimpleTask("work", TaskPriority.HIGH, LocalDate.of(2017, 12, 31), 100);
		SimpleTask school1 = new SimpleTask("work", TaskPriority.HIGH, LocalDate.of(2017, 12, 31), 200);
		Project project1 = new Project("Study", TaskPriority.HIGH, LocalDate.of(2017, 12, 31), 300);

		project.addTask(school);
		project.addTask(school1);
		project.addTask(project1);

		assertEquals(700, project.getCost());

	}
}
