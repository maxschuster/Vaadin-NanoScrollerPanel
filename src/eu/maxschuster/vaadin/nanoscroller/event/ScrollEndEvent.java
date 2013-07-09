package eu.maxschuster.vaadin.nanoscroller.event;

import com.vaadin.ui.Component;
import com.vaadin.ui.Component.Event;

@SuppressWarnings("serial")
public class ScrollEndEvent extends Event {
	
	public static final String EVENT_ID = "nanoscroller-scroll-end";

	public ScrollEndEvent(Component component) {
		super(component);
	}

}
