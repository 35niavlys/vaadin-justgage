package org.vaadin.justgage;

import com.vaadin.annotations.JavaScript;
import com.vaadin.ui.AbstractJavaScriptComponent;

/**
 * JustGage Component
 * 
 * @author Sylvain Menu
 */
@JavaScript({ "justGageConnector.js", "justgage.js", "raphael-2.1.4.min.js" })
public class JustGage extends AbstractJavaScriptComponent {

	private static int currChartId = 0;

	private int justGageId = ++currChartId;

	public JustGage(JustGageConfiguration conf) {
		setStyleName("justgage");
		if (conf.id == null)
			conf.id = getId();
		callFunction("init", conf.toString());
	}

	/**
	 * Destroy gauge object 
	 */
	public void destroy() {
		callFunction("destroy");
	}

	/**
	 * Change value of the component
	 * 
	 * @param value value of the gauge
	 */
	public void refresh(float value) {
		callFunction("refresh", value);
	}

	/**
	 * Change value and max of the component
	 * 
	 * @param value value of the gauge
	 * @param max max of the gauge
	 */
	public void refresh(float value, float max) {
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