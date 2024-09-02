package Encryption;

import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.testng.annotations.Test;



public class AESEncryption {
@Test
public void sampleTest() throws Exception, NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException
{
	String privateKey="AcO3tEam@j!tu_#1";
	String data="Thanvik";
	
	 EncryptAndDecryptUtility ed = new EncryptAndDecryptUtility();
	 String encryptedData = ed.encrypt(data, privateKey);
	 System.out.println(encryptedData);
	 
	 String decryptedData =ed.decrypt(encryptedData, privateKey);
	 System.out.println(decryptedData);
	 
}
}
