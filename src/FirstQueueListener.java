import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

public class FirstQueueListener implements MessageListener {

	@Override
	public void onMessage(Message arg0) {
		try {
			arg0.acknowledge();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("FirstQueue:"+arg0.toString());
		
	}

}
