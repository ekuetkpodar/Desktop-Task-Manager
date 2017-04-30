package edu.westga.cs1302.task_manager.model;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Class For Project
 * 
 * @author Ekue Kpodar
 *
 */
public class Project extends Task {
	private static final String DESCRIPTION_IS_INVALID = "description is Invalid";
	private static final String PRIORITY_IS_INVALID = "Priority is Invalid";
	private static final String PRIORITY_IS_CANT_BE_NULL = "Priority is Cant Be Null";
	private static final String DATE_IS_INVALID = "date is Invalid";
	private static final String DESCRIPTION_NAME_IS_INVALID = "description name is Invalid";
	private ArrayList<Task> collection;
	private TaskPriority priority;
	private LocalDate date;
	private int cost;

	/**
	 * Create a new Project
	 * 
	 * @pre description != null
	 * @param description
	 *            the description
	 */
	public Project(String description) {

		super(description);
		if (description == null) {
			throw new IllegalArgumentException(this.DESCRIPTION_IS_INVALID);
		}
		this.collection = new ArrayList<Task>();
	}

	/**
	 * Create a new Project With Piority
	 * 
	 * @pre description != null priority != null
	 * @param description
	 * 
	 *            the description
	 * @param priority
	 *            The priority
	 */
	public Project(String description, TaskPriority priority) {

		super(description);
		if (description == null) {
			throw new IllegalArgumentException(this.DESCRIPTION_IS_INVALID);
		}

		if (!priority.equals(TaskPriority.HIGH) && !priority.equals(TaskPriority.LOW)
				&& !priority.equals(TaskPriority.MEDIUM)) {
			throw new IllegalArgumentException(this.PRIORITY_IS_INVALID);
		}

		this.collection = new ArrayList<Task>();
		this.priority = priority;
	}

	/**
	 * Create a new Project With Piority
	 * 
	 * @pre description != null priority != null && date != null
	 * @param description
	 * 
	 *            the description
	 * @param priority
	 *            The priority
	 * @param date
	 *            The date
	 */
	public Project(String description, TaskPriority priority, LocalDate date) {

		super(description);
		if (!priority.equals(TaskPriority.HIGH) && !priority.equals(TaskPriority.LOW)
				&& !priority.equals(TaskPriority.MEDIUM)) {
			throw new IllegalArgumentException(this.PRIORITY_IS_INVALID);
		}

		if (date == null) {
			throw new IllegalArgumentException(DATE_IS_INVALID);
		}

		this.collection = new ArrayList<Task>();
		this.priority = priority;
		this.date = date;
	}

	/**
	 * Create a new Project With Piority
	 * 
	 * @pre description != null priority != null && date != null
	 * @param description
	 * 
	 *            the description
	 * @param priority
	 *            The priority
	 * @param date
	 *            the date
	 * @param cost
	 *            the cost
	 * 
	 */
	public Project(String description, TaskPriority priority, LocalDate date, int cost) {

		super(description);
		if (!priority.equals(TaskPriority.HIGH) && !priority.equals(TaskPriority.LOW)
				&& !priority.equals(TaskPriority.MEDIUM)) {
			throw new IllegalArgumentException(this.PRIORITY_IS_INVALID);
		}

		if (date == null) {
			throw new IllegalArgumentException(DATE_IS_INVALID);
		}

		if (cost <= 0) {
			throw new IllegalArgumentException("The Cost Cant Be Less Then 0");
		}
		this.collection = new ArrayList<Task>();
		this.priority = priority;
		this.date = date;
		this.cost = cost;
	}

	/**
	 * Get A Task By Id
	 * 
	 * @pre id > 0
	 * @param id
	 *            The Task Id
	 * @return The Task
	 */
	public SimpleTask getSimpleTask(int id) {

		if (id <= 0) {
			throw new IllegalArgumentException("ID Cant Be Less Than Zero");
		}

		for (Task current : this.collection) {
			if (current.getId() == id) {
				return (SimpleTask) current;
			}
		}
		return null;
	}

	/**
	 * Add a Task To Collecttion
	 * 
	 * @pre atask != null
	 * @param atask
	 *            the task
	 * 
	 */
	public void addTask(Task atask) {
		if (atask == null) {
			throw new IllegalArgumentException("atask cant be name");
		}
		this.collection.add(atask);
	}

	@Override
	public SimpleTask getSimpleTask() {

		return null;
	}

	/**
	 * Get The Date
	 * 
	 * @return the date
	 */
	public LocalDate getDate() {
		return this.date;
	}

	/**
	 * Get The Total cost for a Porject
	 * 
	 * @return the cost
	 */
	public int getCost() {
		int total = 0;

		for (Task current : this.collection) {
			if (current.getClass().equals(SimpleTask.class)) {
				total += ((SimpleTask) current).getCost();
			} else {
				total += ((Project) current).getCost();
			}
		}

		return this.cost + total;
	}

	/**
	 * Get The Priority
	 * 
	 * @return the priority
	 */
	public TaskPriority getPriority() {
		return this.priority;
	}

}
