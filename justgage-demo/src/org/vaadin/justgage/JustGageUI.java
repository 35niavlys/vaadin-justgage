package org.vaadin.justgage;

import java.util.Random;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class JustGageUI extends UI {

	private static final long serialVersionUID = -7874608694296978063L;

	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = JustGageUI.class)
	public static class Servlet extends VaadinServlet {
		private static final long serialVersionUID = -5233373459504543665L;
	}

	@Override
	protected void init(VaadinRequest request) {
		final VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		setContent(layout);
		
		JustGageConfiguration conf = new JustGageConfiguration();
		conf.value = 5.26f;
		conf.title = "JustGage1";
		conf.decimals = 1;
		conf.symbol = "%";
		
		final JustGage justGage1 = new JustGage(conf);
		justGage1.setWidth(100, Unit.PERCENTAGE);
		layout.addComponent(justGage1);

		Button button = new Button("Change value");
		button.addClickListener(new Button.ClickListener() {
			private static final long serialVersionUID = 3865638390195203357L;
			public void buttonClick(ClickEvent event) {
				justGage1.refresh(new Random().nextInt(100));
			}
		});
		layout.addComponent(button);
	}

}