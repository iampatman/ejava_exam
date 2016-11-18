package entity;

import entity.Department;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-18T14:22:43")
@StaticMetamodel(Employee.class)
public class Employee_ { 

    public static volatile SingularAttribute<Employee, Integer> empId;
    public static volatile SingularAttribute<Employee, String> name;
    public static volatile SingularAttribute<Employee, Department> dept;

}