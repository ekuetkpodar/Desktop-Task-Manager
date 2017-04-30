package edu.westga.cs1302.task_manager.model;

import java.util.Random;

/**
 * Create The Class For Tasks
 * 
 * @author Ekue Kpodar
 *
 */

public class Task {
	private String description;
	private int id;
	private boolean isCompleted;

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
			throw new IllegalArgumentException("description Cant be Null");
		}

		this.description = description;
		this.id = (new Random()).nextInt(Integer.MAX_VALUE) + 1;

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

}
