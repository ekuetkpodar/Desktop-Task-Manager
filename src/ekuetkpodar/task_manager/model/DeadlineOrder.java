package ekuetkpodar.task_manager.model;

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
	public DeadlineOrder(ArrayList<SimpleTask> tasks) {
		super(tasks);

	}

	/*
	 * Return The Earliest Task On The Current List Then remove it from the list
	 * if several task have the same data then sort them by id (non-Javadoc)
	 * 
	 * @see java.util.Iterator#next()
	 */
	@Override
	public SimpleTask next() {
		SimpleTask atask = this.tasks.get(0);
		for (SimpleTask task : this.tasks) {
			if (task.getDate().isAfter(atask.getDate())) {
				atask = task;
			} else if (task.getDate().isEqual(atask.getDate())) {
				atask = this.samePriority(task, atask);
			}
		}

		SimpleTask send = atask;
		this.tasks.remove(atask);
		return send;
	}

	private SimpleTask samePriority(SimpleTask current, SimpleTask other) {
		if (current.getId() > other.getId()) {
			return current;
		} else if (current.getId() < other.getId()) {
			return other;
		} else {
			return current;
		}
	}

}
