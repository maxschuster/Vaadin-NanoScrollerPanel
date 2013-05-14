package eu.maxschuster.vaadin.nanoscroller.client.nanoscrollerpanel;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Widget;

import com.vaadin.client.ComponentConnector;
import com.vaadin.client.ConnectorHierarchyChangeEvent;
import com.vaadin.client.ui.AbstractSingleComponentContainerConnector;
import com.vaadin.client.ui.SimpleManagedLayout;
import com.vaadin.shared.ui.Connect;

import eu.maxschuster.vaadin.nanoscroller.NanoScrollerPanel;
import eu.maxschuster.vaadin.nanoscroller.client.nanoscrollerpanel.NanoScrollerPanelWidget;
import eu.maxschuster.vaadin.nanoscroller.client.nanoscrollerpanel.NanoScrollerPanelClientRpc;
import eu.maxschuster.vaadin.nanoscroller.client.nanoscrollerpanel.NanoScrollerPanelState;
import com.vaadin.client.communication.StateChangeEvent;

@Connect(NanoScrollerPanel.class)
public class NanoScrollerPanelConnector extends AbstractSingleComponentContainerConnector implements SimpleManagedLayout {
	
	private static final long serialVersionUID = 1600467056362736199L;

	public NanoScrollerPanelConnector() {    
        registerRpc(NanoScrollerPanelClientRpc.class, new NanoScrollerPanelClientRpc() {
        	
			private static final long serialVersionUID = 291165372352905187L;

			public void refresh() {
            	getWidget().refresh();
            }
        });
    }

    @Override
    protected Widget createWidget() {
        return GWT.create(NanoScrollerPanelWidget.class);
    }

    @Override
    public NanoScrollerPanelWidget getWidget() {
        return (NanoScrollerPanelWidget) super.getWidget();
    }

    @Override
    public NanoScrollerPanelState getState() {
        return (NanoScrollerPanelState) super.getState();
    }

    @Override
    public void onStateChanged(StateChangeEvent stateChangeEvent) {
        super.onStateChanged(stateChangeEvent);
        NanoScrollerPanelWidget widget = getWidget();
        NanoScrollerPanelState state = getState();
        
        widget.setAlwaysVisible(state.alwaysVisible);
        widget.setDisableResize(state.disableResize);
        widget.setFlashDelay(state.flashDelay);
        widget.setiOSNativeScrolling(state.iOSNativeScrolling);
        widget.setPreventPageScrolling(state.preventPageScrolling);
        widget.setSliderMaxHeight(state.sliderMaxHeight);
        widget.setSliderMinHeight(state.sliderMinHeight);
    }

	@Override
	public void updateCaption(ComponentConnector connector) {
		// Nothing...
	}

	@Override
	public void onConnectorHierarchyChange(
			ConnectorHierarchyChangeEvent connectorHierarchyChangeEvent) {
		getWidget().setWidget(getContentWidget());
	}

	@Override
	public void layout() {
		getWidget().refresh();
	}
	
	

}

