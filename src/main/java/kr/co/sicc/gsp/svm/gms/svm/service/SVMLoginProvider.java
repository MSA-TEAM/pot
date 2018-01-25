package kr.co.sicc.gsp.svm.gms.svm.service;

import java.security.MessageDigest;
import java.util.Collection;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.util.Base64Utils;

import kr.co.sicc.gsp.svm.gms.common.login.Role;
import kr.co.sicc.gsp.svm.gms.svm.vo.SVMUserVO;
import kr.co.sicc.gsp.svm.sicc.aeschiper.FileCoder;

@Component
public class SVMLoginProvider implements AuthenticationProvider {
	
	private static final Logger logger = LoggerFactory.getLogger(SVMLoginProvider.class);
	
	@Autowired
	@Resource(name="svmSiccUserService")
	private SVMSiccUserService svmSiccUserService;
	
	//@Resource(name="SICC_SSO")
	@Value("${settings.SICC_SSO}")
	private Boolean SICC_SSO;
	
	public SVMLoginProvider(){
	}

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		try {
			String email = authentication.getName();
			String password = (String) authentication.getCredentials();
			SVMUserVO user;
			Collection<? extends Role> authorities = null;
		    
//			if("".equals(email.trim())){
//				throw new UsernameNotFoundException("login.user.notfound");
//			}else if("".equals(password)){
//				throw new UsernameNotFoundException("login.user.notfound");
//			}
			
			user = svmSiccUserService.loadUserByUsername(email);

			if(!SICC_SSO) {

//				if(user.getAuthorities().isEmpty())
//					throw new BadCredentialsException("login.access.denied");
				
				byte[] saltByte = Base64Utils.decodeFromString(user.getSalt());
				//byte[] saltByte = FileCoder.base64ToByte(user.getSalt());
				String saltStr = new String(saltByte);
				
				MessageDigest digest = MessageDigest.getInstance("SHA-256");
				String strNewPassword = email + password + saltStr;
				logger.info("FileCoder.ComputeHash :  "  + FileCoder.ComputeHash(email + password,saltStr ));
				
				byte[] bNewPassword = strNewPassword.getBytes("UTF-8");
				digest.update(bNewPassword);
				
				byte[] bOutput = digest.digest();
				
				String comPassword = Base64Utils.encodeToString(bOutput);
				
//				logger.info("username : " + email + " / password : " + password + " / hash password : " + comPassword+" / salt : "+saltStr);
//		        logger.info("username : " + user.getUsername() + " / password : " + user.getPassword());
				
				if(!comPassword.equals(user.getPassword())){
					throw new BadCredentialsException("svm.message.login_misspell");
				}
			}
			
			authorities = user.getAuthorities();
			
			UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(email, password, authorities);
			token.setDetails(user);
						
			return token;
		} catch(UsernameNotFoundException e) {
			logger.info(e.toString());
			throw new UsernameNotFoundException(e.getMessage());
		} catch(BadCredentialsException e){
			logger.info(e.toString());
			throw new BadCredentialsException(e.getMessage());
		} catch(Exception e) {
			logger.info(e.toString());
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public boolean supports(Class<?> authentication) {
		if(authentication.isAssignableFrom(UsernamePasswordAuthenticationToken.class)){
			return true;
		}
		return false;
	}	
}
