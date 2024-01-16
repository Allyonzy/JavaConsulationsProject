
package ru.innopolis.java;

import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;

import org.slf4j.Logger;

public class LoginController {

    static final Logger log = getLogger(lookup().lookupClass());

    public LoginService loginService = new LoginService();

    public String login(UserForm userForm) {
        log.debug("LoginController.login " + userForm);

        try {
            if (userForm == null) {
                return "ERROR";
            } else if (loginService.login(userForm)) {
                return "OK";
            } else {
                return "KO";
            }
        } catch (Exception e) {
            return "ERROR";
        }
    }

    public void logout(UserForm userForm) {
        log.debug("LoginController.logout {}", userForm);

        loginService.logout(userForm);
    }

}
