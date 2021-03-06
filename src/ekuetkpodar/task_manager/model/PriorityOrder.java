package ekuetkpodar.task_manager.model;

import java.util.ArrayList;

/**
 * Sort List Base On Priority
 * 
 * @author Ekue Kpodar Cs Project
 */
public class PriorityOrder extends TaskIterator {

	/**
	 * Create a Sorted Task List Base On Priority
	 * 
	 * @pre tasks 1= null
	 * @param tasks
	 *            The Collection of Task
	 */
	public PriorityOrder(ArrayList<SimpleTask> tasks) {
		super(tasks);

	}

	/*
	 * Return The Highest priority Task On The Current List Then remove it from
	 * the list if several task have the same priority then sort them by id
	 * (non-Javadoc)
	 * 
	 * @see java.util.Iterator#next()
	 */
	@Override
	public SimpleTask next() {
		SimpleTask atask = this.tasks.get(0);
		for (SimpleTask task : this.tasks) {
			if (atask.getPriority().compareTo(task.getPriority()) == -1) {
				atask = atask;
			} else if (atask.getPriority().compareTo(task.getPriority()) == 1) {
				atask = task;
			} else if (atask.getPriority().compareTo(task.getPriority()) == 0) {
				atask = this.samePriority(atask, task);
			}
		}

		SimpleTask send = atask;
		this.tasks.remove(atask);
		return send;
	}

	private SimpleTask samePriority(SimpleTask current, SimpleTask other) {
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
