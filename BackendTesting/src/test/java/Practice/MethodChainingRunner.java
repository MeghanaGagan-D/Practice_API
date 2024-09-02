package Practice;

import org.testng.annotations.Test;

public class MethodChainingRunner {
@Test
public MethodChaining mcr()
{
	MethodChaining m=new MethodChaining();
	System.out.println("mcr");
	return m;
}
@Test
public void run() {
	mcr().m1().m2();
	
}
}
