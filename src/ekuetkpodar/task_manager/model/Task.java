package ekuetkpodar.task_manager.model;

import java.util.Random;

/**
 * Task abstract class
 * 
 * @author Ekue Kpodar
 *
 */
public abstract class Task {
	private String description;
	private int id;

	/**Get a Simple Task
	 * 
	 * @return 
	 * the simpletask object
	 */
	public abstract SimpleTask getSimpleTask();

	/**
	 * Create a new Task
	 * 
	 * @param description
	 *            The Task Description
	 */
	public Task(String description) {
		this.description = description;
		this.id = (new Random()).nextInt(Integer.MAX_VALUE) + 1;
	}

	/**
	 * Get The Description
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

}
