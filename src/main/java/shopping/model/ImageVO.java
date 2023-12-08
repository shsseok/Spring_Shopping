package shopping.model;

import java.sql.Timestamp;



public class ImageVO {
	private int imageId;
	private String originalImageName;
	private int itemId;
	private String imagePath;
	private Timestamp uploadedDate;
	
	public String originalImageName() {
		return originalImageName;
	}
	public void originalImageName(String originalImageName) {
		this.originalImageName= originalImageName;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public int getImageId() {
		return imageId;
	}
	public void setImageId(int imageId) {
		this.imageId = imageId;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	
	public Timestamp getUploadedDate() {
		return uploadedDate;
	}
	public void setUploadedDate(Timestamp uploadedDate) {
		this.uploadedDate = uploadedDate;
	}
	
}
