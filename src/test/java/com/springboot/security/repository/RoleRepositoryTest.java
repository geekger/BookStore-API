package com.springboot.security.repository;

import com.springboot.security.entity.Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class RoleRepositoryTest {

    @Autowired
    private RoleRepository roleRepository;

    @Test
    public void testCreateRoles(){
        Role admin = new Role("ROLE_ADMIN");
        Role editor = new Role("ROLE_EDITOR");
        Role user = new Role("ROLE_USER");

        roleRepository.saveAll(List.of(admin,editor,user));

        long numofRoles = roleRepository.count();
        assertEquals(3, numofRoles);
    }

}
