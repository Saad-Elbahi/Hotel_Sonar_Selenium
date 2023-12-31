package model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Collection;
import java.util.HashSet;

import org.junit.jupiter.api.Test;

import com.dailycodework.lakesidehotel.model.Role;
import com.dailycodework.lakesidehotel.model.User;

class RoleTest {
    @Test
    public void testAssignRoleToUser() {
        Role role = new Role("ROLE_USER");
        Collection<Role> roles = new HashSet<>();
        roles.add(role);
        User user = new User("John", "Doe", "john.doe@example.com", "password", roles);

        role.assignRoleToUser(user);

        assertTrue(user.getRoles().contains(role));
        assertTrue(role.getUsers().contains(user));
    }

    @Test
    public void testRemoveUserFromRole() {
        Role role = new Role("ROLE_USER");
        Collection<Role> roles = new HashSet<>();
        roles.add(role);
        User user = new User("John", "Doe", "john.doe@example.com", "password", roles);


        role.assignRoleToUser(user);
        role.removeUserFromRole(user);

        assertFalse(user.getRoles().contains(role));
        assertFalse(role.getUsers().contains(user));
    }

    @Test
    public void testRemoveAllUsersFromRole() {
        Role role = new Role("ROLE_USER");
        Collection<Role> roles = new HashSet<>();
        roles.add(role);
        User user1 = new User("John", "Doe", "john.doe@example.com", "password", roles);

        User user2 = new User("John", "Doe", "john.doe@example.com", "password", roles);

        role.assignRoleToUser(user1);
        role.assignRoleToUser(user2);

        role.removeAllUsersFromRole();

        assertTrue(role.getUsers().isEmpty());
        assertTrue(user1.getRoles().isEmpty());
        assertTrue(user2.getRoles().isEmpty());
    }

    @Test
    public void testGetName() {
        Role role = new Role("ROLE_ADMIN");

        assertEquals("ROLE_ADMIN", role.getName());
    }
}