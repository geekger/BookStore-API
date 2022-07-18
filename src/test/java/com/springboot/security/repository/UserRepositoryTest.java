package com.springboot.security.repository;


import com.springboot.security.entity.Role;
import com.springboot.security.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Rollback;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    public void testCreateUser() {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = "password";
        String encodedpassword = passwordEncoder.encode(password);

        User user = new User("user@hotmail.com", encodedpassword);
        User savedUser = userRepository.save(user);

        assertThat(savedUser).isNotNull();
        assertThat(savedUser.getId()).isGreaterThan(0);

    }

    @Test
    public void testAssignRoleToUser() {
        Integer userId = 3;
        Integer roleId = 3;
        User user = userRepository.findById(userId).get();
        user.addRole(new Role(roleId));

        User updatedUser = userRepository.save(user);


    }
}