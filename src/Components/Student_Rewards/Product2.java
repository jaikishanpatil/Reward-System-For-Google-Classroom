package Components.Student_Rewards;


public class Product2 {
	private String id;
	private String name;
	private String qunt;
	private String price;
	private String catId;
	private byte[] image;
	
	public Product2(String id, String name, String qunt, String price, byte[] image,String catId) {
		super();
		this.id = id;
		this.name = name;
		this.qunt = qunt;
		this.price = price;
		this.catId = catId;
		this.image = image;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getQunt() {
		return qunt;
	}

	public void setQunt(String qunt) {
		this.qunt = qunt;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getCatId() {
		return catId;
	}

	public void setCatId(String catId) {
		this.catId = catId;
	}

	public byte[] getMyImage() {
		return image;
	}

	public void setMyImage(byte[] image) {
		this.image = image;
	}
	
	
	
}
