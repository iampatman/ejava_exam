/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import entity.Employee;
import java.util.AbstractSet;
import java.util.HashSet;
import java.util.Set;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

/**
 *
 * @author NguyenTrung
 */
@MessageDriven(
        mappedName = "jms/warehouseQueue"
)
public class RegisterBean implements MessageListener {

    @EJB
    private EmployeeBean eb;
    private static Set<Integer> ids = new HashSet<Integer>();

    @Override
    public void onMessage(Message message) {
        try {

            ObjectMessage obj = (ObjectMessage) message;
            Employee em;
            em = (Employee) obj.getObject();
            System.out.println("new message: " + em.toString());
            if (!ids.contains(em.hashCode())) {
                ids.add(em.hashCode());
                System.out.println("hashcode: " + em.hashCode());
                eb.add(em);
            } else {
                System.out.println("Message duplicated");
            }

        } catch (JMSException ex) {
            ex.printStackTrace();
        }
    }

}
