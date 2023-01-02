package jee.ejb.mdb;

import javax.ejb.ActivationConfigProperty;
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
public class departmentB implements MessageListener {

    /**
     * Default constructor. 
     */
    public departmentB() {
        // TODO Auto-generated constructor stub
    }
	
	/**
     * @see MessageListener#onMessage(Message)
     */
    public void onMessage(Message inMessage) {
        // TODO Auto-generated method stub
    	TextMessage msg = null;
        try {
            if (inMessage instanceof TextMessage) {
            	 msg = (TextMessage) inMessage;
                 System.out.println("����B��Ϣ����Bean:���յ�����Ϣ " + msg.getText());
                 String[] split_arr = msg.getText().split("#");
                 String testlist=split_arr[0];
                 String state=split_arr[1];
                 if(state.equals("positive")){
                 	String[] testno_arr=testlist.split(",");
                     for(int i=0;i<testno_arr.length;i++){
                 	  System.out.println("B���ž��棺�Թܱ��"+testno_arr[i]+"������������");
                     }
                 }
            } else {
                System.out.println("��Ϣ�����Ͳ���ȷ�� " + inMessage.getClass().getName());
            }
        } catch (JMSException e) {
            e.printStackTrace();
        } catch (Throwable te) {
            te.printStackTrace();
        }
    }

}
