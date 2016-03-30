package itemdetails;

public class ItemDetail {
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemBrand() {
		return itemBrand;
	}
	public void setItemBrand(String itemBrand) {
		this.itemBrand = itemBrand;
	}
	public String getItemCategory() {
		return itemCategory;
	}
	public void setItemCategory(String itemCategory) {
		this.itemCategory = itemCategory;
	}
	public String getItemDescription() {
		return itemDescription;
	}
	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}
	public String getItemColor() {
		return itemColor;
	}
	public void setItemColor(String itemColor) {
		this.itemColor = itemColor;
	}
	public double getItemRating() {
		return itemRating;
	}
	public void setItemRating(double itemRating) {
		this.itemRating = itemRating;
	}
	public int getItemStock() {
		return itemStock;
	}
	public void setItemStock(int itemStock) {
		this.itemStock = itemStock;
	}
	public String getItemGender() {
		return itemGender;
	}
	public void setItemGender(String itemGender) {
		this.itemGender = itemGender;
	}
	public String getItemSize() {
		return itemSize;
	}
	public void setItemSize(String itemSize) {
		this.itemSize = itemSize;
	}
	
	private long id;
	private String itemName;
	private String itemBrand;
	private String itemCategory;
	private String itemDescription;
	private String itemColor;
	private double itemRating;
	private int itemStock;
	private String itemGender;
	private String itemSize;


	public ItemDetail(){
	
	}
	public ItemDetail(long id, String itemDescription, String itemName, String itemBrand, String itemCategory, String itemColor, double itemRating, int itemStock, String itemGender, String itemSize){
		this.id = id;
		this.itemName = itemName;
		this.itemBrand = itemBrand;
		this.itemCategory = itemCategory;
		this.itemDescription = itemDescription;
		this.itemColor = itemColor;
		this.itemRating = itemRating;
		this.itemStock = itemStock;
		this.itemGender = itemGender;
		this.itemSize = itemSize;
	}
	
}
