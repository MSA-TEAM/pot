package kr.co.sicc.gsp.svm.gms.svm.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.sicc.gsp.svm.gms.svm.service.SVMVolService;
import kr.co.sicc.gsp.svm.gms.svm.vo.SVMInfoVO;
import kr.co.sicc.gsp.svm.gms.svm.vo.SVMUserVO;
import kr.co.sicc.gsp.svm.gms.svm.vo.SVMVolVO;

//import com.gms.common.login.SiccUserService;
//import com.gms.common.utils.file.CmmFileManager;

import kr.co.sicc.gsp.svm.sicc.common.SiccController;
import kr.co.sicc.gsp.svm.sicc.common.SiccMessageUtil;
import kr.co.sicc.gsp.svm.sicc.constants.MessageConstants;
import kr.co.sicc.gsp.svm.sicc.exception.SiccException;
import kr.co.sicc.gsp.svm.sicc.util.SiccBeanUtils;


/**
 * <pre>	
 * com.gms.svm.controller
 * SVMApplicationController.java
 * Description 	:
 * ?��?��봉사 ?���??��  
 * History     	:
 * </pre>
 *
 * @author	 	: gypark
 * @Date	 	: 2017.07.21
 * @Version 	: 1.0
 *
 */

@Controller
public class SVMApplicationController extends SiccController {
	
//	@Autowired
//	SiccUserService siccUserService;
//	
	@Autowired
	SVMVolService svmVolService;
//	
//	@Autowired
//	CmmFileManager fileUpDown;
	
	@RequestMapping(value="/{lang}/svm/application/{cmd}")
	public String application(
			Locale locale, 
			Model model, 
			@PathVariable String lang, 
			@PathVariable String cmd, 
			HttpSession session,
			@ModelAttribute("svmVolVo") SVMVolVO vo,
			@ModelAttribute("svmUserVo") SVMUserVO svmUserVo,
			@ModelAttribute("moveTo") String moveTo,
			RedirectAttributes redirectAttr
			) throws SiccException{
		
		SVMVolVO svmVolVo = new SVMVolVO();
		String viewTab = "";
		try{
			SiccBeanUtils.copyProperties(svmVolVo, vo, model);
			
	        if (!"application".equals(cmd) && (SVMUserVO) session.getAttribute("userInfo") == null) {
	            return "redirect:/login";
	        }else{
	        	svmUserVo = (SVMUserVO) session.getAttribute("userInfo");
	        	if((SVMUserVO) session.getAttribute("userInfo") != null){
	        		svmVolVo.setEmail(svmUserVo.getEmail());
	        		svmVolVo.setAd_no(svmUserVo.getAd_no());
	        	}
	        	if(!"".equals(moveTo)){
	        		if(!moveTo.equals("save")) viewTab = cmd;
	        	}else if(svmUserVo != null && !"application".equals(cmd)){
	        		viewTab = "".equals(svmUserVo.getSave_tab_cd())?"basicInfo":svmUserVo.getSave_tab_cd();
	        		if("Y".equals(svmUserVo.getSubmit_yn())){
	        			viewTab = "finishInfo_basic";
	        		}else if("".equals(moveTo)){
	        			cmd = viewTab;
	        		}
	        	}
	        }
	        
	        if((SVMUserVO) session.getAttribute("userInfo") != null){
	        	if("Y".equals(svmUserVo.getSubmit_yn())){
	        			if(moveTo.matches("^Info$") || "".equals(moveTo)){
	        			moveTo = "finishInfo_basic";
	        			cmd = moveTo;
	        		}
	        	}
	        }
	        
	        
			switch(cmd){
				case "application":
					//session.invalidate();
					session.removeAttribute("userInfo"); 
					svmVolVo.setForwardUrl("/svm/application/application");
					model.addAttribute("svmVolVo", svmVolVo);	
					break;
				case "basicInfo":
					svmVolVo = svmVolService.input(svmVolVo,cmd);
					svmVolVo.setForwardUrl("/svm/application/basicInfo");
					model.addAttribute("svmVolVo", svmVolVo);	
					break;
				case "uploadPhoto":
					svmVolVo = svmVolService.input(svmVolVo,cmd);
					svmVolVo.setForwardUrl("/svm/application/uploadPhoto");
					model.addAttribute("svmVolVo", svmVolVo);
					model.addAttribute("svmUserVO", svmUserVo);
					break;
				case "gameInfo":
					svmVolVo = svmVolService.input(svmVolVo,cmd);
					svmVolVo.setForwardUrl("/svm/application/gameInfo");
//					List<SVMInfoVO> areaList_ = svmVolVo.getAreaList();
//					for(int i=0; i<areaList_.size(); i++){
//						areaList_.get(i).setDescription(GMSXssUtil.escapeXml(areaList_.get(i).getDescription()));
//					}
					model.addAttribute("svmVolVo", svmVolVo);
					//model.addAttribute("svmUserVO", svmUserVo);
					break;
				case "finishInfo_basic":
					svmVolVo = svmVolService.input(svmVolVo,cmd);
					svmVolVo.setForwardUrl("/svm/application/finishRegistration_basic");
					model.addAttribute("svmVolVo", svmVolVo);	
					break;
				case "finishInfo_photo":
					svmVolVo = svmVolService.input(svmVolVo,cmd);
					svmVolVo.setForwardUrl("/svm/application/finishRegistration_photo");
					model.addAttribute("svmVolVo", svmVolVo);	
					break;
				case "finishInfo_game":
					svmVolVo = svmVolService.input(svmVolVo,cmd);
					svmVolVo.setForwardUrl("/svm/application/finishRegistration_game");
					model.addAttribute("svmVolVo", svmVolVo);	
					break;
				default :
					break;
			}
		}catch(SiccException e){
			logger.debug("SiccException", e);
			SiccMessageUtil.saveError(svmVolVo, getMessage(e.getCode(), locale), MessageConstants.SHOW_TYPE_POPUP);
			return svmVolVo.getError_url();
		}catch (Exception e){
			return svmVolVo.getError_url();
		}
		
		return svmVolVo.getUrl();
	}
	
	@RequestMapping(value = "/{lang}/svm/application/downloadImage")
	public void downloadImage(
			Locale locale, 
			Model model, 
			@PathVariable String lang,
			HttpServletResponse response,
			@ModelAttribute("photo_fg") String photo_fg,
			@ModelAttribute("downFile_nm") String File_nm,
			@ModelAttribute("svmVolVo") SVMVolVO vo ) {
			
		
		byte[] file = (byte[])svmVolService.readImage(vo.getAd_no(), photo_fg, File_nm).get("PHOTO");
		ByteArrayInputStream is = new ByteArrayInputStream(file);
		
		try {			
			if(photo_fg == "passport")
				response.setContentType("application/pdf");
			else
				response.setContentType("image/png");
			
	        response.setHeader("Content-Disposition", "attachment; filename="+File_nm); 
	        IOUtils.copy(is, response.getOutputStream());
	        response.flushBuffer();
	    } catch(IOException e) {
	    	throw new SiccException(e);
	    } catch (Exception e){
	    	throw new SiccException(e);
		}
//		finally {
//			try {
//				if(is != null){
//					is.close();
//				}
//			} catch (IOException e) {
//				throw new SiccException(e);
//			}
//		}
	}
	
	@RequestMapping(value="/{lang}/svm/applicationImage/{cmd}")
	@ResponseBody
	public SVMVolVO applicationImage(
			Locale locale, 
			Model model, 
			@PathVariable String lang, 
			@PathVariable String cmd, 
			@ModelAttribute("svmVolVo") SVMVolVO vo) throws SiccException{
		
		SVMVolVO svmVolVo = new SVMVolVO();
		try{
			SiccBeanUtils.copyProperties(svmVolVo, vo, model);
			
			switch(cmd){
				case "deleteImage":
					svmVolService.deleteImage(svmVolVo);
					model.addAttribute("svmVolVo", svmVolVo);
					break;
				default:
					break;
			}	
			
		} catch(SiccException e){
			logger.debug("SiccException", e);
			SiccMessageUtil.saveError(svmVolVo, getMessage(e.getCode(), locale), MessageConstants.SHOW_TYPE_POPUP);
		}
		return svmVolVo;
	}
	
	@RequestMapping(value="/{lang}/svm/application/applicationRegister/{cmd}", method = RequestMethod.POST ,  headers = {"content-type=multipart/form-data"} , produces ="multipart/form-data;charset=UTF-8" ,consumes = {"multipart/mixed", "multipart/form-data"} )
	public String applicationRegister(
			Locale locale, 
			Model model, 
			@PathVariable String lang, 
			@PathVariable String cmd, 
			@ModelAttribute("svmVolVo") SVMVolVO vo,
			HttpServletResponse res, HttpServletRequest req, HttpSession session, 
			RedirectAttributes redirectAttr,
			@RequestParam(value = "file_photo", required = false) MultipartFile filePhoto,
			@RequestParam(value = "bodyPhoto", required = false) MultipartFile bodyPhoto,
			@RequestParam(value = "facePhoto", required = false) MultipartFile facePhoto,
			@ModelAttribute("svmInfoVo") SVMInfoVO skillPhotoVo,
			@RequestParam(value = "file_passport", required = false) MultipartFile filePassport,
			@RequestParam(value = "save_tab_cd", required = false) String save_tab_cd,
			@RequestParam(value = "moveTo", required = true) String moveTo
			) throws SiccException, UnsupportedEncodingException{
		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("UTF-8");
		session = req.getSession();
		SVMUserVO svmUserVO = (SVMUserVO)session.getAttribute("userInfo");
		SVMVolVO svmVolVo = new SVMVolVO();
		String[] hold_keys = new String[]{"ad_no", "cmd"};
		String[] appTab = new String[]{"basicInfo", "uploadPhoto", "gameInfo" , "finishInfo_basic" , "finishInfo_game" , "finishInfo_photo"};
		String moveTab = "";
		try{
			SiccBeanUtils.copyProperties(svmVolVo, vo, model);
			
			if(!("Y".equals(svmUserVO.getSubmit_yn()) && (cmd.equals("insert") || cmd.equals("update")))){
				//?���? & ?��?�� 진입?��
				for(int i=0; i<appTab.length; i++){
					if(appTab[i].equals(save_tab_cd)){
						if("save".equals(moveTo)) moveTab = appTab[i];
						else if("next".equals(moveTo)){
							moveTab = appTab[i+1];
						}
						else if("pre".equals(moveTo)) moveTab = appTab[i-1];
						else if("register".equals(moveTo)){ 
							svmUserVO.setSubmit_yn("Y");
							cmd = moveTo;
						}
						else svmUserVO.setSubmit_yn("N");
						svmVolVo.setSave_tab_cd(save_tab_cd);
					}
				}
			}else if("Y".equals(svmUserVO.getSubmit_yn()) && !"".equals(moveTo) ){
				moveTab = moveTo;
			}
			
			logger.debug("moveTab >>> " + moveTab);
			switch(cmd){
				case "insert":
					svmVolVo = svmVolService.insert(svmVolVo, filePhoto, filePassport , facePhoto , bodyPhoto ,skillPhotoVo.getSkillPhoto(), req);

					svmVolVo.setCmd("edit"); 
					svmVolVo.setRedirectUrl("/svm/application/"+moveTab, lang);
					if(!"".equals(svmVolVo.getMsg()) && !svmVolVo.isSuccess()){
						SiccMessageUtil.saveSuccess(redirectAttr, getMessage(svmVolVo.getMsg(),null, locale), MessageConstants.SHOW_TYPE_POPUP);
					}else{
						SiccMessageUtil.saveSuccess(redirectAttr, getMessage("svm.message.succ_save",null, locale), MessageConstants.SHOW_TYPE_POPUP);
					}
					redirectAttr.addFlashAttribute("svmVolVo", svmVolVo);
					redirectAttr.addFlashAttribute("moveTo", moveTo);
					break;
				case "update":
					svmVolVo = svmVolService.update(svmVolVo, filePhoto, filePassport , facePhoto , bodyPhoto , skillPhotoVo.getSkillPhoto(), req);
					if(!"".equals(svmVolVo.getMsg()) && !svmVolVo.isSuccess()){
						SiccMessageUtil.saveSuccess(redirectAttr, getMessage(svmVolVo.getMsg(),null, locale), MessageConstants.SHOW_TYPE_POPUP);
					}else{
						if("save".equals(moveTo) || "next".equals(moveTo)) SiccMessageUtil.saveSuccess(redirectAttr, getMessage("svm.message.succ_save",null, locale), MessageConstants.SHOW_TYPE_POPUP);
					}
					if(!svmVolVo.isSuccess()){
						svmVolVo.setRedirectUrl("/svm/application/"+save_tab_cd, lang);
					}else {
						svmVolVo.setRedirectUrl("/svm/application/"+moveTab, lang);
					}
					svmVolVo.setCmd("edit");
					redirectAttr.addFlashAttribute("svmVolVo", svmVolVo);
					redirectAttr.addFlashAttribute("moveTo", moveTo);
					break;
				case "register":
					svmVolVo = svmVolService.update(svmVolVo, filePhoto, filePassport , facePhoto , bodyPhoto , skillPhotoVo.getSkillPhoto(), req);
					if(!"".equals(svmVolVo.getMsg()) && !svmVolVo.isSuccess()){
						SiccMessageUtil.saveSuccess(redirectAttr, getMessage(svmVolVo.getMsg(),null, locale), MessageConstants.SHOW_TYPE_POPUP);
					}else{
						SiccMessageUtil.saveSuccess(redirectAttr, getMessage("svm.info.msg.succes_register",null, locale), MessageConstants.SHOW_TYPE_POPUP);
					}
					svmVolVo.setRedirectUrl("/svm/application/finishInfo_photo", lang);
					redirectAttr.addFlashAttribute("svmVolVo", svmVolVo);
					redirectAttr.addFlashAttribute("moveTo", moveTo);
					break;
					
				default:
					svmVolVo.setRedirectUrl("/svm/application/"+moveTab, lang);
					redirectAttr.addFlashAttribute("svmVolVo", svmVolVo);
					redirectAttr.addFlashAttribute("moveTo", moveTo);
					break;
			}

		}catch(SiccException e){
			logger.debug("SiccException", e);
			SiccMessageUtil.saveError(svmVolVo, getMessage(e.getCode(), locale), MessageConstants.SHOW_TYPE_POPUP);
			return svmVolVo.getError_url();
		}catch(Exception e){
			return svmVolVo.getError_url();
		}
		
		return svmVolVo.getUrl();
	}
	
	@RequestMapping(value="/svm/changeAddr")
	@ResponseBody
	public SVMVolVO changeAddr(
			Locale locale, 
			Model model, 
			HttpSession session,
			HttpServletRequest request,
			@ModelAttribute("svmVolVo") SVMVolVO vo,
			@ModelAttribute("flag") String flag,
			@ModelAttribute("code_value") String code_value
			) throws SiccException{
		try{
			vo = svmVolService.changeAddr(code_value,flag);
		}catch(SiccException e){
			logger.debug("SiccException", e);
			SiccMessageUtil.saveError(vo, getMessage(e.getCode(), locale), MessageConstants.SHOW_TYPE_POPUP);
			return vo;
		}
		return vo;
	}
	
	@RequestMapping(value="/svm/changeExperience")
	@ResponseBody
	public SVMVolVO changeExperience(
			Locale locale, 
			Model model, 
			HttpSession session,
			HttpServletRequest request,
			@ModelAttribute("svmVolVo") SVMVolVO vo,
			@ModelAttribute("flag") String flag,
			@ModelAttribute("nextTargetId") String nextTargetId,
			@ModelAttribute("code_value") String code_value
			) throws SiccException{
		try{
			vo = svmVolService.changeExperience(code_value,flag,nextTargetId);
		}catch(SiccException e){
			logger.debug("SiccException", e);
			SiccMessageUtil.saveError(vo, getMessage(e.getCode(), locale), MessageConstants.SHOW_TYPE_POPUP);
			return vo;
		}catch(Exception e){
			SiccMessageUtil.saveError(vo, "Exception", MessageConstants.SHOW_TYPE_POPUP);
			return vo;
		}
		return vo;
	}
}
