package pers.demo.asa.vwe.gateway.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pers.demo.asa.vwe.gateway.VweGatewayApplication;
import pers.demo.asa.vwe.gateway.model.UserModel;

import java.time.LocalDate;
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

    @Test
    public void createUsers() {
        UserModel user = new UserModel();
        user.setUsername("admin");
        user.setEmail("admin123@qq.com");
        user.setHash("adminsfefefefe");
        user.setPassword("admin123");
        user.setRole("admin");
        user.setCreateTime(LocalDate.now());
        user.setCreateTime(LocalDate.now());
        user.setCreator("admin");
        user.setModifier("admin");
        userRepository.save(user);
    }

    @Test
    public void update() {
        UserModel user = new UserModel();
        user.setId("6077b476f58b4125d0038867");
        user.setRole("admin");
        userRepository.save(user);
    }
}