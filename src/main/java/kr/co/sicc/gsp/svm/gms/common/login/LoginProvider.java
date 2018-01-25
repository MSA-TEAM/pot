package kr.co.sicc.gsp.svm.gms.common.login;

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
import org.springframework.security.authentication.dao.SaltSource;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.util.Base64Utils;

@Component
public class LoginProvider implements AuthenticationProvider {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginProvider.class);
	
	@Autowired
	@Resource(name="siccUserService")
	private SiccUserService siccUserService;
	
	// kimjw sso
	//@Resource(name="SICC_SSO")
	@Value("${settings.SICC_SSO}")
	private Boolean SICC_SSO;
	
	public LoginProvider(){
	}

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		try {
			String user_id = authentication.getName();
			String password = (String) authentication.getCredentials();
			UserInfo user;
			Collection<? extends Role> authorities = null;
		    
			user = siccUserService.loadUserByUsername(user_id);

			// kimjw sso
			//권한없음. 체크 변경 -> 크기 체크를 호출하는 곳에서 하도록
			if(!SICC_SSO) {

				if(user.getAuthorities().isEmpty())
					throw new BadCredentialsException("login.access.denied");
				
				byte[] saltByte = Base64Utils.decodeFromString(user.getSalt());
				String saltStr = new String(saltByte);
				
	
				MessageDigest digest = MessageDigest.getInstance("SHA-256");
				String strNewPassword = user_id + password + saltStr;
				
				byte[] bNewPassword = strNewPassword.getBytes("UTF-8");
				digest.update(bNewPassword);
				
				byte[] bOutput = digest.digest();
				
				String comPassword = Base64Utils.encodeToString(bOutput);
				
				//logger.info("username : " + user_id + " / password : " + password + " / hash password : " + comPassword+" / salt : "+saltStr);
		        //logger.info("username : " + user.getUsername() + " / password : " + user.getPassword());
				
				if(!comPassword.equals(user.getPassword())){
					throw new BadCredentialsException("login.password.misspell");
				}
			}
			
			authorities = user.getAuthorities();
			
			UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(user_id, password, authorities);
			token.setDetails(user);
						
			return token;
		} catch(UsernameNotFoundException e) {
			logger.info(e.toString());
			throw new UsernameNotFoundException("login.user.notfound");
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
