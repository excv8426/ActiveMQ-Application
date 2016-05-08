import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class TestQueue {
	private static final int SEND_NUMBER = 5;
	private static final String ACTIVEMQ_URL="tcp://localhost:61616";
	
	// ConnectionFactory ：连接工厂，JMS 用它创建连接
	private static ConnectionFactory connectionFactory=null;
	// Connection ：JMS 客户端到JMS Provider 的连接
	private static Connection connection = null;
	// Session： 一个发送或接收消息的线程
	private static Session session=null;
	// Destination ：消息的目的地;消息发送给谁.
	private static Destination destination=null;
	private static MessageProducer producer=null;
	
	public static void initSession(){
		connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_USER,ActiveMQConnection.DEFAULT_PASSWORD,ACTIVEMQ_URL);
        try {
			connection = connectionFactory.createConnection();
	        connection.start();
	        session = connection.createSession(true,Session.AUTO_ACKNOWLEDGE);
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

    public static void sendTextMessage() {
    	TextMessage message;
    	try {
			destination = session.createQueue("queue1");
			producer = session.createProducer(destination);
			producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
			
	        for (int i = 1; i <= SEND_NUMBER; i++) {
	        	message = session.createTextMessage("ActiveMq 发送的消息" + i);
	            System.out.println("发送消息：" + "ActiveMq 发送的消息" + i);
	            producer.send(message);
	        }
	        session.commit();
		} catch (JMSException e1) {
			e1.printStackTrace();
		}
    }
    
    public static void closeConnection(){
    	if (connection!=null) {
    		try {
				connection.close();
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}
    }
}
