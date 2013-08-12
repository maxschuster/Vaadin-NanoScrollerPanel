package eu.maxschuster.vaadin.nanoscroller.test;

import com.vaadin.annotations.PreserveOnRefresh;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import eu.maxschuster.vaadin.nanoscroller.NanoScrollerPanel;
import eu.maxschuster.vaadin.nanoscroller.event.ScrollEndEvent;
import eu.maxschuster.vaadin.nanoscroller.event.ScrollEndListener;
import eu.maxschuster.vaadin.nanoscroller.event.ScrollTopEvent;
import eu.maxschuster.vaadin.nanoscroller.event.ScrollTopListener;

/**
 * Main UI class
 */
@SuppressWarnings("serial")
@PreserveOnRefresh
public class NanoScrollerUI extends UI {

	@Override
	protected void init(VaadinRequest request) {
		final VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		setContent(layout);
		
		NanoScrollerPanel panel = new NanoScrollerPanel();
		panel.setHeight("100px");
		panel.setWidth("200px");
		layout.addComponent(panel);
		
		final VerticalLayout panelLayout = new VerticalLayout();
		panel.setContent(panelLayout);
		panel.setAlwaysVisible(false);
		panel.setiOSNativeScrolling(false);
		panel.setPreventPageScrolling(true);
		panel.setDebounceTime(500);
		panel.addListener(new ScrollEndListener() {
			
			@Override
			public void onScrollEnd(ScrollEndEvent event) {
				System.out.println("Scrolled to end!");
			}
		});
		
		panel.addListener(new ScrollTopListener() {
			
			@Override
			public void onScrollTop(ScrollTopEvent event) {
				System.out.println("Scrolled to top!");
			}
		});

		Button button = new Button("Click Me");
		button.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				panelLayout.addComponent(new Label("Thank you for clicking"));
			}
		});
		layout.addComponent(button);
		
		
	}

}