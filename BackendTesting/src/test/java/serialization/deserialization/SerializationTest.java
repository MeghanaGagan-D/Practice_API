package serialization.deserialization;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class NFSGame implements Serializable

{
	String name;
	int level;
	long score;
	int life;
	
	public NFSGame(String name, int level, long score, int life)
	{
		this.name=name;
		this.level=level;
		this.score=score;
		this.life=life;
	}
}

public class SerializationTest {
public static void main(String[] args) throws Exception {
	NFSGame userObj= new NFSGame("Meghana", 2, 60000,10);
	FileOutputStream fileOut= new FileOutputStream("./f.txt");
	ObjectOutputStream objOut= new ObjectOutputStream(fileOut);
	objOut.writeObject(userObj);
	System.out.println("end");
}
	

}
