package edu.westga.cs1302.task_manager.model;

import java.util.ArrayList;

/**
 * Sort The Order By Cost
 * 
 * @author Ekue Kpodar
 *
 */
public class CostOrder extends TaskIterator {
	/**
	 * Create a CostSort
	 * 
	 * @param tasks
	 *            The Collection of Task
	 */
	public CostOrder(ArrayList<Task> tasks) {
		super(tasks);

	}

	/*
	 * Return The Highest cost Task On The Current List Then remove it from the
	 * list if several task have the same cost then sort them by id
	 * (non-Javadoc)
	 * 
	 * @see java.util.Iterator#next()
	 */
	@Override
	public Task next() {
		Task atask = this.tasks.get(0);
		for (Task task : this.tasks) {
			if (task.getCost() > atask.getCost()) {
				atask = task;
			} else if (task.getCost() == atask.getCost()) {
				atask = this.samePriority(atask, task);
			}
		}

		Task send = atask;
		this.tasks.remove(atask);
		return send;

	}

	private Task samePriority(Task current, Task other) {
		if (current.compareTo(other) == 1) {
			return other;
		} else if (current.compareTo(other) == -1) {
			return current;
		} else if (current.compareTo(other) == 0) {
			return current;
		} else {
			return current;
		}
	}

}
