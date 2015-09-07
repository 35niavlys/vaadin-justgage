package org.vaadin.justgage;

import com.vaadin.annotations.JavaScript;
import com.vaadin.ui.AbstractJavaScriptComponent;

/**
 * JustGage Component
 * 
 * @author Sylvain Menu
 */
@JavaScript({ "justGageConnector.js", "justgage.js",
		"raphael-2.1.4.min.js" })
public class JustGage extends AbstractJavaScriptComponent {

	private static final long serialVersionUID = -6488763193380118915L;

	private static int currChartId = 0;

	private int justGageId = ++currChartId;

	public JustGage(JustGageConfiguration conf) {
		setStyleName("justgage");
		if (conf.id == null)
			conf.id = getId();
		callFunction("init", conf.toString());
	}

	/**
	 * Change value of the component
	 * 
	 * @param value
	 */
	public void refresh(int value) {
		callFunction("refresh", value);
	}

	/**
	 * Change value and max of the component
	 * 
	 * @param value
	 * @param max
	 */
	public void refresh(int value, int max) {
		callFunction("refresh", value, max);
	}
	
	/**
	 * Returns the DOM Id of the component.
	 * 
	 * @return DOM Id of the component
	 */
	@Override
	public String getId() {
		return "justgage_" + justGageId;
	}

}
