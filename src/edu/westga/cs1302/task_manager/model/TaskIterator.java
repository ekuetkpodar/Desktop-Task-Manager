package edu.westga.cs1302.task_manager.model;

import java.util.ArrayList;
import java.util.Iterator;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Default Design For The Sorting Classes
 * 
 * @author Ekue Kpodar
 *
 */
public abstract class TaskIterator implements Iterator<SimpleTask> {
	protected ArrayList<SimpleTask> tasks;
	protected int index;

	/**
	 * Creates a New Task Iterator
	 * 
	 * @param tasks
	 *            Collection of Task
	 */
	public TaskIterator(ArrayList<SimpleTask> tasks) {
		this.tasks = new ArrayList<SimpleTask>();
		this.tasks.addAll(tasks);
		this.index = 0;
	}

	@Override
	public boolean hasNext() {

		return this.index < this.tasks.size();

	}

	/**Set The Tasks
	 * @param tasks the tasks to set
	 */
	public void setTasks(ArrayList<SimpleTask> tasks) {
		this.tasks.clear();
		this.tasks.addAll(tasks);
	}
	
	

}
