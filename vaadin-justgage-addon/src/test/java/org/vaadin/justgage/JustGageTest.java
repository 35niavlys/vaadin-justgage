package org.vaadin.justgage;

import junit.framework.Assert;
import org.junit.Test;
import org.vaadin.justgage.JustGageConfiguration.AnimationType;

public class JustGageTest {

	@Test
	public void test() {
		JustGageConfiguration conf = new JustGageConfiguration();
		conf.counter = true;
		conf.levelColors = new String[] { "#D60000", "#F57A00", "#FADA28", "#52D138" };
		conf.height = 521;
		conf.minTxt = "minTxt";
		conf.shadowOpacity = 5f;
		conf.startAnimationType = AnimationType.ELASTIC;
		
		Assert.assertEquals(
				"{\"height\":521,\"minTxt\":\"minTxt\",\"shadowOpacity\":5.0,\"levelColors\":[\"#D60000\",\"#F57A00\",\"#FADA28\",\"#52D138\"],\"startAnimationType\":\"elastic\",\"counter\":\"true\"}",
				conf.toString()
		);
	}
}
