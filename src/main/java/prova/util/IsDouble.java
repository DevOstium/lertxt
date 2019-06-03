package prova.util;

public class IsDouble {

	public boolean test(String obj) {

		try {
			Double.valueOf(obj);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
