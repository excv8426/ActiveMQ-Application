
public class Test {
	public static void main(String[] args){
		TestQueue.initSession();
		//TestQueue.sendTextMessage();
		TestQueue.receiveMessage();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		TestQueue.closeConnection();
	}
}
