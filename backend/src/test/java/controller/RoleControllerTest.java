package controller ;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.dailycodework.lakesidehotel.controller.RoleController;
import com.dailycodework.lakesidehotel.exception.RoleAlreadyExistException;
import com.dailycodework.lakesidehotel.model.Role;
import com.dailycodework.lakesidehotel.model.User;
import com.dailycodework.lakesidehotel.service.IRoleService;

class RoleControllerTest {

    @Mock
    private IRoleService roleService;

    @InjectMocks
    private RoleController roleController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllRoles_ReturnsFound() {
        // Arrange
        List<Role> roles = new ArrayList<>(); // Populate with test data
        when(roleService.getRoles()).thenReturn(roles);

        // Act
        ResponseEntity<List<Role>> responseEntity = roleController.getAllRoles();

        // Assert
        assertEquals(ResponseEntity.status(HttpStatus.FOUND).body(new ArrayList<>()), responseEntity); // Adjust the expected result based on your test data
        verify(roleService, times(1)).getRoles();
    }

 
    @Test
    void deleteRole_ValidRoleId_CallsService() {
        // Arrange
        Long roleId = 1L; // Set valid role ID
        doNothing().when(roleService).deleteRole(roleId);

        // Act
        roleController.deleteRole(roleId);

        // Assert
        verify(roleService, times(1)).deleteRole(roleId);
    }

    @Test
    void removeAllUsersFromRole_ValidRoleId_CallsService() {
        // Arrange
        Long roleId = 1L; // Set valid role ID
        Role mockRole = new Role(); // Mocked role for testing
        when(roleService.removeAllUsersFromRole(roleId)).thenReturn(mockRole);

        // Act
        Role resultRole = roleController.removeAllUsersFromRole(roleId);

        // Assert
        assertEquals(mockRole, resultRole);
        verify(roleService, times(1)).removeAllUsersFromRole(roleId);
    }

    @Test
    void removeUserFromRole_ValidUserIdAndRoleId_CallsService() {
        // Arrange
        Long userId = 1L; // Set valid user ID
        Long roleId = 1L; // Set valid role ID
        User mockUser = new User(); // Mocked user for testing
        when(roleService.removeUserFromRole(userId, roleId)).thenReturn(mockUser);

        // Act
        User resultUser = roleController.removeUserFromRole(userId, roleId);

        // Assert
        assertEquals(mockUser, resultUser);
        verify(roleService, times(1)).removeUserFromRole(userId, roleId);
    }

    @Test
    void assignUserToRole_ValidUserIdAndRoleId_CallsService() {
        // Arrange
        Long userId = 1L; // Set valid user ID
        Long roleId = 1L; // Set valid role ID
        User mockUser = new User(); // Mocked user for testing
        when(roleService.assignRoleToUser(userId, roleId)).thenReturn(mockUser);

        // Act
        User resultUser = roleController.assignUserToRole(userId, roleId);

        // Assert
        assertEquals(mockUser, resultUser);
        verify(roleService, times(1)).assignRoleToUser(userId, roleId);
    }

    // Add more test methods for other controller methods
}
