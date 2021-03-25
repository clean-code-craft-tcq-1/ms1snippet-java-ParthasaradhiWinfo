package sensorval;

import java.util.List;

public class SensorValidator {
	public static boolean isMaxDelta(double value, double nextValue, double maxDelta) {

		if (nextValue - value > maxDelta) {
			return false;
		}
		return true;
	}

	public static boolean validateSOCreadings(List<Double> values) {
		return getReadings(values, 0.5);
	}

	public static boolean validateCurrentreadings(List<Double> values) {
		return getReadings(values, 0.1);
	}

	public static boolean getReadings(List<Double> values, double maxDelta) {
		int lastButOneIndex = getLastButOneIndex(values);
		for (int i = 0; i < lastButOneIndex; i++) {
			if(!getMaxDeltaCheck(values, i, maxDelta)) {
				return false;
			}

		}
		return true;
	}
	
	public static boolean getMaxDeltaCheck(List<Double> values, int index, double maxDelta) {
		if (!nullCheck(values, index) && !isMaxDelta(values.get(index), values.get(index + 1), maxDelta)) {
			return false;
		} 
		return true;
	}
	
	public static boolean nullCheck(List<Double> values, int index) {
		if (values.get(index) == null || values.get(index + 1) == null) {
			return true;
		}
		return false;
	}

	public static int getLastButOneIndex(List<Double> values) {
		return values != null ? values.size() - 1 : 0;
	}
}
