package edu.westga.cs1302.task_manager.model;

import java.time.LocalDate;
import java.util.Random;

/**
 * Create The Class For Tasks
 * 
 * @author Ekue Kpodar
 *
 */

public class Task implements Comparable<Task> {
	private static final String PRIORITY_IS_CANT_BE_NULL = "Priority is Cant Be Null";
	private static final String DATE_IS_INVALID = "date is Invalid";
	private static final String DESCRIPTION_NAME_IS_INVALID = "description name is Invalid";
	private String description;
	private int id;
	private boolean isCompleted;
	private TaskPriority priority;
	private LocalDate date;
	private int cost;

	/**
	 * Create a Tasks Object
	 * 
	 * @pre description != null
	 * @param description
	 *            The parameter
	 * 
	 *            a new Tasks is created
	 */

	public Task(String description) {
		if (description == null) {
			throw new IllegalArgumentException("description name");
		}

		this.description = description;
		this.id = (new Random()).nextInt(Integer.MAX_VALUE) + 1;

	}

	/**
	 * Create a Tasks Object
	 * 
	 * @pre description != null && priority !=null
	 * @param description
	 * 
	 *            The parameter
	 * @param priority
	 * 
	 *            a new Tasks is created
	 */

	public Task(String description, TaskPriority priority) {
		if (description == null) {
			throw new IllegalArgumentException(this.DESCRIPTION_NAME_IS_INVALID);
		}

		if (!priority.equals(TaskPriority.HIGH) && !priority.equals(TaskPriority.LOW)
				&& !priority.equals(TaskPriority.MEDIUM)) {
			throw new IllegalArgumentException("Priority is Invalid");
		}

		

		this.description = description;
		this.id = (new Random()).nextInt(Integer.MAX_VALUE) + 1;
		this.priority = priority;

	}

	/**
	 * Create a Tasks Object
	 * 
	 * @pre description != null && priority !=null & date !=null
	 * @param description
	 * 
	 *            The parameter
	 * @param priority
	 * 
	 * 
	 *            a new Tasks is created
	 * @param date
	 *            The date
	 */

	public Task(String description, TaskPriority priority, LocalDate date) {
		if (description == null) {
			throw new IllegalArgumentException(DESCRIPTION_NAME_IS_INVALID);
		}

		if (date == null) {
			throw new IllegalArgumentException(DATE_IS_INVALID);
		}

		if (!priority.equals(TaskPriority.HIGH) && !priority.equals(TaskPriority.LOW)
				&& !priority.equals(TaskPriority.MEDIUM)) {
			throw new IllegalArgumentException("Priority is Invalid");
		}

		this.description = description;
		this.id = (new Random()).nextInt(Integer.MAX_VALUE) + 1;
		this.priority = priority;
		this.date = date;

	}

	/**
	 * Create a Tasks Object
	 * 
	 * @pre description != null && priority !=null & date !=null cost > 0
	 * @param description
	 * 
	 *            The parameter
	 * @param priority
	 * 
	 * 
	 *            a new Tasks is created
	 * @param date
	 *            The date
	 * 
	 * @param cost
	 *            The cost
	 */

	public Task(String description, TaskPriority priority, LocalDate date, int cost) {
		if (description == null) {
			throw new IllegalArgumentException(DESCRIPTION_NAME_IS_INVALID);
		}

		if (date == null) {
			throw new IllegalArgumentException(DATE_IS_INVALID);
		}

		if (!priority.equals(TaskPriority.HIGH) && !priority.equals(TaskPriority.LOW)
				&& !priority.equals(TaskPriority.MEDIUM)) {
			throw new IllegalArgumentException("Priority is Invalid");
		}
		
		if (cost <= 0) {
			throw new IllegalArgumentException("The Cost Cant Be Less Then 0");
		}

		this.description = description;
		this.id = (new Random()).nextInt(Integer.MAX_VALUE) + 1;
		this.priority = priority;
		this.date = date;
		this.cost = cost;

	}

	/**
	 * Get The Tasks Description
	 * 
	 * @return the description
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * Get The Id
	 * 
	 * @return the id
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * return true if the task has been perform else return false
	 * 
	 * @return the isCompleted
	 */
	public boolean isCompleted() {
		return this.isCompleted;
	}

	/**
	 * Set The Task Completion Status
	 * 
	 * @param isCompleted
	 *            the isCompleted to set
	 */
	public void setCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}

	/**
	 * Get Priority
	 * 
	 * @return the priority
	 */
	public TaskPriority getPriority() {
		return this.priority;
	}

	/**
	 * Set Priority
	 * 
	 * @param priority
	 *            the priority to set
	 */
	public void setPriority(TaskPriority priority) {
		this.priority = priority;
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
	 * Set The Date
	 * 
	 * @param date
	 *            the date to set
	 */
	public void setDate(LocalDate date) {
		this.date = date;
	}

	/**
	 * Compare Task Base On ID
	 * 
	 * @param other
	 *            The object being compared
	 * @return
	 */

	@Override
	public int compareTo(Task other) {
		if (this.getId() > other.getId()) {
			return 1;
		}
		if (this.getId() < other.getId()) {
			return -1;
		}
		return 0;
	}

	/**
	 * Get Cost
	 * 
	 * @return the cost
	 */
	public int getCost() {
		return this.cost;
	}

	/**
	 * Set Cost
	 * 
	 * @param cost
	 *            the cost to set
	 */
	public void setCost(int cost) {
		this.cost = cost;
	}

}
