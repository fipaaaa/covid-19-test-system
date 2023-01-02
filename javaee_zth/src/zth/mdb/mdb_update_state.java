package zth.mdb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Message-Driven Bean implementation class for: mdb_update_state
 */
@MessageDriven(
		activationConfig = { @ActivationConfigProperty(
				propertyName = "destinationType", propertyValue = "javax.jms.Topic"),
		  @ActivationConfigProperty(propertyName = "destination", propertyValue = "topic/test")
		})
public class mdb_update_state implements MessageListener {

    /**
     * Default constructor. 
     */
    public mdb_update_state() {
        // TODO Auto-generated constructor stub
    }
	
	/**
     * @see MessageListener#onMessage(Message)
     */
    @EJB
    private zth.biz.nointerface_sessonbean_upload_biz getsource;
    public void onMessage(Message inMessage) {
        // TODO Auto-generated method stub
    	TextMessage msg = null;
        try {
            if (inMessage instanceof TextMessage) {
                msg = (TextMessage) inMessage;
                System.out.println("zth消息驱动Bean:接收到的消息 " + msg.getText());
                String[] split_arr = msg.getText().split("#");
                String testlist=split_arr[0];
                String state=split_arr[1];
                String[] testno_arr=testlist.split(",");
                for(int i=0;i<testno_arr.length;i++){
                	getsource.upload_result(testno_arr[i], state);
                	System.out.println(testno_arr[i]);
                }
            } else {
                System.out.println("消息的类型不正确： " + inMessage.getClass().getName());
            }
        } catch (JMSException e) {
            e.printStackTrace();
        } catch (Throwable te) {
            te.printStackTrace();
        }
    }

}
