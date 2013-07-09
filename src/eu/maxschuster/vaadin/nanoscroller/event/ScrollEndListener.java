package eu.maxschuster.vaadin.nanoscroller.event;

import java.lang.reflect.Method;

import com.vaadin.util.ReflectTools;

public interface ScrollEndListener {

	public static final Method onScrollEndMethod =
			ReflectTools.findMethod(ScrollEndListener.class, "onScrollEnd", ScrollEndEvent.class);
	
	public void onScrollEnd(ScrollEndEvent event);
	
}
