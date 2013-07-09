package eu.maxschuster.vaadin.nanoscroller.client.nanoscrollerpanel;

public class NanoScrollerPanelState extends com.vaadin.shared.AbstractComponentState {

	private static final long serialVersionUID = -7379199327956074426L;
	
   /**
    * a setting to enable native scrolling in iOS devices.
    */
	public boolean iOSNativeScrolling = false;
	
   /**
    * a setting to prevent the rest of the page being
    * scrolled when user scrolls the `.content` element.
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
	

}