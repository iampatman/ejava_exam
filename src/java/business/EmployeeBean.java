package business;


import entity.Employee;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


/**
 *
 * @author NguyenTrung
 */
@Stateless
public class EmployeeBean {
    @PersistenceContext EntityManager em;
    
    public List<Employee> findAll(){
        return em.createQuery("Select e from Employee e", Employee.class)
                .getResultList();
    }
    public List<Employee> findEmployeesByDeptID(String deptId){
        return em.createQuery("select e from Employee e where :dept = e.dept.deptId",Employee.class)
                .setParameter("dept", deptId)
                .getResultList();
    }
    public void add(Employee e){
        em.persist(e);
        em.flush();
        System.out.println(">>>>> new id: " + e.getEmpId());
    }
}
