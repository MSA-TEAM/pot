package kr.co.sicc.gsp.svm.gms.common.sso.serviceprovider.saml.util;

/**
 * An exception class for when there's a problem handling SAML
 * messages.
 */
public class SamlException extends Exception {

	private static final long serialVersionUID = 1L;

	protected String message = "";

	public SamlException() {
	}

	public SamlException(Throwable e) {
		super(e.toString());
	}

	public SamlException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return this.message;
	}

	public String toString() {
		return "SAML exception: " + message;
	}
}