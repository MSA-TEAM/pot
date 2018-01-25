package kr.co.sicc.gsp.svm.gms.common.utils.image;

import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.gmsutil.file.FilePath;
import com.gmsutil.file.FileUpDown;
import com.gmsutil.image.ImageVO;
import com.gmsutil.image.Thumbnail;

@Component
public class CmmImageManager {
	
	public ImageVO saveImage(String uploadPath, MultipartFile file , String photoFlag)throws IOException, NullPointerException{
		try {
			ImageVO vo = new ImageVO();
			
			if (file.isEmpty() == true) {
				return null;
			}
			
			if(uploadPath != null && !uploadPath.equals("")){
				FileUpDown fileManager = new FileUpDown();
				
				String fileName = file.getOriginalFilename();
				if(fileName != null && fileName.indexOf("\\") > -1){
					fileName = fileName.substring(fileName.lastIndexOf("\\")+1);
				}
				String thumbNailName = fileName.substring(0, fileName.lastIndexOf("."))+"_thumb"+fileName.substring(fileName.lastIndexOf(".")+1, fileName.length());
				
				FilePath filePath = new FilePath(uploadPath, fileName);
				FilePath thumbnailFilePath = new FilePath(uploadPath, thumbNailName);
				
				fileManager.upload(filePath, file.getBytes());
				
				vo.setOrigin_file(file.getBytes());
				vo.setOrigin_file_nm(fileName);
				vo.setOrigin_save_path(filePath.getHardPathName());
				if(!"passport".equals(photoFlag)){
					byte[] thumb = Thumbnail.scale(filePath, thumbnailFilePath, 0.4);
					vo.setThumbnail_file(thumb);
					vo.setThumbnail_file_nm(thumbnailFilePath.getOriginalName());
					vo.setThumbnail_save_path(thumbnailFilePath.getHardPathName());
				}
				
			}else{
				return null;
			}
			return vo;
		} catch(IOException | NullPointerException e){
			throw e;
		}
	}
}
