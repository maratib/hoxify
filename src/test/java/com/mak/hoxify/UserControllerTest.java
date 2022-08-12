package com.mak.hoxify;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import com.mak.hoxify.user.User;

// Integration testing
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
// Selected profile for testing
@ActiveProfiles("test")
public class UserControllerTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    /* methodName_condition_expectBehavior */
    @Test
    public void postUser_whenUserIsValid_receiveOK() {
        User user = new User();
        user.setUserName("test-user");
        user.setDisplayName("test-display");
        user.setPassword("Passw0rd");

        ResponseEntity<Object> response = testRestTemplate.postForEntity("/api/v1/users", user, Object.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());

    }

}
