package com.ponto.users;

import com.ponto.users.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class UsersApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void testUnitario(){
        User classUnderTest = new User();
        assertNotNull(classUnderTest.test());
    }


}
