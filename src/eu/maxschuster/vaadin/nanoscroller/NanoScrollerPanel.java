package eu.maxschuster.vaadin.nanoscroller;

import com.vaadin.annotations.JavaScript;
import com.vaadin.annotations.StyleSheet;
import com.vaadin.ui.AbstractSingleComponentContainer;

import eu.maxschuster.vaadin.nanoscroller.client.nanoscrollerpanel.NanoScrollerPanelClientRpc;
import eu.maxschuster.vaadin.nanoscroller.client.nanoscrollerpanel.NanoScrollerPanelServerRpc;
import eu.maxschuster.vaadin.nanoscroller.client.nanoscrollerpanel.NanoScrollerPanelState;
import eu.maxschuster.vaadin.nanoscroller.event.ScrollEndEvent;
import eu.maxschuster.vaadin.nanoscroller.event.ScrollEndListener;
import eu.maxschuster.vaadin.nanoscroller.event.ScrollTopEvent;
import eu.maxschuster.vaadin.nanoscroller.event.ScrollTopListener;

//TODO implement Scrollable etc...
@JavaScript({"js/jquery.nanoscroller.min.js","js/jquery-debounce-min.js"})
@StyleSheet("css/nanoscroller.css")
public class NanoScrollerPanel extends AbstractSingleComponentContainer {

	private static final long serialVersionUID = -8308664784164183763L;
	
	@SuppressWarnings("serial")
	private NanoScrollerPanelServerRpc rpc = new NanoScrollerPanelServerRpc() {
		
		@Override
		public void scrollEnd() {
			fireScrollEndEvent();
		}

		@Override
		public void scrollTop() {
			fireScrollTopEvent();
		}
	};

	public NanoScrollerPanel() {
		super();
		registerRpc(rpc);
    }
	
	public void refresh() {
		getRpcProxy(NanoScrollerPanelClientRpc.class).refresh();
	}
	
	public void fireScrollTopEvent() {
		fireEvent(new ScrollTopEvent(this));
	}
	
	public void addListener(ScrollTopListener listener) {
		addListener(ScrollTopEvent.EVENT_ID, ScrollTopEvent.class, listener, ScrollTopListener.onScrollTopMethod);
	}
	
	public void removeListener(ScrollTopListener listener) {
		removeListener(ScrollTopEvent.EVENT_ID, ScrollTopEvent.class, listener);
	}
	
	public void fireScrollEndEvent() {
		fireEvent(new ScrollEndEvent(this));
	}
	
	public void addListener(ScrollEndListener listener) {
		addListener(ScrollEndEvent.EVENT_ID, ScrollEndEvent.class, listener, ScrollEndListener.onScrollEndMethod);
	}
	
	public void removeListener(ScrollEndListener listener) {
		removeListener(ScrollEndEvent.EVENT_ID, ScrollTopEvent.class, listener);
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
    
    public int getDebounceTime() {
    	return getState().debounceTime;
    }
    
    public void setDebounceTime(int debounceTime) {
    	getState().debounceTime = debounceTime;
    }

}
