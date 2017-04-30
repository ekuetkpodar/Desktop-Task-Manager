package edu.westga.cs1302.task_manager.model;

import java.util.ArrayList;

/**
 * Class for Serializing
 * 
 * @author Ekue Kpodar
 * @Cs1302
 */
public class Serializer {

	private static final String STRING = "\t";

	/**
	 * Format a Single Task on description follow by id follow by priority if it
	 * exist, follow by date if it exist follow by cost if it exist
	 * 
	 * @pre Task != NULL
	 * @param task
	 *            the task
	 * @return The Internal information stored in a task
	 */
	public String serializeATask(Task task) {
		if (task == null) {
			throw new IllegalArgumentException("Task Can't Be Null");
		}

		String output = task.getDescription() + STRING;
		output += task.getId() + STRING;
		if (task.getPriority() != null) {
			output += task.getPriority() + STRING;
		}

		if (task.getDate() != null) {
			output += task.getDate() + STRING;
		}

		if (task.getCost() >= 1) {
			output += task.getCost() + STRING;
		}

		return output;

	}

	/**
	 * Serialize Task Base on The Chronological
	 * 
	 * @pre task != null
	 * @param task
	 *            the collection of task
	 * @return The String format of every task within the Given Collection
	 */
	public String serializeAColletion(ArrayList<Task> task) {
		if (task == null) {
			throw new IllegalArgumentException("Tasks Can't Be Null");
		}

		String output = "*************Task Beginning*************" + "\n";

		for (Task current : task) {
			output += this.serializeATask(current) + "\n";
		}

		output += "*************Task       End*************";

		return output;

	}

}