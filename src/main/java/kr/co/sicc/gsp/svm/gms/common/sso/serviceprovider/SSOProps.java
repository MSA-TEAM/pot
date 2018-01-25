package kr.co.sicc.gsp.svm.gms.common.sso.serviceprovider;

import org.springframework.beans.factory.annotation.Value;

public class SSOProps {
	@Value("#{siccProperties['sp.systemCd']}")
	public String spSystemCd;
	@Value("#{siccProperties['sp.providerName']}")
	public String spProviderName;
	@Value("#{siccProperties['sp.logoutUrl']}")
	public String spLogoutUrl;
	@Value("#{siccProperties['sp.acsUrl']}")
	public String spAcsUrl;
	@Value("#{siccProperties['sp.publicKeyFilePath']}")
	public String spPublicKeyFilePath;
	
	@Value("#{siccProperties['ip.idpUrl']}")
	public String ipIdpUrl;
	@Value("#{siccProperties['ip.idpLogoutUrl']}")
	public String ipIdpLogoutUrl;
	@Value("#{siccProperties['ip.domain']}")
	public String ipDomain;
	
}
