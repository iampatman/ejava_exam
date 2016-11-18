
package view;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author NguyenTrung
 */
@RequestScoped
@Named(value = "newUser")
public class UserView {
    private String login;
    private String email;
    private String gender;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    
    
    
}
