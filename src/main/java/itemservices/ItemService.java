package itemservices;
import database.*;
import itemdetails.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ItemService {

	private Map<String, ItemDetail> items = DatabaseClass.getItems();
	
	public Map<String, ItemDetail> getItems() {
		return items;
	}
	public ItemService(){
		items.put("First", new ItemDetail(1L, "Air Jordan's", "Air Jordan 1", "Jordan", "Basketball shoes", "Black/Red", 5.0, 2, "Male", "9" ));
		items.put("Second", new ItemDetail(2L, "Nike Elite shoes", "Kobe 1", "Nike", "Basketball shoes", "White/Yellow", 4.9, 5, "Male", "10" ));
	}
	public List<ItemDetail> getAllItems(){
		return new ArrayList<ItemDetail>(items.values());
	}
	
}
