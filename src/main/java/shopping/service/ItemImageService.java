package shopping.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import egovframework.rte.fdl.property.EgovPropertyService;
import shopping.mapper.ItemImageMapper;
import shopping.model.ImageVO;

@Service
public class ItemImageService {
	private Logger log = LoggerFactory.getLogger(ItemImageService.class);

	@Autowired
	private ItemImageMapper itemImageMapper;
	/*@Resource(name="propertiesService")
	private EgovPropertyService propertiesService;*/

	public void itemImageAdd(List<MultipartFile> imageFileList, int itemId) throws IllegalStateException, IOException {
		String filePath ="C:\\Users\\geomex\\Desktop\\itemimages";
		log.info("FilePath: {}", filePath);
		if (imageFileList != null && !imageFileList.isEmpty()) {
			List<ImageVO> imageList=new ArrayList<ImageVO>();
			for (MultipartFile file : imageFileList) {
				if (!file.isEmpty()) {
					ImageVO imageVO = new ImageVO();
					String fileName = file.getOriginalFilename();
					System.out.println(fileName);
					String storedFileName = UUID.randomUUID().toString() + "_" + fileName;
					File storeFile = new File(filePath + File.separator + storedFileName);
					file.transferTo(storeFile);
					imageVO.setItemId(itemId);
					imageVO.originalImageName(storedFileName);
					imageVO.setImagePath(filePath);
					imageList.add(imageVO);
				}
			}
			itemImageMapper.itemImageSave(imageList);
		}
	}

}
