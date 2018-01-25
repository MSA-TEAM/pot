package kr.co.sicc.gsp.svm.gms.common.sso.serviceprovider.saml.util;

import java.io.IOException;
import java.io.Reader;
import java.security.NoSuchProviderException;
import java.security.PublicKey;

import javax.xml.crypto.MarshalException;
import javax.xml.crypto.dsig.XMLSignature;
import javax.xml.crypto.dsig.XMLSignatureException;
import javax.xml.crypto.dsig.XMLSignatureFactory;
import javax.xml.crypto.dsig.dom.DOMValidateContext;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class SAMLParser {
	
	private XPathFactory xpathFactory = XPathFactory.newInstance();
	private XPath xpath = null;
	
	private DocumentBuilder db = null;
	private InputSource src = null;
	private Document document = null;;
	
	public SAMLParser (Reader reader) throws ParserConfigurationException, SAXException, IOException
	{
		db = createDocumentBuilder();
		xpath = xpathFactory.newXPath();
		src = new InputSource(reader);
		parse();
	}

	
	private DocumentBuilder createDocumentBuilder() throws ParserConfigurationException
	{
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		
		dbFactory.setValidating(false);
		dbFactory.setNamespaceAware(true);
		dbFactory.setIgnoringComments(true);
		dbFactory.setIgnoringElementContentWhitespace(true);
		
		return dbFactory.newDocumentBuilder();
	}
	private void parse() throws IOException, SAXException
	{
		document = db.parse(src);
	}
	
	public String getUserID()
	{
		return getValue("//*[local-name()='Assertion']/*[local-name()='Subject']/*[local-name()='NameID']", XPathConstants.STRING);
	}
	
	public String getUserName()
	{
		return getValue("//*[local-name()='Assertion']/*[local-name()='AttributeStatement']/*[local-name()='Attribute'][@Name='FullName']/*[local-name()='AttributeValue']", XPathConstants.STRING);
	}
	
	public boolean isValid(PublicKey pubKey) throws ParserConfigurationException, NoSuchProviderException, MarshalException, XMLSignatureException
	{
		NodeList nl = document.getElementsByTagNameNS(XMLSignature.XMLNS, "Signature");
		if (nl.getLength() == 0) {
			throw new ParserConfigurationException("Cannot find Signature element");
		}
		XMLSignatureFactory fac = XMLSignatureFactory.getInstance("DOM", "XMLDSig");
		DOMValidateContext valContext = new DOMValidateContext(pubKey, nl.item(0));
		XMLSignature signature = fac.unmarshalXMLSignature(valContext);
		return signature.validate(valContext);
	}
	
	private String getValue(String condition, QName cont)
	{
		try
		{
			return xpath.evaluate(condition, document, cont).toString().trim();
		}
		catch ( XPathExpressionException ex)
		{
			return null;
		}
	}


	public Document getDocument() {
		return document;
	}


	public void setDocument(Document document) {
		this.document = document;
	}
}
