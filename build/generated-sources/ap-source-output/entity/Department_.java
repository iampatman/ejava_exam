package entity;

import entity.Employee;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-18T14:22:43")
@StaticMetamodel(Department.class)
public class Department_ { 

    public static volatile SingularAttribute<Department, String> deptId;
    public static volatile SingularAttribute<Department, String> name;
    public static volatile SingularAttribute<Department, Employee> deptHead;

}