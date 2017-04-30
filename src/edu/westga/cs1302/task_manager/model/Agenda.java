package edu.westga.cs1302.task_manager.model;

import java.util.ArrayList;

/**
 * Create a Collection of Tasks
 * 
 * @author Ekue Kpodar
 *
 */
public class Agenda {
	private ArrayList<Task> tasks;

	/**
	 * Create a Default Agenda
	 * 
	 */
	public Agenda() {
		this.tasks = new ArrayList<Task>();
	}

	/**
	 * Get and Return a Tasks object base one a given Id if it exist else return
	 * null
	 * 
	 * @@pre none
	 * @post a tasks is return if it exist
	 * @param id
	 *            The Id
	 * @return The Task Object
	 */
	public Task getTask(int id) {
		if (id <= 0) {
			throw new IllegalArgumentException("The Id is invalid");
		}

		for (Task current : this.tasks) {
			if (current.getId() == id) {
				return current;
			}
		}

		return null;

	}

	/**
	 * Add a New Task To The List Of Task
	 * 
	 * @pre newTask != null
	 * @post this.tasks.size()+1
	 * @param newTask
	 *            The task
	 * 
	 */
	public void addTask(Task newTask) {
		if (newTask == null) {
			throw new IllegalArgumentException("The Task Is Invalid");
		}

		this.tasks.add(newTask);
	}

	/**
	 * Get All The Tasks On The Agenda
	 * 
	 * @return All the Agenda
	 */
	public ArrayList<Task> getAllTask() {
		return this.tasks;
	}

	/**
	 * Get A List Of Task That Are Not Complete If There is still Task That
	 * should be perform else return null;
	 * 
	 * @return Get The List of Task Still need To be Preformed
	 */
	public ArrayList<Task> incompleteTasks() {
		ArrayList<Task> taskIn = new ArrayList<Task>();
		for (Task current : this.tasks) {
			if (!current.isCompleted()) {
				taskIn.add(current);
			}
		}

		if (taskIn.isEmpty()) {
			return null;
		} else {
			return taskIn;
		}
	}
}