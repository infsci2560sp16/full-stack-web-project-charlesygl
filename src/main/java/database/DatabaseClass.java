package database;

import itemdetails.*;
import java.util.HashMap;
import java.util.Map;

public class DatabaseClass {
	private static Map<String, ItemDetail> items = new HashMap<>();

	public static Map<String, ItemDetail> getItems(){
		return items;
	}
}