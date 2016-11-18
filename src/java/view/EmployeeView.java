/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import business.DepartmentBean;
import business.EmployeeBean;
import entity.Department;
import entity.Employee;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;

/**
 *
 * @author NguyenTrung
 */
@RequestScoped
@Named
public class EmployeeView {

    @EJB
    EmployeeBean eb;
    @EJB
    DepartmentBean db;

    @Resource(mappedName = "jms/connectionFactory")
    private ConnectionFactory connectionFactory;
    @Resource(mappedName = "jms/warehouseQueue")
    private Queue queue;
    private String name;
    private List<String> depts;
    private String selectedDept;

    public String getSelectedDept() {
        return selectedDept;
    }

    public void setSelectedDept(String selectedDept) {
        this.selectedDept = selectedDept;
    }

    @PostConstruct
    public void init() {
        depts = new ArrayList<>();
        db.findAll().stream().forEach(d -> depts.add(d.getName()));
    }

    public void add() {
        Employee employee = new Employee();
        employee.setName(name);
        Department d = db.findByName(selectedDept);
        employee.setDept(d);
        try (JMSContext jmsCtx = connectionFactory.createContext(JMSContext.AUTO_ACKNOWLEDGE)) {
            JMSProducer producer = jmsCtx.createProducer();
            ObjectMessage obj = jmsCtx.createObjectMessage(employee);
            producer.send(queue, obj);
            producer.send(queue, obj);
            producer.send(queue, obj);

        }
        name = "";
        selectedDept = depts.get(0);
        FacesMessage msg = new FacesMessage("Employee details sent to queue");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getDepts() {
        return depts;
    }

    public void setDepts(List<String> depts) {
        this.depts = depts;
    }

}
