package edu.westga.cs1302.task_manager.model;

import java.util.ArrayList;

/**
 * Sort By Deadline
 * 
 * @author Ekue Kpodar
 * @Cs1302 Project
 */
public class DeadlineOrder extends TaskIterator {

	/**
	 * Create a Deadline iterator
	 * 
	 * @param tasks
	 *            The Collection of task
	 */
	public DeadlineOrder(ArrayList<Task> tasks) {
		super(tasks);

	}

	/*
	 * Return The Earliest Task On The Current List Then remove it from the list
	 * if several task have the same data then sort them by id (non-Javadoc)
	 * 
	 * @see java.util.Iterator#next()
	 */
	@Override
	public Task next() {
		Task atask = this.tasks.get(0);
		for (Task task : this.tasks) {
			if (task.getDate().isAfter(atask.getDate())) {
				atask = task;
			} else if (task.getDate().isEqual(atask.getDate())) {
				atask = this.samePriority(task, atask);
			}
		}

		Task send = atask;
		this.tasks.remove(atask);
		return send;
	}

	private Task samePriority(Task current, Task other) {
		if (current.getId() > other.getId()) {
			return current;
		} else if (current.getId() < other.getId()) {
			return other;
		} else {
			return current;
		}
	}

}
