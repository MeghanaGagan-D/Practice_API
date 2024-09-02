package mockingsolution;

import org.mockito.Mockito;

class PANCard{
	public String isValid(String panCard)
	{
		if(panCard.matches("[A-Z]{5}[0-9]{4}[A-Z]{1}")==true) {
			return "PanCard is valid";
		}
		else {
			return "PanCard is invalid";
		}
	}
	
	public static PANCard getMockObj()
	{
		PANCard mocObj = Mockito.mock(PANCard.class);
			Mockito.when(mocObj.isValid("ABCDE1234H")).thenReturn("valid pan card");
			Mockito.when(mocObj.isValid("ABCDE1234A")).thenReturn("valid pan card");
			Mockito.when(mocObj.isValid("ABCDE1234a")).thenReturn("invalid pan card");
		return mocObj;
	}
}

public class PanCardMockingMockitoTest {
	public static void main(String[] args) {
		PANCard obj = PANCard.getMockObj();
		System.out.println(obj.isValid("ABCDE1234a"));
	}
}
