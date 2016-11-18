package business;

import entity.Department;
import java.util.List;
import java.util.UUID;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author NguyenTrung
 */
@Stateless
public class DepartmentBean {

    @PersistenceContext
    EntityManager em;

    public void add(Department dept) {
        dept.setDeptId(UUID.randomUUID().toString().substring(0, 7));
        em.persist(dept);
    }

    public List<Department> findAll() {
        return em.createNamedQuery("Department.findAll", Department.class)
                .getResultList();
    }

    public Department findByName(String name) {
        return em.createQuery("Select d from Department d where :n = d.name", Department.class)
                .setParameter("n", name)
                .getSingleResult();
    }
}
