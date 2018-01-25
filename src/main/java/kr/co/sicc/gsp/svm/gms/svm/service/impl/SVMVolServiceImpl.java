package kr.co.sicc.gsp.svm.gms.svm.service.impl;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.gmsutil.image.ImageVO;

import kr.co.sicc.gsp.svm.gms.common.tools.ToolsVO;
import kr.co.sicc.gsp.svm.gms.common.utils.file.CmmFileManager;
import kr.co.sicc.gsp.svm.gms.common.utils.image.CmmImageManager;
import kr.co.sicc.gsp.svm.gms.svm.dao.SVMUserDAO;
import kr.co.sicc.gsp.svm.gms.svm.dao.SVMVolDAO;
import kr.co.sicc.gsp.svm.gms.svm.photo.SVMPhotoDAO;
import kr.co.sicc.gsp.svm.gms.svm.photo.SVMPhotoVO;
import kr.co.sicc.gsp.svm.gms.svm.service.SVMVolService;
import kr.co.sicc.gsp.svm.gms.svm.vo.SVMInfoVO;
import kr.co.sicc.gsp.svm.gms.svm.vo.SVMUserVO;
import kr.co.sicc.gsp.svm.gms.svm.vo.SVMVolVO;
import kr.co.sicc.gsp.svm.sicc.aeschiper.Base64Encoder;
import kr.co.sicc.gsp.svm.sicc.aeschiper.FileCoder;
import kr.co.sicc.gsp.svm.sicc.common.SiccMessageUtil;
import kr.co.sicc.gsp.svm.sicc.exception.SiccException;
import kr.co.sicc.gsp.svm.sicc.tools.SiccToolsManager;
import kr.co.sicc.gsp.svm.sicc.util.SVMSiccUserUtil;
	/**
	 * <pre>	
	 * com.gms.svm.service.impl
	 * SVMVolServiceImpl.java
	 * Description 	:
	 * 자원봉사 지원서 관리 Service Impl
	 * History     	:
	 * </pre>
	 *
	 * @author	 	: gypark
	 * @Date	 	: 2017.07.14
	 * @Version 	: 1.0
	 *
	 */

@Service
public class SVMVolServiceImpl implements SVMVolService {
	
	@Autowired
	@Resource(name="sqlSession")
	SqlSession sqlSession;
	
	@Autowired
	SiccToolsManager toolsManager;
	
	@Autowired
	CmmFileManager fileUpDown;
	
	@Autowired
	CmmImageManager imgUpDown;
	
//	@Resource(name="uploadPath")
//	String uploadPath;
	
	@Autowired
	@Value("${settings.uploadPath}")
	String uploadPath;
	
	@Override
	public SVMVolVO application(SVMVolVO vo) throws SiccException {
		try {
			// SVM Common Code List
			List<ToolsVO> toolsList = new ArrayList<>();
			toolsList.add(new ToolsVO("SVM", "YEAR_CD", "CODE_IDX1" ));
			vo.setResult(toolsManager.select(toolsList));
		
			return vo;
			
		} catch(DataAccessException e) {
			throw SiccMessageUtil.getError(e);
		} catch(ClassCastException e) {
			throw SiccMessageUtil.getError(e);
		}
	}
	
	@Override
	public SVMVolVO input(SVMVolVO vo, String viewTab) throws SiccException {
		try {
			SVMVolDAO mapper = sqlSession.getMapper(SVMVolDAO.class);
			String lang = vo.getLang();
			// SVM Common Code List
			List<ToolsVO> toolsList = new ArrayList<>();
			String unEscape = "";

			if(!"".equals(vo.getAd_no())){
				vo = mapper.select(vo);
				vo.setAreaList(mapper.selectInfo(vo.getAd_no(),lang));
				//passport, ktp_no decode
				if(!vo.getPassport_no().trim().equals("")){
					unEscape = FileCoder.decrypt(vo.getPassport_no());
					vo.setPassport_no(URLDecoder.decode(unEscape, "utf-8"));
				}
				if(!vo.getKtp_no().trim().equals("")){
					unEscape = FileCoder.decrypt(vo.getKtp_no());
					vo.setKtp_no(URLDecoder.decode(unEscape, "utf-8"));
				}
				if(vo.getMobile_no()!= null && !"".equals(vo.getMobile_no())){
					unEscape = FileCoder.decrypt(vo.getMobile_no());
					vo.setMobile_no(URLDecoder.decode(unEscape, "utf-8"));
				}
				
				switch(viewTab){
					case "uploadPhoto" 		:
					case "finishInfo_photo" :
					//photo 셋팅
					SVMPhotoDAO mapper_photo = sqlSession.getMapper(SVMPhotoDAO.class);
					Map<String, Object> imgResultMap = mapper_photo.read(vo.getAd_no(), "facePhoto");
					if(imgResultMap != null){
						String photoImg = new String(Base64Encoder.encodeToHtmlImage((byte[])imgResultMap.get("PHOTO")));
						vo.setFacephoto(photoImg);
					}
					imgResultMap = mapper_photo.read(vo.getAd_no(), "bodyPhoto");
					if(imgResultMap != null){
						String photoImg = new String(Base64Encoder.encodeToHtmlImage((byte[])imgResultMap.get("PHOTO")));
						vo.setBodyphoto(photoImg);
					}
					break; 
				}
				
				
			}
			
			switch(viewTab){
				case "basicInfo" : 
					toolsList.add(new ToolsVO("SVM", "CTRY_CD", "MINOR_CD" ));
					//toolsList.add(new ToolsVO("SVM", "VENUE_CD", "CODE_ORDER,MINOR_CD" ));
					toolsList.add(new ToolsVO("SVM", "GENDER", "CODE_ORDER,MINOR_CD" ));
					//toolsList.add(new ToolsVO("SVM", "CTRY_CD", "CODE_ORDER,CODE_NM2" ));
					
					toolsList.add(new ToolsVO("SVM", "CTRY_CD_FG", "CODE_ORDER,MINOR_CD" ));
					//toolsList.add(new ToolsVO("SVM", "E_MAIL", "CODE_ORDER,MINOR_CD" ));
					//toolsList.add(new ToolsVO("SVM", "BANK_CD", "CODE_ORDER,MINOR_CD"));
					toolsList.add(new ToolsVO("SVM", "OCCU_CD", "CODE_ORDER,MINOR_CD" ));
					toolsList.add(new ToolsVO("SVM", "UNIV_CD", "CODE_ORDER" ));
					toolsList.add(new ToolsVO("SVM", "UNIV_STAT", "CODE_ORDER" ));
					//toolsList.add(new ToolsVO("SVM", "VOL_CENTER_CD", "CODE_ORDER,MINOR_CD"));
					//toolsList.add(new ToolsVO("SVM", "AVAIL_LOCATION_CD", "MINOR_CD" ));
					//toolsList.add(new ToolsVO("SVM", "JOB_CD", "CODE_ORDER,MINOR_CD"));
					//toolsList.add(new ToolsVO("SVM", "LANG_LVL_CD", "CODE_ORDER,MINOR_CD"));
					//toolsList.add(new ToolsVO("SVM", "AVAIL_WORK_CD", "MINOR_CD"));
					toolsList.add(new ToolsVO("SVM", "UNI_SHIRTS_CD", "CODE_ORDER"));
					toolsList.add(new ToolsVO("SVM", "UNI_WAIST_CD", "CODE_ORDER,MINOR_CD"));
					toolsList.add(new ToolsVO("SVM", "UNI_SHOES_CD", "CODE_ORDER,MINOR_CD"));
					
					toolsList.add(new ToolsVO("SVM", "MARRIED", "CODE_ORDER,MINOR_CD"));
					toolsList.add(new ToolsVO("SVM", "OCCU_OR_UNIV_CD", "CODE_ORDER,MINOR_CD"));
					toolsList.add(new ToolsVO("SVM", "BLOOD_CD", "CODE_ORDER,MINOR_CD"));
					//toolsList.add(new ToolsVO("SVM", "OCCU_CD", "CODE_ORDER,MINOR_CD"));
					toolsList.add(new ToolsVO("SVM", "OCCU_OR_UNIV_MAJOR_CD", "CODE_ORDER,MINOR_CD"));
					toolsList.add(new ToolsVO("SVM", "RELATION_CD", "CODE_ORDER,MINOR_CD"));
					toolsList.add(new ToolsVO("SVM", "PROVINCE_CD", "MINOR_CD"));
					if(!"".equals(vo.getCtry_cd_fg()) && "L".equals(vo.getCtry_cd_fg())){
						
						toolsList.add(new ToolsVO("SVM", "CITY_CD", 	"MINOR_CD" , vo.getProvinsi_cd() ));
						toolsList.add(new ToolsVO("SVM", "VILLAGE_CD",  "MINOR_CD" , vo.getDistrict_cd()));
						toolsList.add(new ToolsVO("SVM", "DISTRICT_CD", "MINOR_CD" ,  vo.getCity_cd() ));
					}
//					toolsList.add(new ToolsVO("SVM", "CITY_CD", 	"MINOR_CD"));
//					toolsList.add(new ToolsVO("SVM", "VILLAGE_CD",  "MINOR_CD"));
//					toolsList.add(new ToolsVO("SVM", "DISTRICT_CD", "MINOR_CD"));
					
					toolsList.add(new ToolsVO("SVM", "TOV", "CODE_ORDER,MINOR_CD" ,"","VOL_DIV_CD"));
					toolsList.add(new ToolsVO("SVM", "PD", "CODE_ORDER,MINOR_CD" ,"","VOL_DIV_CD" ));
					break;
				case "gameInfo" : 
					toolsList.add(new ToolsVO("SVM", "AVAIL_LOCATION_CD", "MINOR_CD" , "jakarta"));
					toolsList.add(new ToolsVO("SVM", "AVAIL_WORK_CD", "MINOR_CD"));
					toolsList.add(new ToolsVO("SVM", "LANG_CD", "CODE_ORDER,MINOR_CD"));
					toolsList.add(new ToolsVO("SVM", "LANG_LVL_CD", "CODE_ORDER,MINOR_CD"));
					
					toolsList.add(new ToolsVO("SVM", "SPORT_EXP_LVL", "CODE_ORDER,MINOR_CD"));
					//toolsList.add(new ToolsVO("SVM", "SPORT_EXP_NM", "CODE_ORDER,MINOR_CD"));
					toolsList.add(new ToolsVO("SVM", "ETC_EXP_LVL", "CODE_ORDER,MINOR_CD"));
					break;
				default :
					break;
			}
			
			vo.setResult(toolsManager.select(toolsList));
			
			return vo;
			
		} catch(DataAccessException e) {
			throw SiccMessageUtil.getError(e);
		} catch(ClassCastException e) {
			throw SiccMessageUtil.getError(e);
		} catch (NoSuchAlgorithmException e) {
			throw SiccMessageUtil.getError(e);
		} catch (IOException e) {
			throw SiccMessageUtil.getError(e);
		} catch (GeneralSecurityException e) {
			throw SiccMessageUtil.getError(e);
		} catch (SiccException e){
			throw SiccMessageUtil.getError(e);
		} catch (Exception e){
			throw SiccMessageUtil.getError(e);
		}
	}
	
	@Override
	public SVMVolVO validation(SVMVolVO vo) throws SiccException {
		return null;
	}

	@Override
	public SVMVolVO edit(SVMVolVO vo) throws SiccException {
		return null;
	}

	
	@Override
	@Transactional(isolation=Isolation.DEFAULT, propagation=Propagation.REQUIRED)
	public SVMVolVO update(SVMVolVO vo, MultipartFile filePhoto, MultipartFile filePassport ,MultipartFile facePhoto ,MultipartFile bodyPhoto, List<MultipartFile> skillPhoto ,HttpServletRequest req ) throws SiccException {
		Boolean isImage = true;
		try {
			HttpSession session = req.getSession();
			SVMVolDAO mapper = sqlSession.getMapper(SVMVolDAO.class);
			SVMUserDAO userMapper = sqlSession.getMapper(SVMUserDAO.class);
			SVMUserVO svmUserVO = (SVMUserVO)session.getAttribute("userInfo");
			SVMUserVO param = new SVMUserVO();
			String submitYn = svmUserVO.getSubmit_yn();
			
			if(!chkImageFile(facePhoto,null,vo)){
				isImage = false;
				throw new SiccException();
			}
			if(!chkImageFile(bodyPhoto,null,vo)){
				isImage = false;
				throw new SiccException();
			}
			if(!chkImageFile(filePhoto,skillPhoto,vo)){
				isImage = false;
				throw new SiccException();
			}
			
			SVMSiccUserUtil.setDefaultUserInfo(vo);
			// 1-3. Encryption - Passport Number & KTP Number & Mobile Number 
			String passport_no = "";
			String ktp_no = "";
			String mobile_no = "";
			
			if (!vo.getPassport_no().trim().equals("")) {
				passport_no = FileCoder.encrypt(URLEncoder.encode(vo.getPassport_no().toUpperCase(), "utf-8"));
				vo.setPassport_no(passport_no);
			}
			if (!vo.getKtp_no().trim().equals("")) {
				ktp_no = FileCoder.encrypt(URLEncoder.encode(vo.getKtp_no().toUpperCase(), "utf-8"));
				vo.setKtp_no(ktp_no);
			}
			if (!vo.getMobile_no().trim().equals("")) {
				mobile_no = FileCoder.encrypt(URLEncoder.encode(vo.getMobile_no().toUpperCase(), "utf-8"));
				vo.setMobile_no(mobile_no);
			}
            
            // 1. update
         	mapper.update(vo);
         	// 1-1 delete infor
         	if(vo.getAreaList().size() != 0 && !"".equals(vo.getAd_no())){
         		SVMInfoVO voParam = new SVMInfoVO();
         		voParam.setAd_no(vo.getAd_no());
     			switch(vo.getSave_tab_cd()){
    				case "basicInfo": voParam.setArea("'tov','pd'");
    					break;
    				case "gameInfo" : voParam.setArea("'as','oee','lc','see','ls'");
    					break;
    				default : break;
         		}
     			mapper.deleteInfor(voParam);
         		// 1-2 insert infor
         		mapper.insertInfor(vo);
         	}
         	// 1-3. save tab
 			param.setSubmit_yn(submitYn);
 			if("Y".equals(submitYn))
 				param.setSave_tab_cd(vo.getSave_tab_cd());
 			else{
 				svmUserVO.setAd_no(vo.getAd_no());
 				param.setSave_tab_cd(vo.getSave_tab_cd());
 			}
 			param.setEmail(vo.getEmail());
 			userMapper.update(param);
 			svmUserVO.setSave_tab_cd(vo.getSave_tab_cd());
         	
         	// 2. insert photo
         	insertImage(vo, filePhoto, "photo" ,null);
         	
         	// 3. insert facePhoto
         	insertImage(vo, facePhoto, "facePhoto" ,null);
         	
         	// 4. insert bodyPhoto
         	insertImage(vo, bodyPhoto, "bodyPhoto" ,null);

         	// 5. insert passport
         	if("L".equals(vo.getCtry_cd_fg()) && !"".equals(vo.getAd_no()) && "passport".equals(vo.getDel_photo_fg())){
         		deleteImage(vo);
         	}else if("F".equals(vo.getCtry_cd_fg()) && !"".equals(vo.getAd_no())){
         		insertImage(vo, filePassport, "passport" ,null);
         	}
         	
     		// 6. insert skillPhoto
         	if(vo.getDel_photo_fg_arry() != null && !"".equals(vo.getAd_no())){
         		for(int i=0; i<vo.getDel_photo_fg_arry().length; i++){
    				vo.setDel_photo_fg(vo.getDel_photo_fg_arry()[i]);
    				deleteImage(vo);
         		}
         	}
         	if(isImage) insertImage(vo, null, "skillPhoto", skillPhoto);
         	else vo.setMsg("svm.info.msg.succes_register");
			
		} catch(DataAccessException e) {
			throw SiccMessageUtil.getError(e);
		} catch(ClassCastException e) {
			throw SiccMessageUtil.getError(e);
		} catch (NoSuchAlgorithmException e) {
			throw SiccMessageUtil.getError(e);
		} catch (UnsupportedEncodingException e) {
			throw SiccMessageUtil.getError(e);
		} catch (IOException e) {
			throw SiccMessageUtil.getError(e);
		} catch (GeneralSecurityException e) {
			throw SiccMessageUtil.getError(e);
		} catch (SiccException e){
			if(!isImage){
				vo.setMsg("svm.alert.unsupport_image_file");
				vo.setSuccess(false);
				return vo;
			}
			else throw SiccMessageUtil.getError(e);
		} catch (Exception e){
			throw SiccMessageUtil.getError(e);
		}
		return vo;
	}
	
	@Override
	@Transactional(isolation=Isolation.DEFAULT, propagation=Propagation.REQUIRED)
	public int delete(SVMVolVO vo) throws SiccException {
		try{
			SVMVolDAO mapper = sqlSession.getMapper(SVMVolDAO.class);
			
			SVMSiccUserUtil.setDefaultUserInfo(vo);
			
			int cnt = 0;
			// null이 아닐 경우
			if(vo.getChk() != null){
				for(int i=0; i<vo.getChk().length; i++){
					cnt += mapper.delete(vo.getChk_ad_no()[i]);
				}
			}
			
			
			return cnt;
			
		} catch(DataAccessException e) {
			throw SiccMessageUtil.getError(e);
		} catch(ClassCastException e) {
			throw SiccMessageUtil.getError(e);
		} catch (SiccException e){
			throw SiccMessageUtil.getError(e);
		} catch (Exception e){
			throw SiccMessageUtil.getError(e);
		}
	}
	
	// insertImage  
	// 설명 : 	참가자 사진, 여권사본 등록 메소드	
	// 			imageNm - photo/passport/facePhoto/bodyPhoto 
	public void insertImage(SVMVolVO vo, MultipartFile imageFile, String imageNm , List<MultipartFile> multiImage) throws SiccException {
		
		try{
			// ad_no 가 있을 경우에만 실행
			if(vo.getAd_no() != null && !"".equals(vo.getAd_no())){
				// mapper 생성
				SVMPhotoDAO mapper_photo = sqlSession.getMapper(SVMPhotoDAO.class);
				ImageVO imgVo = new ImageVO();
				
				SVMPhotoVO photoVo = new SVMPhotoVO();
				
				if(imageFile == null && multiImage == null) return;
				if("skillPhoto".equals(imageNm) && multiImage != null){
					
					int cnt = 0;
					for(int i=0; i<multiImage.size(); i++){
						if(multiImage.get(i) == null){
							cnt ++;
						}
						else if(multiImage.get(i).isEmpty()){
							cnt ++;
						}else if("".equals(multiImage.get(i).getOriginalFilename().trim())){
							cnt ++;
						}
						if(multiImage.size() == cnt) return;
					}
					
				}
				// 1. Upload Image - create bytes file
				if(imageFile != null){
					if(!"".equals(imageFile.getOriginalFilename())){
						imgVo = imgUpDown.saveImage(uploadPath, imageFile , "passport");
						if(imgVo != null){
							
							vo.setPhoto_flag(imageNm);
							photoVo.setAd_no(vo.getAd_no());
							photoVo.setPhoto(imgVo.getOrigin_file());
							photoVo.setFile_nm(imageFile.getOriginalFilename());
							photoVo.setPhoto_fg(imageNm);
							photoVo.setThumbnail(imgVo.getThumbnail_file());
							photoVo.setUsername(vo.getEmail());
							photoVo.setUser_ip(vo.getUser_ip());
							
							
							// 2. Delete Old Image & Insert New Image 
							if(imageNm.equalsIgnoreCase("photo")){
								mapper_photo.delete(vo.getAd_no(),"photo");
								mapper_photo.insert(photoVo);
							} else if(imageNm.equalsIgnoreCase("passport")){
								mapper_photo.deletePassport(vo.getAd_no(),"passport");
								mapper_photo.insertPassport(photoVo);
							} else if(imageNm.equalsIgnoreCase("facePhoto")){
								mapper_photo.deletePassport(vo.getAd_no(),"facePhoto");
								mapper_photo.insertPassport(photoVo);
							} else if(imageNm.equalsIgnoreCase("bodyPhoto")){
								mapper_photo.deletePassport(vo.getAd_no(),"bodyPhoto");
								mapper_photo.insertPassport(photoVo);
							} 
						}
					}
				} 
				
				if( multiImage != null){
					if(multiImage.size() != 0 ){
						int cnt = 1;
						for (MultipartFile multipartFile : multiImage) {
							if(multipartFile != null){
								if(!multipartFile.isEmpty()){
									if(!"".equals(multipartFile.getOriginalFilename())){
										BufferedImage image = ImageIO.read(multipartFile.getInputStream());
										if(image != null){
											mapper_photo.deletePassport(vo.getAd_no(),"skillPhoto"+cnt);
											imgVo = imgUpDown.saveImage(uploadPath, multipartFile , "skillPhoto");
											vo.setPhoto_flag(imageNm);
											photoVo.setAd_no(vo.getAd_no());
											photoVo.setPhoto(imgVo.getOrigin_file());
											photoVo.setFile_nm(multipartFile.getOriginalFilename());
											photoVo.setPhoto_fg(imageNm + cnt++);
											photoVo.setThumbnail(imgVo.getThumbnail_file());
											photoVo.setUsername(vo.getEmail());
											photoVo.setUser_ip(vo.getUser_ip());
											if(imageNm.equalsIgnoreCase("skillPhoto")){
												mapper_photo.insertPassport(photoVo);
											}
										}
									}else{
										// 파일이름이 "" 로 들어오는경우
										cnt ++;
									}
								}else{
									//파일이 Empty 인경우
									cnt ++;	
								}
							}else{
								//파일이 NULL 인경우
								cnt ++;
							}
						}
						
					}
				}
			}
			
		} catch (NullPointerException e) {
			throw SiccMessageUtil.getError(e);
		} catch (IOException e) {
			throw SiccMessageUtil.getError(e);
		} catch (SiccException e){
			throw SiccMessageUtil.getError(e);
		} catch (Exception e){
			throw SiccMessageUtil.getError(e);
		}
	}
	
	@Override
	@Transactional(isolation=Isolation.DEFAULT, propagation=Propagation.REQUIRED)
	public Map<String, Object> readImage(String Ad_no, String photo_fg, String File_nm) throws SiccException {
		try{
			SVMPhotoDAO mapper = sqlSession.getMapper(SVMPhotoDAO.class);
			Map<String, Object> imgResultMap = new HashMap<String, Object>();
			
			imgResultMap = mapper.read(Ad_no, photo_fg);
			
			
			return imgResultMap;
			
		}catch(DataAccessException e){
			throw SiccMessageUtil.getError(e);
		}catch(ClassCastException e){
			throw SiccMessageUtil.getError(e);
		} catch (SiccException e){
			throw SiccMessageUtil.getError(e);
		} catch (Exception e){
			throw SiccMessageUtil.getError(e);
		}
	}
	
	@Override
	@Transactional(isolation=Isolation.DEFAULT, propagation=Propagation.REQUIRED)
	public void deleteImage(SVMVolVO vo ) throws SiccException {
		try{
			SVMPhotoDAO mapper = sqlSession.getMapper(SVMPhotoDAO.class);
			System.out.println("pattern ##### " + vo.getDel_photo_fg().contains("skillPhoto") );
			
			if(vo.getDel_photo_fg().equalsIgnoreCase("photo")){
				mapper.delete(vo.getAd_no(),"photo");
			}else if(vo.getDel_photo_fg().equalsIgnoreCase("facePhoto")){
				mapper.delete(vo.getAd_no(),vo.getDel_photo_fg());
			}else if(vo.getDel_photo_fg().equalsIgnoreCase("bodyPhoto")){
				mapper.delete(vo.getAd_no(),vo.getDel_photo_fg());
			}
			//else if(vo.getPhoto_fg().equalsIgnoreCase("skillPhoto")){
			else if(vo.getDel_photo_fg().contains("skillPhoto")){
				mapper.delete(vo.getAd_no(),vo.getDel_photo_fg());
			}
			else if(vo.getDel_photo_fg().equalsIgnoreCase("passport")){
				mapper.deletePassport(vo.getAd_no(),vo.getDel_photo_fg());
			}
			return;
			
		}catch(DataAccessException e){
			throw SiccMessageUtil.getError(e);
		}catch(ClassCastException e){
			throw SiccMessageUtil.getError(e);
		} catch (SiccException e){
			throw SiccMessageUtil.getError(e);
		} catch (Exception e){
			throw SiccMessageUtil.getError(e);
		}
	}

	@Override
	@Transactional(isolation=Isolation.DEFAULT, propagation=Propagation.REQUIRED)
	public SVMVolVO insert(SVMVolVO vo, MultipartFile filePhoto,MultipartFile filePassport ,MultipartFile facePhoto ,MultipartFile bodyPhoto ,List<MultipartFile> skillPhoto ,HttpServletRequest req) throws SiccException {
		Boolean isImage = true;
		try {
			HttpSession session = req.getSession();
			SVMVolDAO mapper = sqlSession.getMapper(SVMVolDAO.class);
			SVMUserDAO userMapper = sqlSession.getMapper(SVMUserDAO.class);
			SVMUserVO svmUserVO = (SVMUserVO)session.getAttribute("userInfo");
			SVMUserVO param = new SVMUserVO();
			
			if(!chkImageFile(facePhoto,null,vo)){
				isImage = false;
				throw new SiccException();
			}
			if(!chkImageFile(bodyPhoto,null,vo)){
				isImage = false;
				throw new SiccException();
			}
			if(!chkImageFile(filePhoto,skillPhoto,vo)){
				isImage = false;
				throw new SiccException();
			}
			
			SVMSiccUserUtil.setDefaultUserInfo(vo);
			
			// 1-3. Encryption - Passport Number & KTP Number & Mobile Number 
			String passport_no = "";
			String ktp_no = "";
			String mobile_no = "";
			
			if (!vo.getPassport_no().trim().equals("")) {
				passport_no = FileCoder.encrypt(URLEncoder.encode(vo.getPassport_no().toUpperCase(), "utf-8"));
				vo.setPassport_no(passport_no);
			}
			if (!vo.getKtp_no().trim().equals("")) {
				ktp_no = FileCoder.encrypt(URLEncoder.encode(vo.getKtp_no().toUpperCase(), "utf-8"));
				vo.setKtp_no(ktp_no);
			}
			if (!vo.getMobile_no().trim().equals("")) {
				mobile_no = FileCoder.encrypt(URLEncoder.encode(vo.getMobile_no().toUpperCase(), "utf-8"));
				vo.setMobile_no(mobile_no);
			}
			
			// 1. insert
			
			vo.setOnline_yn("Y");
			vo.setStatus_fg("A");
			String regi_no = "";
			regi_no = mapper.selectRegiNo(vo);
			vo.setRegi_no(regi_no);
			mapper.insert(vo);
			if(vo.getAreaList().size() != 0){
				mapper.insertInfor(vo);
			}
			// 1-1. save tab
			param.setSave_tab_cd(vo.getSave_tab_cd());
			param.setSubmit_yn("N");
			param.setEmail(vo.getEmail());
			userMapper.update(param);
			svmUserVO.setAd_no(vo.getAd_no());
			svmUserVO.setSave_tab_cd(vo.getSave_tab_cd());
			
			// 2. insert photo
			insertImage(vo, filePhoto, "photo" ,null);
			
			// 3. insert facePhoto
         	insertImage(vo, facePhoto, "facePhoto" ,null);
         	
         	// 4. insert bodyPhoto
         	insertImage(vo, bodyPhoto, "bodyPhoto" ,null);
         	
			// 5. insert passport
         	if("F".equals(vo.getCtry_cd_fg())){
         		insertImage(vo, filePassport, "passport" ,null);
         	}
         	
         	// 6. insert skillPhoto
         	insertImage(vo, null, "skillPhoto", skillPhoto);
         	

		} catch(DataAccessException e) {
			throw SiccMessageUtil.getError(e);
		} catch(ClassCastException e) {
			throw SiccMessageUtil.getError(e);
		} catch (NoSuchAlgorithmException e) {
			throw SiccMessageUtil.getError(e);
		} catch (UnsupportedEncodingException e) {
			throw SiccMessageUtil.getError(e);
		} catch (IOException e) {
			throw SiccMessageUtil.getError(e);
		} catch (GeneralSecurityException e) {
			throw SiccMessageUtil.getError(e);
		} catch (SiccException e){
			if(!isImage){
				vo.setMsg("svm.alert.unsupport_image_file");
				vo.setSuccess(false);
				return vo;
			}
			else throw SiccMessageUtil.getError(e);
		} catch (Exception e){
			throw SiccMessageUtil.getError(e);
		}
 		return vo;
 		
	}
	
	@Override
	public SVMVolVO changeAddr(String code_value, String flag) throws SiccException {
		try {
			SVMVolVO vo = new SVMVolVO();
			// SVM Common Code List
			List<ToolsVO> toolsList = new ArrayList<>();
			switch(flag){
				case "provinsi_cd" :
					toolsList.add(new ToolsVO("SVM", "CITY_CD", "CODE_ORDER",code_value));
					break;
				case "city_cd" : 
					toolsList.add(new ToolsVO("SVM", "DISTRICT_CD", "CODE_ORDER",code_value));
					break;
				case "district_cd" : 
					toolsList.add(new ToolsVO("SVM", "VILLAGE_CD", "CODE_ORDER",code_value));
					break;
				default :
					break;
			}
			
			vo.setResult(toolsManager.select(toolsList));
			
			return vo;
			
		} catch(DataAccessException e) {
			throw SiccMessageUtil.getError(e);
		} catch(ClassCastException e) {
			throw SiccMessageUtil.getError(e);
		} catch (SiccException e){
			throw SiccMessageUtil.getError(e);
		} catch (Exception e){
			throw SiccMessageUtil.getError(e);
		}
	}
	
	@Override
	public SVMVolVO changeExperience(String code_value, String nextVal , String nextTargetId) throws SiccException {
		try {
			SVMVolVO vo = new SVMVolVO();
			// SVM Common Code List
			List<ToolsVO> toolsList = new ArrayList<>();
			toolsList.add(new ToolsVO("SVM", "SPORT_EXP_NM", "CODE_ORDER",code_value));
			vo.setResult(toolsManager.select(toolsList));
			vo.setName_cd(nextVal);
			vo.setSearch_fg(nextTargetId);
			return vo;
		} catch(DataAccessException e) {
			throw SiccMessageUtil.getError(e);
		} catch(ClassCastException e) {
			throw SiccMessageUtil.getError(e);
		} catch (SiccException e){
			throw SiccMessageUtil.getError(e);
		} catch (Exception e){
			throw SiccMessageUtil.getError(e);
		}
	}
	
	public boolean chkImageFile(MultipartFile file, List<MultipartFile> fileList, SVMVolVO vo ) throws SiccException {
		Boolean isImage = true;
		BufferedImage image = null;
		try {
			if( fileList != null){
				if(fileList.size() != 0 ){
					for (MultipartFile multipartFile : fileList) {
						if(multipartFile != null){
							if(!multipartFile.isEmpty()){
								if(!"".equals(multipartFile.getOriginalFilename())){
									image = ImageIO.read(multipartFile.getInputStream());
									if(image == null){
										isImage = false;
										return isImage;
							     	}
								}
							}
						}
					}
				}
			}
		
			if(file != null){
				if(file != null){
					if(!"".equals(file.getOriginalFilename())){
						image = ImageIO.read(file.getInputStream());
						if(image == null){
							isImage = false;
							return isImage;
				     	}
					}
				}
			}
		
		} catch (IOException e) {
			throw SiccMessageUtil.getError(e);
		}

		return isImage;
	}

}
