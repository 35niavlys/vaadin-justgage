package org.vaadin.justgage.demo;

import java.util.Random;

import javax.servlet.annotation.WebServlet;

import org.vaadin.justgage.JustGage;
import org.vaadin.justgage.JustGageConfiguration;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@Theme("demo")
@Title("JustGage Add-on Demo")
@SuppressWarnings("serial")
public class DemoUI extends UI
{

    @WebServlet(value = "/*", asyncSupported = true)
    @VaadinServletConfiguration(productionMode = false, ui = DemoUI.class)
    public static class Servlet extends VaadinServlet {
    }

    @Override
    protected void init(VaadinRequest request) {
		final VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		setContent(layout);
		
		JustGageConfiguration conf = new JustGageConfiguration();
		conf.value = 5.26f;
		conf.decimals = 1;
		conf.symbol = "%";
		
		final JustGage justGage1 = new JustGage(conf);
		justGage1.setWidth(100, Unit.PERCENTAGE);
		layout.addComponent(justGage1);

		Button button = new Button("Change value");
		button.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				justGage1.refresh(new Random().nextFloat()*100);
			}
		});
		layout.addComponent(button);
    }
}
