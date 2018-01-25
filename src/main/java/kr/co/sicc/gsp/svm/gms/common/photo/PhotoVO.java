package kr.co.sicc.gsp.svm.gms.common.photo;

import kr.co.sicc.gsp.svm.sicc.common.vo.SiccGenericVO;

@SuppressWarnings("serial")
public class PhotoVO extends SiccGenericVO{
	private String ad_no = "";
	private byte[] photo = null;
	private byte[] thumbnail = null;
	
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
		this.photo = photo;
	}
	public byte[] getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(byte[] thumbnail) {
		this.thumbnail = thumbnail;
	}
	
}
