package com.example.demo.User;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UserRepoTest {

    private final UserRepo userRepo;

    @Autowired
    public UserRepoTest(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Test
    void itShouldFindUser() {
        User user = new User("a@a.com", "123");

        User savedUser = userRepo.save(user);

        User result = userRepo.findById(savedUser.getId()).orElse(null);

        assertNotNull(result);
    }

    @Test
    void itShouldSaveUser() {

        User user = new User("a@a.com", "123");

        User result = userRepo.save(user);

        assertTrue(result.getId() != null);
    }

    @Test
    void itShouldFindUserByEmail() {
        String email = "a@a.com";
        User user = new User(email, "123");
        userRepo.save(user);

        User result = userRepo.findByEmail(email);

        assertEquals(email, result.getEmail());
        assertNotEquals("b@b.com", result.getEmail());

    }
}