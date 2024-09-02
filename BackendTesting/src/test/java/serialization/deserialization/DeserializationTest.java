package serialization.deserialization;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class DeserializationTest {
public static void main(String[] args) throws Exception {
	FileInputStream fileIn= new FileInputStream("./f.txt");
	ObjectInputStream objIn= new ObjectInputStream(fileIn);
	NFSGame userObj=(NFSGame) objIn.readObject();
	System.out.println("convertoin from txt--->>javaObject");
	System.out.println(userObj.name);
	System.out.println(userObj.level);
	System.out.println(userObj.score);
	System.out.println(userObj.life);
}
}
