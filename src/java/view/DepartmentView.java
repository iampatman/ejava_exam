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
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author NguyenTrung
 */
@SessionScoped
@Named
public class DepartmentView implements Serializable {

    @EJB
    EmployeeBean eb;
    @EJB
    DepartmentBean db;
    private List<Department> deptList;
    private List<Employee> employeeList;
    private String selectedDept;
    private List<String> depts;

    @PostConstruct
    public void init() {
        deptList = db.findAll();
        depts = new ArrayList<>();
        deptList.stream().map(d -> d.getName()).forEach(d -> depts.add(d));
        selectedDept = depts.get(0);
    }

    public void changeDept() {
        String deptId = deptList.stream()
                .filter(d -> d.getName().equals(selectedDept))
                .findAny()
                .get()
                .getDeptId();
        employeeList = eb.findEmployeesByDeptID(deptId);
        System.out.println(">>>>>>> employee size: " + employeeList.size());

    }

    public List<String> getDepts() {
        return depts;
    }

    public void setDepts(List<String> depts) {
        this.depts = depts;
    }

    public List<Department> getDeptList() {
        return deptList;
    }

    public void setDeptList(List<Department> deptList) {
        this.deptList = deptList;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public String getSelectedDept() {
        return selectedDept;
    }

    public void setSelectedDept(String selectedDept) {
        this.selectedDept = selectedDept;
    }

}
