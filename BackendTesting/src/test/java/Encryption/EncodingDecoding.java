package Encryption;

import java.util.Base64;

import org.testng.annotations.Test;

public class EncodingDecoding {
@Test
public void sampleTest()
{
	String encodeData= new String(Base64.getEncoder().encode("rmgyanthra".getBytes()));
	System.out.println(encodeData);
	
	String decodeData= new String(Base64.getDecoder().decode(encodeData.getBytes()));
	System.out.println(decodeData);
}
}

