package model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collection;
import java.util.HashSet;

import org.junit.jupiter.api.Test;

import com.dailycodework.lakesidehotel.model.Role;
import com.dailycodework.lakesidehotel.model.User;

class UserTest {

    @Test
    public void testGetFirstName() {
        User user = new User("John", "Doe", "john.doe@example.com", "password", null);
        assertEquals("John", user.getFirstName());
    }

    @Test
    public void testGetLastName() {
        User user = new User("John", "Doe", "john.doe@example.com", "password", null);
        assertEquals("Doe", user.getLastName());
    }

    @Test
    public void testGetEmail() {
        User user = new User("John", "Doe", "john.doe@example.com", "password", null);
        assertEquals("john.doe@example.com", user.getEmail());
    }

    @Test
    public void testGetPassword() {
        User user = new User("John", "Doe", "john.doe@example.com", "password", null);
        assertEquals("password", user.getPassword());
    }

    @Test
    public void testGetRoles() {
        Role role = new Role("ROLE_USER");
        Collection<Role> roles = new HashSet<>();
        roles.add(role);
        User user = new User("John", "Doe", "john.doe@example.com", "password", roles);

        assertEquals(roles, user.getRoles());
    }
}