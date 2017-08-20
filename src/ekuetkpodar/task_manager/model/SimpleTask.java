package ekuetkpodar.task_manager.model;

import java.time.LocalDate;
import java.util.Random;

import java.time.LocalDate;
import java.util.Random;

/**
 * Create The Class For Tasks
 * 
 * @author Ekue Kpodar
 *
 */

public class SimpleTask extends Task implements Comparable<SimpleTask> {
	private static final String DESCRIPTION_IS_INVALID = "Description Is Invalid";
	private static final String PRIORITY_IS_INVALID = "Priority is Invalid";
	private static final String PRIORITY_IS_CANT_BE_NULL = "Priority is Cant Be Null";
	private static final String DATE_IS_INVALID = "date is Invalid";
	private static final String DESCRIPTION_NAME_IS_INVALID = "description name is Invalid";
	private boolean isCompleted;
	private TaskPriority priority;
	private LocalDate date;
	protected int cost;

	/**
	 * Create a Tasks Object
	 * 
	 * @pre description != null
	 * @param description
	 *            The parameter
	 * 
	 *            a new Tasks is created
	 */

	public SimpleTask(String description) {
		super(description);
		if (description == null) {
			throw new IllegalArgumentException("description name");
		}

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

	public SimpleTask(String description, TaskPriority priority) {
		super(description);
		if (description == null) {
			throw new IllegalArgumentException(this.DESCRIPTION_IS_INVALID);

		}

		if (!priority.equals(TaskPriority.HIGH) && !priority.equals(TaskPriority.LOW)
				&& !priority.equals(TaskPriority.MEDIUM)) {
			throw new IllegalArgumentException(this.PRIORITY_IS_INVALID);
		}

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

	public SimpleTask(String description, TaskPriority priority, LocalDate date) {
		super(description);
		if (description == null) {
			throw new IllegalArgumentException(DESCRIPTION_IS_INVALID);

		}

		if (!priority.equals(TaskPriority.HIGH) && !priority.equals(TaskPriority.LOW)
				&& !priority.equals(TaskPriority.MEDIUM)) {
			throw new IllegalArgumentException(this.PRIORITY_IS_INVALID);
		}

		if (date == null) {
			throw new IllegalArgumentException(this.DATE_IS_INVALID);
		}

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

	public SimpleTask(String description, TaskPriority priority, LocalDate date, int cost) {
		super(description);

		if (!priority.equals(TaskPriority.HIGH) && !priority.equals(TaskPriority.LOW)
				&& !priority.equals(TaskPriority.MEDIUM)) {
			throw new IllegalArgumentException(this.PRIORITY_IS_INVALID);
		}

		if (date == null) {
			throw new IllegalArgumentException(DATE_IS_INVALID);
		}

		if (cost <= 0) {
			throw new IllegalArgumentException("The Cost Cant Be Less Then 0");
		}

		this.priority = priority;
		this.date = date;
		this.cost = cost;

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
	public int compareTo(SimpleTask other) {
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

	@Override
	public SimpleTask getSimpleTask() {

		return null;
	}

}
