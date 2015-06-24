package com.sydads.service;

import com.sydads.data.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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

        Assert.assertNotNull(user);
        Assert.assertTrue(userService.checkIfEmailIsUsed(testingEmail));
    }
}
