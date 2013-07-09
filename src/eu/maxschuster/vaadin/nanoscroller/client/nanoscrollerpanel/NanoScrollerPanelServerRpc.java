package eu.maxschuster.vaadin.nanoscroller.client.nanoscrollerpanel;

import com.vaadin.shared.communication.ServerRpc;

public interface NanoScrollerPanelServerRpc extends ServerRpc {
	
	public void scrollTop();

	public void scrollEnd();
	
}
