
public class Test {
	public static void main(String[] args){
		TestQueue.initSession();
		TestQueue.sendTextMessage();
		TestQueue.closeConnection();
	}
}
