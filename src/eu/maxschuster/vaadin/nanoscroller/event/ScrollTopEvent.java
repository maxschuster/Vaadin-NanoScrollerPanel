package eu.maxschuster.vaadin.nanoscroller.event;

import com.vaadin.ui.Component;
import com.vaadin.ui.Component.Event;

@SuppressWarnings("serial")
public class ScrollTopEvent extends Event {

	public static final String EVENT_ID = "nanoscroller-scroll-top";
	
	public ScrollTopEvent(Component component) {
		super(component);
	}

}
