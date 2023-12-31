package response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.dailycodework.lakesidehotel.response.JwtResponse;

class JwtResponseTest {
    @Test
    public void testJwtResponseConstructor() {
        // Given
        Long id = 1L;
        String email = "test@example.com";
        String token = "someToken";
        List<String> roles = Arrays.asList("ROLE_USER", "ROLE_ADMIN");

        // When
        JwtResponse jwtResponse = new JwtResponse(id, email, token, roles);

        // Then
        assertNotNull(jwtResponse);
        assertEquals(id, jwtResponse.getId());
        assertEquals(email, jwtResponse.getEmail());
        assertEquals(token, jwtResponse.getToken());
        assertEquals("Bearer", jwtResponse.getType());
        assertEquals(roles, jwtResponse.getRoles());
    }
}