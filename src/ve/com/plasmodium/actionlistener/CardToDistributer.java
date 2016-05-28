package ve.com.plasmodium.actionlistener;

import javax.faces.component.UIComponent;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;

import org.apache.log4j.Logger;

public class CardToDistributer implements ActionListener {

	public static final Logger logger = Logger
			.getLogger(CardToDistributer.class);

	public void push(ActionEvent event) {

	}

	public void processAction(ActionEvent event)
			throws AbortProcessingException {
		System.out.println("<<<<entro en push processAction>>>>");
		// Coding of the processing executed at the time that
		// and associated button is clicked
		// the component that triggered the action event
		UIComponent component = event.getComponent();
		logger.debug("The id of the component that fired the action event: "
				+ component.getId());
		// the action command
		String eventSource = event.getSource().toString();
		logger.debug("Event Source: " + eventSource);

	}

}
