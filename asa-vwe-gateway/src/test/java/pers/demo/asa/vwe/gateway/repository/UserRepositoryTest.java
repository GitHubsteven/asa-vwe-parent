package pers.demo.asa.vwe.gateway.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pers.demo.asa.vwe.gateway.VweGatewayApplication;
import pers.demo.asa.vwe.gateway.model.UserModel;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = VweGatewayApplication.class)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void listAll() {
        final List<UserModel> users = userRepository.findAll();
        users.forEach(System.out::println);
    }
}