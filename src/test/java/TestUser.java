import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


public class TestUser {
    User user;
    @BeforeEach
    public void beginTest() {
        user = new User("login", "email", "password", 17);
        System.out.println("Test started");
    }

    @AfterAll
    public static void finishTests(){
        System.out.println("Tests finished");
    }

    @Test
    public void testValidateUser_throwsAccessDeniedException() {
        // given:
        var expected = AccessDeniedException.class;

        // expect
        Assertions.assertThrowsExactly(expected,
                user::validateUser);
    }

    @Test
    public void testValidateUser_notThrowsException(){
        // given:
        var expected = AccessDeniedException.class;

        user.setAge(18);
        // expect
        Assertions.assertDoesNotThrow(user::validateUser);
    }

    @Test
    public void test_NotNull_GetterLogin() {
        String result = user.getLogin();
        Assertions.assertNotNull(result);
    }

    @ParameterizedTest
    @ValueSource(strings = {"newLogin", "newLogin2"})
    public void testGetterLogin(String string){
        String expected = "login";
        String result = user.changeLogin(string);
        Assertions.assertNotEquals(expected, result);
    }


}
