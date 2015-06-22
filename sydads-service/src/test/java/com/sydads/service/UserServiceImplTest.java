package com.sydads.service;

import com.sydads.data.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: neilmao
 * Date: 22/06/15
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext-mock.xml")
public class UserServiceImplTest {

    private String testingEmail = "1@1.com";
    private String testingPassword = "password";


    @Autowired
    private UserService userService;

    @Test
    public void testRegister() throws Exception {

        User user = userService.register(testingEmail, testingPassword);

        assertNotNull(user);
        assertTrue(userService.checkIfEmailIsUsed(testingEmail));
    }
}
