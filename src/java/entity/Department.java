
package entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

/**
 *
 * @author NguyenTrung
 */
@Entity
@NamedQuery(name = "Department.findAll", query = "Select d from Department d")
public class Department implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "dept_id")
    private String deptId;
    
    private String name;
    
    @OneToOne
    @JoinColumn(name = "dept_head", referencedColumnName = "empId")
    private Employee deptHead;

    /**
     * @return the deptId
     */
    public String getDeptId() {
        return deptId;
    }

    /**
     * @param deptId the deptId to set
     */
    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the deptHead
     */
    public Employee getDeptHead() {
        return deptHead;
    }

    /**
     * @param deptHead the deptHead to set
     */
    public void setDeptHead(Employee deptHead) {
        this.deptHead = deptHead;
    }
    
}
