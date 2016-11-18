/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 *
 * @author NguyenTrung
 */
@Entity
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int empId;
    
    private String name;
    @JoinColumn(name = "dept", referencedColumnName = "dept_id")
    @OneToOne private Department dept;

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department getDept() {
        return dept;
    }

    public void setDept(Department dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Employee{" + "empId=" + empId + ", name=" + name + ", dept=" + dept + '}';
    }

    @Override
    public boolean equals(Object obj) {
        Employee e = (Employee) obj;
        if (e.name.equals(this.name) && e.dept != null && e.dept.getDeptId().equals(this.dept.getDeptId()))
            return true;
        else return false;
        
    }

    @Override
    public int hashCode() {
        return name.hashCode() + dept.getDeptId().hashCode();
        //return super.hashCode(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
}
