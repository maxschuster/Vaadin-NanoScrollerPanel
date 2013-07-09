package eu.maxschuster.vaadin.nanoscroller.event;

import java.lang.reflect.Method;

import com.vaadin.util.ReflectTools;

public interface ScrollTopListener {

	public static final Method onScrollTopMethod =
			ReflectTools.findMethod(ScrollTopListener.class, "onScrollTop", ScrollTopEvent.class);
	
	public void onScrollTop(ScrollTopEvent event);
	
}
