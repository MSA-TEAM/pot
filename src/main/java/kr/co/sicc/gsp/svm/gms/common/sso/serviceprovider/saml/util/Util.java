package kr.co.sicc.gsp.svm.gms.common.sso.serviceprovider.saml.util;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.zip.InflaterInputStream;

import org.apache.tomcat.util.codec.binary.Base64;


public class Util {

	private static Random random = new Random();
	private static final char[] charMapping = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p' };

	public static String readFileContents(String path) throws SamlException {
		StringBuilder contents = new StringBuilder();
		BufferedReader input = null;
		try {
			input = new BufferedReader(new FileReader(new File(path)));
			String line = null;
			while ((line = input.readLine()) != null) {
				contents.append(line);
			}
			input.close();
			return contents.toString();
		} catch (FileNotFoundException e) {
			throw new SamlException("File not found: " + path);
		} catch (IOException e) {
			throw new SamlException("Error reading file: " + path);
		}
	}

	public static PublicKey getPublicKey(String publicKeyFilepath, String algorithm) throws SamlException {
		try {
			InputStream pubKey = null;
			// 파일 찾는 순서 변경
			try {
				pubKey = new FileInputStream(publicKeyFilepath);
			} catch(FileNotFoundException e) {
				URL url = new URL(publicKeyFilepath);
				pubKey = url.openStream();
			}
			byte[] bytes = new byte[pubKey.available()];
			pubKey.read(bytes);
			pubKey.close();
			X509EncodedKeySpec pubSpec = new X509EncodedKeySpec(bytes);
			KeyFactory factory = KeyFactory.getInstance(algorithm);
			return factory.generatePublic(pubSpec);
		} catch (FileNotFoundException e) {
			throw new SamlException("ERROR: Public key file not found - "
					+ publicKeyFilepath);
		} catch (IOException e) {
			throw new SamlException("ERROR: Invalid public key file - "
					+ e.getMessage());
		} catch (NoSuchAlgorithmException e) {
			throw new SamlException("ERROR: Invalid public key algorithm - "
					+ e.getMessage());
		} catch (InvalidKeySpecException e) {
			throw new SamlException("ERROR: Invalid public key spec - "
					+ e.getMessage());
		}
	}

	public static PrivateKey getPrivateKey(String privateKeyFilepath, String algorithm) throws SamlException {
		try {
			InputStream privKey = null;	
			try {
				URL url = new URL(privateKeyFilepath);
				privKey = url.openStream();
			} catch (MalformedURLException e) {
//				log.error("MalformedURLException - " + e);
				privKey = new FileInputStream(privateKeyFilepath);
			}				
			byte[] bytes = new byte[privKey.available()];
			privKey.read(bytes);
			privKey.close();
			PKCS8EncodedKeySpec privSpec = new PKCS8EncodedKeySpec(bytes);
			KeyFactory factory = KeyFactory.getInstance(algorithm);
			return factory.generatePrivate(privSpec);
		} catch (FileNotFoundException e) {
			throw new SamlException("ERROR: Private key file not found - "
					+ privateKeyFilepath);
		} catch (IOException e) {
			throw new SamlException("ERROR: Invalid private key file - "
					+ e.getMessage());
		} catch (NoSuchAlgorithmException e) {
			throw new SamlException("ERROR: Invalid private key algorithm - "
					+ e.getMessage());
		} catch (InvalidKeySpecException e) {
			throw new SamlException("ERROR: Invalid private key spec - "
					+ e.getMessage());
		}
	}

	public static String createID() {
		byte[] bytes = new byte[20]; // 160 bits
		random.nextBytes(bytes);

		char[] chars = new char[40];

		for (int i = 0; i < bytes.length; i++) {
			int left = (bytes[i] >> 4) & 0x0f;
			int right = bytes[i] & 0x0f;
			chars[i * 2] = charMapping[left];
			chars[i * 2 + 1] = charMapping[right];
		}

		return String.valueOf(chars);
	}

	public static String getDateAndTime() {
		SimpleDateFormat dayFormat = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");

		Date date = new Date();
		return dayFormat.format(date) + 'T' + timeFormat.format(date) + 'Z';
	}
	
	public static ByteArrayOutputStream decodeRequestXML(String msg) throws SamlException
	{
		Base64 base64Decoder = new Base64();
		try
		{
			byte[] decodedBytes = base64Decoder.decode(msg.getBytes("UTF-8"));
			
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			InflaterInputStream inflaterIn = new InflaterInputStream(new ByteArrayInputStream(decodedBytes));
			byte[] buf = new byte[1024];
			int size =0;
			try{
				while ( (size = inflaterIn.read(buf, 0, 1024)) > -1  )
				{
					out.write(buf, 0, size);
				}
			}catch(IOException ex){
				out.write(decodedBytes);
				return out;
			}finally{
				inflaterIn.close();
			}
			return out;
		}
		catch ( UnsupportedEncodingException ex )
		{
			throw new SamlException("Error decoding AuthnRequest: Check decoding scheme - " + ex.getMessage());
		}
		catch ( IOException e )
		{
			throw new SamlException("Error decoding AuthnRequest: Check decoding scheme - " + e.getMessage());
		}
		
	}
	
	public static String createLogoutRequest(String returnURL, String providerName, String userId){
		StringBuilder logoutRequest = new StringBuilder();
		logoutRequest.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?><saml2p:LogoutRequest xmlns:saml2p=\"urn:oasis:names:tc:SAML:2.0:protocol\" ID=\"")
			.append(userId)
			.append("\" IssueInstant=\"")
			.append(Util.getDateAndTime())
			.append("\" Version=\"2.0\" ProtocolBinding=\"urn:oasis:names.tc:SAML:2.0:bindings:HTTP-Redirect\" ProviderName=\"")
			.append(providerName)
			.append("\" AssertionConsumerServiceURL=\"")
			.append(returnURL)
			.append("\"></saml2p:LogoutRequest>");
		return logoutRequest.toString();
	} 
	
	public static String createAuthnRequest(String acsUrl, String providerName){
		StringBuilder authnRequestXML = new StringBuilder();
		authnRequestXML.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?><samlp:AuthnRequest xmlns:samlp=\"urn:oasis:names:tc:SAML:2.0:protocol\" ID=\"")
			.append(createID())
			.append("\" IssueInstant=\"")
			.append(Util.getDateAndTime())
			.append("\" Version=\"2.0\" ProtocolBinding=\"urn:oasis:names.tc:SAML:2.0:bindings:HTTP-Redirect\" ProviderName=\"")
			.append(providerName)
			.append("\" AssertionConsumerServiceURL=\"")
			.append(acsUrl)
			.append("\"/>");
		return authnRequestXML.toString();
	} 
}