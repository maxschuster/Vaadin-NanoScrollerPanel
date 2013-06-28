package eu.maxschuster.vaadin.nanoscroller;

import com.vaadin.annotations.JavaScript;
import com.vaadin.annotations.StyleSheet;
import com.vaadin.ui.AbstractSingleComponentContainer;

import eu.maxschuster.vaadin.nanoscroller.client.nanoscrollerpanel.NanoScrollerPanelClientRpc;
import eu.maxschuster.vaadin.nanoscroller.client.nanoscrollerpanel.NanoScrollerPanelState;

//TODO implement Scrollable etc...
@JavaScript("js/jquery.nanoscroller.js")
@StyleSheet("css/nanoscroller.css")
public class NanoScrollerPanel extends AbstractSingleComponentContainer {

	private static final long serialVersionUID = -8308664784164183763L;

	public NanoScrollerPanel() {
		super();
    }
	
	public void refresh() {
		getRpcProxy(NanoScrollerPanelClientRpc.class).refresh();
	}

    @Override
    public NanoScrollerPanelState getState() {
        return (NanoScrollerPanelState) super.getState();
    }

    public boolean isiOSNativeScrolling() {
    	return getState().iOSNativeScrolling;
    }

    public void setiOSNativeScrolling(boolean iOSNativeScrolling) {
    	getState().iOSNativeScrolling = iOSNativeScrolling;
    }

    public boolean isPreventPageScrolling() {
    	return getState().preventPageScrolling;
    }

    public void setPreventPageScrolling(boolean preventPageScrolling) {
    	getState().preventPageScrolling = preventPageScrolling;
    }

    public boolean isDisableResize() {
    	return getState().disableResize;
    }

    public void setDisableResize(boolean disableResize) {
    	getState().disableResize = disableResize;
    }

    public boolean isAlwaysVisible() {
    	return getState().alwaysVisible;
    }

    public void setAlwaysVisible(boolean alwaysVisible) {
    	getState().alwaysVisible = alwaysVisible;
    }

    public int getFlashDelay() {
    	return getState().flashDelay;
    }

    public void setFlashDelay(int flashDelay) {
    	getState().flashDelay = flashDelay;
    }

    public int getSliderMinHeight() {
    	return getState().sliderMinHeight;
    }

    public void setSliderMinHeight(int sliderMinHeight) {
    	getState().sliderMinHeight = sliderMinHeight;
    }

    public Integer getSliderMaxHeight() {
    	return getState().sliderMaxHeight;
    }

    public void setSliderMaxHeight(Integer sliderMaxHeight) {
    	getState().sliderMaxHeight = sliderMaxHeight;
    }

}
