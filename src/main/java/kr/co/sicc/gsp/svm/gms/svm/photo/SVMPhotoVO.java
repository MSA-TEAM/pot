package kr.co.sicc.gsp.svm.gms.svm.photo;

import java.util.Arrays;

import kr.co.sicc.gsp.svm.sicc.common.vo.SiccGenericVO;

@SuppressWarnings("serial")
public class SVMPhotoVO extends SiccGenericVO{
	
	private String ad_no = "";
	private String photo_fg = "";
	private String file_nm = "";
	
	private byte[] photo = null;
	private byte[] thumbnail = null;
	
	
	public String getFile_nm() {
		return file_nm;
	}
	public void setFile_nm(String file_nm) {
		this.file_nm = file_nm;
	}
	public String getPhoto_fg() {
		return photo_fg;
	}
	public void setPhoto_fg(String photo_fg) {
		this.photo_fg = photo_fg;
	}
	public String getAd_no() {
		return ad_no;
	}
	public void setAd_no(String ad_no) {
		this.ad_no = ad_no;
	}
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		if(photo == null){
			this.photo = new byte[0];
		}else{
			this.photo = Arrays.copyOf(photo, photo.length);
		}
	}
	public byte[] getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(byte[] thumbnail) {
		if(thumbnail == null){
			this.thumbnail = new byte[0];
		}else{
			this.thumbnail = Arrays.copyOf(thumbnail, thumbnail.length);
		}
	}
	
}
