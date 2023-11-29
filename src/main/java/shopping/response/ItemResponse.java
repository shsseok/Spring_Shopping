package shopping.response;

import java.util.List;

import shopping.model.ImageVO;
import shopping.model.ItemVO;
/**
 * 단일 상품을 조회 할 때 상품 이미지와 상품을 같이 담아 조회
 * @author 심현석
 *
 */
public class ItemResponse {
	private ItemVO itemVO;
	private List<ImageVO> images;
	public ItemVO getItemVO() {
		return itemVO;
	}
	public void setItemVO(ItemVO itemVO) {
		this.itemVO = itemVO;
	}
	public List<ImageVO> getImages() {
		return images;
	}
	public void setImages(List<ImageVO> images) {
		this.images = images;
	}
	
}
