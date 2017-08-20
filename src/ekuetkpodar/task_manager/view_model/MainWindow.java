package ekuetkpodar.task_manager.view_model;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

import ekuetkpodar.task_manager.model.Agenda;
import ekuetkpodar.task_manager.model.CostOrder;
import ekuetkpodar.task_manager.model.DeadlineOrder;
import ekuetkpodar.task_manager.model.PriorityOrder;
import ekuetkpodar.task_manager.model.Serializer;
import ekuetkpodar.task_manager.model.SimpleTask;
import ekuetkpodar.task_manager.model.TaskIterator;
import ekuetkpodar.task_manager.model.TaskPriority;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;

/**
 * Maps Model behavior to the MainWindow view.
 *
 * @author Ekue Kpodar
 * @version Spring2017
 */
public class MainWindow {
	@FXML
	private ResourceBundle resources;
	@FXML
	private URL location;
	@FXML
	private ComboBox priority;
	@FXML
	private TextField cost;
	@FXML
	private Button addTask;
	@FXML
	private TextArea description;
	@FXML
	private TextArea output;
	@FXML
	private ComboBox order;
	@FXML
	private CheckBox complete;

	@FXML
	private DatePicker deadline;

	private SimpleTask currentTask;
	private Agenda agenda;
	private Serializer serializer;
	private TaskIterator taskIterator;
	private TaskPriority currentpriority;
	private LocalDate date;
	private int currentcost;
	private String orderType;

	/**
	 * Add a New Task To The List of Task And Print the TaskDescription
	 * 
	 * @param event
	 *            The event
	 */
	@FXML
	public void onAddTaskClick(ActionEvent event) {
		this.currentTask = new SimpleTask(this.description.getText());
		if (this.priority.getSelectionModel().getSelectedItem() != null) {
			this.getPriorityValue();
			this.currentTask = new SimpleTask(this.description.getText(), this.currentpriority);
		}
		this.dateValidation();
		if (this.priority.getSelectionModel().getSelectedItem() != null && this.date != null
				&& !this.date.isBefore(LocalDate.now())) {
			this.getPriorityValue();
			this.currentTask = new SimpleTask(this.description.getText(), this.currentpriority, this.date);
		}
		String costof = null;
		if (!this.cost.getText().isEmpty()) {
			costof = this.cost.getText();
			this.costValidation(costof);
		}

		if (this.priority.getSelectionModel().getSelectedItem() != null && this.date != null
				&& !this.date.isBefore(LocalDate.now()) && this.currentcost > 0) {
			this.getPriorityValue();
			this.currentTask = new SimpleTask(this.description.getText(), this.currentpriority, this.date, this.currentcost);
		}

		this.agenda.addTask(this.currentTask);
		this.serializer.serializeAColletion(this.agenda.getAllTask());
		this.output.setText(this.serializer.serializeAColletion(this.agenda.getAllTask()));

		this.dateValidation();
		if (!this.costValidation(costof).equals("parsebale")) {
			this.output.setText(this.costValidation(costof));
		}

	}

	private String costValidation(String cost) {
		String costError = "";
		try {
			this.currentcost = Integer.parseInt(cost);
			return "parsebale";
		} catch (NumberFormatException e) {

		}

		if (this.currentcost <= 0 && !this.cost.getText().isEmpty()) {
			return "The Cost Must be a Number reater Than Zero";
		}
		return "cost Must Be A Number";
	}

	private void dateValidation() {
		if (this.deadline.getValue() != null) {
			this.date = this.deadline.getValue();
		}

		if (this.date.isBefore(LocalDate.now())) {
			this.output.setText("The Selected Date Is Invalid");
		}
	}

	private void getPriorityValue() {

		if (this.priority.getSelectionModel().getSelectedIndex() == 0) {
			this.currentpriority = TaskPriority.HIGH;
		} else if (this.priority.getSelectionModel().getSelectedIndex() == 1) {
			this.currentpriority = TaskPriority.MEDIUM;
		} else if (this.priority.getSelectionModel().getSelectedIndex() == 2) {
			this.currentpriority = TaskPriority.LOW;
		}
	}

	private void getTaskOrderValue() {
		if (this.order.getSelectionModel().getSelectedIndex() == 0) {
			this.orderType = "Priority";
		} else if (this.order.getSelectionModel().getSelectedIndex() == 1) {
			this.orderType = "DeadLine";
		} else if (this.order.getSelectionModel().getSelectedIndex() == 2) {
			this.orderType = "Cost";
		}
	}

	/**
	 * Sort The Task Base On The Value
	 * 
	 * @param event
	 *            Choice selected
	 */
	@FXML
	public void taskOrder(ActionEvent event) {
		ArrayList<SimpleTask> newTask = new ArrayList<SimpleTask>();
		if (this.order.getSelectionModel().getSelectedIndex() == 0) {
			this.taskIterator = new PriorityOrder(this.agenda.getAllTask());
			while (this.taskIterator.hasNext()) {
				newTask.add(this.taskIterator.next());
				this.output.setText(this.serializer.serializeAColletion(newTask));
			}
		} else if (this.order.getSelectionModel().getSelectedIndex() == 1) {
			this.taskIterator = new DeadlineOrder(this.agenda.getAllTask());
			while (this.taskIterator.hasNext()) {
				newTask.add(this.taskIterator.next());
				this.output.setText(this.serializer.serializeAColletion(newTask));
			}
		} else if (this.order.getSelectionModel().getSelectedIndex() == 2) {
			this.taskIterator = new CostOrder(this.agenda.getAllTask());
			while (this.taskIterator.hasNext()) {
				newTask.add(this.taskIterator.next());
				this.output.setText(this.serializer.serializeAColletion(newTask));
			}
		}

	}

	@SuppressWarnings("unchecked")
	@FXML
	void initialize() {
		assert this.description != null : "fx:id=\"name\" was not injected: check your FXML file 'sample.fxml'.";
		assert this.output != null : "fx:id=\"id\" was not injected: check your FXML file 'sample.fxml'.";
		assert this.addTask != null : "fx:id=\"button\" was not injected: check your FXML file 'sample.fxml'.";
		assert this.priority != null : "fx:id=\"priority\" was not injected: check your FXML file 'sample.fxml'.";
		assert this.order != null : "fx:id=\"order\" was not injected: check your FXML file 'sample.fxml'.";
		this.priority.getItems().add(TaskPriority.HIGH);
		this.priority.getItems().add(TaskPriority.MEDIUM);
		this.priority.getItems().add(TaskPriority.LOW);

		this.order.getItems().add("Priority");
		this.order.getItems().add("DeadLine");
		this.order.getItems().add("Cost");

		this.currentTask = new SimpleTask("task");

		ArrayList<SimpleTask> itr = new ArrayList<SimpleTask>();

		this.agenda = new Agenda(new PriorityOrder(itr));
		this.serializer = new Serializer();
		this.taskIterator = new PriorityOrder(itr);

	}

}