
package ru.innopolis.java;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class LoginControllerBDDTest {

    @InjectMocks
    LoginController loginController;

    @Mock
    LoginService loginService;

    UserForm userForm;

    @BeforeEach
    void setUp() {
        userForm = new UserForm("NikolasCage", "JGKldf843");
    }

    @Test
    void testLoginOk_willReturnTrue() {
        // Вызываем логин, подставляем форму, задаем что он возвращает true
        given(loginService.login(userForm)).willReturn(true);
        assertEquals("OK", loginController.login(userForm));
    }

    @Test
    void testLoginOk_willReturnFalse() {
        given(loginService.login(userForm)).willReturn(false);
        assertEquals("KO", loginController.login(userForm));
    }

    @Test
    void testLoginError() {
        assertEquals("ERROR", loginController.login(null));
    }

    @Test
    void testLoginException() {
        given(loginService.login(any(UserForm.class)))
                .willThrow(IllegalArgumentException.class);
        assertEquals("ERROR", loginController.login(userForm));
    }

}