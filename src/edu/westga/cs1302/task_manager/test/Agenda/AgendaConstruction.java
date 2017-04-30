package edu.westga.cs1302.task_manager.test.Agenda;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import edu.westga.cs1302.task_manager.model.Agenda;
import edu.westga.cs1302.task_manager.model.PriorityOrder;
import edu.westga.cs1302.task_manager.model.Task;

public class AgendaConstruction {

	@Rule public ExpectedException expected = ExpectedException.none();

	@Test
	public void AgendaIsInvalid() {
	
		ArrayList<Task> itr = new ArrayList<Task>();
	
		this.expected.expect(IllegalArgumentException.class);
		Agenda agenda = new Agenda(null);
		
		
		
	}
	
	@Test
	public void AgendaIsValid() {
	
		ArrayList<Task> itr = new ArrayList<Task>();
		Agenda agenda = new Agenda(new PriorityOrder(itr));
		
		assertTrue(agenda != null);
		
		
		
	}

}
