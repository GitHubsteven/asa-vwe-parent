package pers.demo.asa.vwe.cms.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pers.demo.asa.vwe.cms.VweCmsApplication;
import pers.demo.asa.vwe.cms.model.UserModel;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = VweCmsApplication.class)
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void findByUsername() {
        UserModel test = userRepository.findByUsername("test");
        System.out.println(test.getEmail());
    }

    @Test
    public void findByCreator() {
    }
}
