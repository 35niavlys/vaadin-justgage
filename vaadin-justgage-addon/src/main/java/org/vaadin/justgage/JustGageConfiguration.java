package org.vaadin.justgage;

import java.io.Serializable;
import java.lang.reflect.Field;

public class JustGageConfiguration implements Serializable {

	/**
	 * Specify a specific DOM id. An id will be generated if this property is
	 * not defined
	 */
	public String id;

	/**
	 * value gauge is showing
	 * 
	 * Default value: 0
	 */
	public Float value;

	/**
	 * defaults parameter to use
	 * 
	 * Default value: false
	 */
	public Boolean defaults;

	/**
	 * this is container element
	 */
	public Object parentNode;

	/**
	 * gauge width
	 */
	public Integer width;

	/**
	 * gauge height
	 */
	public Integer height;

	/**
	 * color of label showing current value
	 * 
	 * Default value: #010101
	 */
	public String valueFontColor;

	/**
	 * font family of label showing current value
	 * 
	 * Default value: Arial
	 */
	public String valueFontFamily;

	/**
	 * special symbol to show next to value
	 */
	public String symbol;

	/**
	 * minimum value
	 * 
	 * Default value: 0
	 */
	public Float min;

	/**
	 * minimum value text
	 * 
	 * Default value: min
	 */
	public String minTxt;

	/**
	 * maximum value
	 * 
	 * Default value: 100
	 */
	public Float max;

	/**
	 * maximum value text
	 * 
	 * Default value: max
	 */
	public String maxTxt;

	/**
	 * reverse min and max
	 * 
	 * Default value: false
	 */
	public Boolean reverse;

	/**
	 * number of decimal places for our human friendly number to contain
	 * 
	 * Default value: 0
	 */
	public Integer humanFriendlyDecimal;

	/**
	 * width of the gauge element
	 * 
	 * Default value: 1.0
	 */
	public Float gaugeWidthScale;

	/**
	 * background color of gauge element
	 * 
	 * Default value: #edebeb
	 */
	public String gaugeColor;

	/**
	 * text to show below value
	 */
	public String label;


	/**
	 * color of label showing label under value
	 * 
	 * Default value: #b3b3b3
	 */
	public String labelFontColor;

	/**
	 * shadow opacity, values 0 ~ 1
	 * 
	 * Default value: 0.2
	 */
	public Float shadowOpacity;

	/**
	 * inner shadow size
	 * 
	 * Default value: 5
	 */
	public Integer shadowSize;

	/**
	 * how much is shadow offset from top
	 * 
	 * Default value: 3
	 */
	public Integer shadowVerticalOffset;

	/**
	 * colors of indicator, from lower to upper, in hex format
	 * 
	 * Default value: [ "#a9d70b", "#f9c802", "#ff0000" ]
	 */
	public String[] levelColors;

	/**
	 * length of initial load animation
	 * 
	 * Default value: 700
	 */
	public Integer startAnimationTime;

	/**
	 * type of initial animation
	 * 
	 * Default value: {@link AnimationType#EASE_IN}
	 */
	public AnimationType startAnimationType;

	/**
	 * length of refresh animation
	 * 
	 * Default value: 700
	 */
	public Integer refreshAnimationTime;

	/**
	 * type of refresh animation
	 * 
	 * Default value: {@link AnimationType#EASE_IN}
	 */
	public AnimationType refreshAnimationType;
	
	/**
	 * angle to start from when in donut mode
	 * 
	 * Default value: 90
	 */
	public Integer donutStartAngle;

	/**
	 * absolute minimum font size for the value
	 * 
	 * Default value: 16
	 */
	public Integer valueMinFontSize;

	/**
	 * absolute minimum font size for the label
	 * 
	 * Default value: 10
	 */
	public Integer labelMinFontSize;

	/**
	 * absolute minimum font size for the minimum label
	 * 
	 * Default value: 10
	 */
	public Integer minLabelMinFontSize;

	/**
	 * absolute minimum font size for the maximum label
	 * 
	 * Default value: 10
	 */
	public Integer maxLabelMinFontSize;

	/**
	 * hide value text
	 * 
	 * Default value: false
	 */
	public Boolean hideValue;

	/**
	 * hide min and max values
	 * 
	 * Default value: false
	 */
	public Boolean hideMinMax;

	/**
	 * hide inner shadow
	 * 
	 * Default value: false
	 */
	public Boolean hideInnerShadow;

	/**
	 * convert large numbers for min, max, value to human friendly (e.g. 1234567 -&gt; 1.23M)
	 * 
	 * Default value: false
	 */
	public Boolean humanFriendly;

	/**
	 * whether to use gradual color change for value, or sector-based
	 * 
	 * Default value: false
	 */
	public Boolean noGradient;

	/**
	 * show full donut gauge
	 * 
	 * Default value: false
	 */
	public Boolean donut;

	/**
	 * whether gauge size should follow changes in container element size
	 * 
	 * Default value: false
	 */
	public Boolean relativeGaugeSize;

	/**
	 * animate level number change
	 * 
	 * Default value: false
	 */
	public Boolean counter;

	/**
	 * number of digits after floating point
	 * 
	 * Default value: 0
	 */
	public Integer decimals;

	/**
	 * number of digits after floating point
	 * 
	 * Default value: []
	 */
	public Object[] customSectors;

	/**
	 * formats numbers with commas where appropriate
	 * 
	 * Default value: false
	 */
	public Boolean formatNumber;

	/**
	 * show value pointer
	 * 
	 * Default value: false
	 */
	public Boolean pointer;

	/**
	 * define pointer look
	 * 
	 * Default value: []
	 */
	public Object[] pointerOptions;


	public enum AnimationType {
		LINEAR("linear"),
		EASE_IN(">"),
		EASE_OUT("<"),
		EASE_IN_AND_OUT("<>"),
		BOUNCE("bounce"),
		ELASTIC("elastic"),
		BACK_IN("backIn"),
		BACK_OUT("backOut");

		private String value;

		private AnimationType(String value) {
			this.value = value;
		};

		@Override
		public String toString() {
			return value;
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("{");
		try {
			Field[] fields = getClass().getDeclaredFields();
			for (Field field : fields) {
				Object value = field.get(this);
				if (field.getModifiers() == 1 && value != null) {
					append(field.getName(), sb).append(':');
					append(value, sb).append(',');
				}
			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		sb.setLength(sb.length() - 1);
		sb.append('}');
		return sb.toString();
	}

	private StringBuilder append(Object o, StringBuilder sb) {
		if (o instanceof Number)
			sb.append(o);
		else if (o instanceof Object[]) {
			sb.append('[');
			Object[] tab = (Object[]) o;
			for (int i = 0; i < tab.length; i++) {
				append(tab[i], sb).append(',');
			}
			sb.setLength(sb.length() - 1);
			sb.append(']');
		} else
			sb.append('"').append(o).append('"');
		return sb;
	}
}