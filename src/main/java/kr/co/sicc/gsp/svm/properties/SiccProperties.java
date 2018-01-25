package kr.co.sicc.gsp.svm.properties;

import java.util.Properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "sp")
public class SiccProperties extends Properties{

    private String systemCd;
    private String providerName;
    private String mainRedirect;
    private String createUrl;
    private String logoutcreateUrl;
    private String logoutUrl;
    private String acsUrl;
    private String publicKeyFilePath;
    
    // ip
    private String idpUrl;
    private String idpLogoutUrl;
    private String editUser;
    private String idpSessionStatusUrl;    
    private String domain;
    //private String DR;
    
    //saml
    private String secret;
    
    
	public String getSystemCd() {
		return systemCd;
	}
	public void setSystemCd(String systemCd) {
		this.systemCd = systemCd;
	}
	public String getProviderName() {
		return providerName;
	}
	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}
	public String getMainRedirect() {
		return mainRedirect;
	}
	public void setMainRedirect(String mainRedirect) {
		this.mainRedirect = mainRedirect;
	}
	public String getCreateUrl() {
		return createUrl;
	}
	public void setCreateUrl(String createUrl) {
		this.createUrl = createUrl;
	}
	public String getLogoutcreateUrl() {
		return logoutcreateUrl;
	}
	public void setLogoutcreateUrl(String logoutcreateUrl) {
		this.logoutcreateUrl = logoutcreateUrl;
	}
	public String getLogoutUrl() {
		return logoutUrl;
	}
	public void setLogoutUrl(String logoutUrl) {
		this.logoutUrl = logoutUrl;
	}
	public String getAcsUrl() {
		return acsUrl;
	}
	public void setAcsUrl(String acsUrl) {
		this.acsUrl = acsUrl;
	}
	public String getPublicKeyFilePath() {
		return publicKeyFilePath;
	}
	public void setPublicKeyFilePath(String publicKeyFilePath) {
		this.publicKeyFilePath = publicKeyFilePath;
	}
	public String getIdpUrl() {
		return idpUrl;
	}
	public void setIdpUrl(String idpUrl) {
		this.idpUrl = idpUrl;
	}
	public String getIdpLogoutUrl() {
		return idpLogoutUrl;
	}
	public void setIdpLogoutUrl(String idpLogoutUrl) {
		this.idpLogoutUrl = idpLogoutUrl;
	}
	public String getEditUser() {
		return editUser;
	}
	public void setEditUser(String editUser) {
		this.editUser = editUser;
	}
	public String getIdpSessionStatusUrl() {
		return idpSessionStatusUrl;
	}
	public void setIdpSessionStatusUrl(String idpSessionStatusUrl) {
		this.idpSessionStatusUrl = idpSessionStatusUrl;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public String getSecret() {
		return secret;
	}
	public void setSecret(String secret) {
		this.secret = secret;
	}

	
    
}


