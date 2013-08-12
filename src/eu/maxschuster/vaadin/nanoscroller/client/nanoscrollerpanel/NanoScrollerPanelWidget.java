package eu.maxschuster.vaadin.nanoscroller.client.nanoscrollerpanel;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.json.client.JSONBoolean;
import com.google.gwt.json.client.JSONNull;
import com.google.gwt.json.client.JSONNumber;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.SimplePanel;

public class NanoScrollerPanelWidget extends SimplePanel {
	
	public interface NanoScrollerPanelWidgetListener {
		public void scrollTop();
		public void scrollEnd();
	}

	public static final String CLASSNAME = "v-nanoscrollerpanel";

	private final Element contentNode = DOM.createDiv();

	/**
	 * a classname for the pane element.
	 */
	public String paneClass = "pane";

	/**
	 * a classname for the slider element.
	 */
	public String sliderClass = "slider";

	/**
	 * a classname for the content element.
	 */
	public String contentClass = "content";

	/**
	 * a setting to enable native scrolling in iOS devices.
	 */
	public boolean iOSNativeScrolling = false;

	/**
	 * a setting to prevent the rest of the page being scrolled when user
	 * scrolls the `.content` element.
	 */
	public boolean preventPageScrolling = false;

	/**
	 * a setting to disable binding to the resize event.
	 */
	public boolean disableResize = false;

	/**
	 * a setting to make the scrollbar always visible.
	 */
	public boolean alwaysVisible = false;

	/**
	 * a default timeout for the `flash()` method.
	 */
	public int flashDelay = 1500;

	/**
	 * a minimum height for the `.slider` element.
	 */
	public int sliderMinHeight = 20;

	/**
	 * a maximum height for the `.slider` element.
	 */
	public Integer sliderMaxHeight = null;
	
	public int debounceTime = 100;
	
	public NanoScrollerPanelWidgetListener listener = null;

	public NanoScrollerPanelWidget() {
		
		checkRrequirements(); 
		
		setStyleName(CLASSNAME);

		contentNode.setClassName(CLASSNAME + "-content");

		getElement().appendChild(contentNode);

		refresh();
	}

	private JavaScriptObject getOptions() {
		JSONObject options = new JSONObject();
		
		options.put("alwaysVisible", JSONBoolean.getInstance(alwaysVisible));
		options.put("contentClass", new JSONString(NanoScrollerPanelWidget.CLASSNAME + "-content"));
		options.put("disableResize", JSONBoolean.getInstance(disableResize));
		options.put("flashDelay", new JSONNumber(Double.valueOf(flashDelay)));
		options.put("iOSNativeScrolling", JSONBoolean.getInstance(iOSNativeScrolling));
		options.put("paneClass", new JSONString(NanoScrollerPanelWidget.CLASSNAME + "-pane"));
		options.put("preventPageScrolling", JSONBoolean.getInstance(preventPageScrolling));
		options.put("sliderClass", new JSONString(NanoScrollerPanelWidget.CLASSNAME + "-slider"));
		options.put("sliderMaxHeight", (sliderMaxHeight != null) ? new JSONNumber(Double.valueOf(sliderMaxHeight)) : JSONNull.getInstance());
		options.put("sliderMinHeight", new JSONNumber(Double.valueOf(sliderMinHeight)));
    	
		return options.getJavaScriptObject();
	}

	public void refresh() {
		attachScroller(this, getElement(), contentNode, getOptions(), debounceTime);
	}
	
	private static native void checkRrequirements() /*-{
		if (typeof $wnd.jQuery != 'function') {
			throw new Error("NanoScrollerPanel requires jQuery to be loaded on page load!");
		}
		if (typeof $wnd.jQuery.fn.nanoScroller != 'function') {
			throw new Error("The jQuery.nanoScroller plugin has not been loaded!");
		}
		if (typeof $wnd.jQuery.fn.debounce != 'function') {
			throw new Error("The jQuery.debounce plugin has not been loaded!");
		}
	}-*/;

	// TODO Fix native scrolling
	private native void attachScroller(NanoScrollerPanelWidget self, Element container, Element content,
			JavaScriptObject options, int debounceTime)/*-{
			var $container = $wnd.jQuery(container);
			$wnd.jQuery(container).nanoScroller(options).off('scrollend scrolltop');
			$container.debounce('scrollend',function() {
				self.@eu.maxschuster.vaadin.nanoscroller.client.nanoscrollerpanel.NanoScrollerPanelWidget::scrollEnd()();
			}, debounceTime);
			$container.debounce('scrolltop', function() {
				self.@eu.maxschuster.vaadin.nanoscroller.client.nanoscrollerpanel.NanoScrollerPanelWidget::scrollTop()();
			}, debounceTime);
	}-*/;
	
	public void scrollTop() {
		if (listener != null) listener.scrollTop();
	}
	
	public void scrollEnd() {
		if (listener != null) listener.scrollEnd();
	}

	@Override
	protected Element getContainerElement() {
		return contentNode;
	}

	public boolean isiOSNativeScrolling() {
		return iOSNativeScrolling;
	}

	public void setiOSNativeScrolling(boolean iOSNativeScrolling) {
		this.iOSNativeScrolling = iOSNativeScrolling;
	}

	public boolean isPreventPageScrolling() {
		return preventPageScrolling;
	}

	public void setPreventPageScrolling(boolean preventPageScrolling) {
		this.preventPageScrolling = preventPageScrolling;
	}

	public boolean isDisableResize() {
		return disableResize;
	}

	public void setDisableResize(boolean disableResize) {
		this.disableResize = disableResize;
	}

	public boolean isAlwaysVisible() {
		return alwaysVisible;
	}

	public void setAlwaysVisible(boolean alwaysVisible) {
		this.alwaysVisible = alwaysVisible;
	}

	public int getFlashDelay() {
		return flashDelay;
	}

	public void setFlashDelay(int flashDelay) {
		this.flashDelay = flashDelay;
	}

	public int getSliderMinHeight() {
		return sliderMinHeight;
	}

	public void setSliderMinHeight(int sliderMinHeight) {
		this.sliderMinHeight = sliderMinHeight;
	}

	public Integer getSliderMaxHeight() {
		return sliderMaxHeight;
	}

	public void setSliderMaxHeight(Integer sliderMaxHeight) {
		this.sliderMaxHeight = sliderMaxHeight;
	}

	public int getDebounceTime() {
		return debounceTime;
	}

	public void setDebounceTime(int debounceTime) {
		this.debounceTime = debounceTime;
	}

}