package ekuetkpodar.task_manager.test.Agenda;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import ekuetkpodar.task_manager.model.Agenda;
import ekuetkpodar.task_manager.model.PriorityOrder;
import ekuetkpodar.task_manager.model.SimpleTask;

public class AgendaConstruction {

	@Rule public ExpectedException expected = ExpectedException.none();

	@Test
	public void AgendaIsInvalid() {
	
		ArrayList<SimpleTask> itr = new ArrayList<SimpleTask>();
	
		this.expected.expect(IllegalArgumentException.class);
		Agenda agenda = new Agenda(null);
		
		
		
	}
	
	@Test
	public void AgendaIsValid() {
	
		ArrayList<SimpleTask> itr = new ArrayList<SimpleTask>();
		Agenda agenda = new Agenda(new PriorityOrder(itr));
		
		assertTrue(agenda != null);
		
		
		
	}

}
