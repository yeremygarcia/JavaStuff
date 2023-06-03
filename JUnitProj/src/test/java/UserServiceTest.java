import org.example.User;
import org.example.UserService;
import org.junit.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SuppressWarnings("deprecation")
@RunWith(MockitoJUnitRunner.class)
@DisplayName("Testing UserService Class")
public class UserServiceTest {
    @Mock
    private Map<String, User> userDatabase;
    @InjectMocks
    private UserService userService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        System.out.println("Starting tests for method with @Before");
    }
    @BeforeClass
    public static void setClass() {
        System.out.println("Setting up @BeforeClass");
    }
    @AfterClass
    public static void tearDownClass() {
        System.out.println("Compiling class after testing with @AfterClass");
    }
    @After
    public void tearDown() {
        System.out.println("Executing clean up operations after each test with @After");
    }

    //test  registerUser()
    @Test
    public void registerUserPositive() {
        User user = new User("BookHunter", "KnowledgeISpower!1213", "BookHunter1213@gmail.com");
        when(userDatabase.containsKey("BookHunter")).thenReturn(false);  //set up mock behavior for existing username in database, return false
        boolean result = userService.registerUser(user);    //registering user
        assertTrue(result); //verify result comes back true
        verify(userDatabase).put("BookHunter", user);    //verify that the 'put' method of 'userDatabase' is called with the expected arguments
    }

    @Test
    public void registerUserNegative() {
        User user = new User("BookHunter", "KnowledgeISpower!1213", "BookHunter1213@gmail.com");
        when(userDatabase.containsKey("BookHunter")).thenReturn(true);   //set up mock behavior for existing username in database, return true
        boolean result = userService.registerUser(user);    //registering user
        assertFalse(result);    //verify result comes back false
        verify(userDatabase, never()).put(anyString(), any(User.class));    //verify that 'puy' of 'userDatabase' is never called
    }

    @Test
    public void registerUserEdge() {
        User user = new User("", "KnowledgeISpower!1213", "BookHunter1213@gmail.com");
        when(userDatabase.containsKey("")).thenReturn(false);   //set up mock behavior for existing username in database, return false
        boolean result = userService.registerUser(user);    //registering user
        assertTrue(result); //verify the result comes back true
        verify(userDatabase).put("", user); //verify that 'put' of 'userDatabase' is called with expected argument
    }

    //test loginUser()
    @Test
    public void loginUserPositive() {
        User user = new User("BookHunter", "KnowledgeISpower!1213", "BookHunter1213@gmail.com");
        when(userDatabase.get("BookHunter")).thenReturn(user);   //set up mock behavior for existing username in database, return user obj
        User loggedInUser = userService.loginUser("BookHunter", "KnowledgeISpower!1213"); //logging user in
        assertNotNull(loggedInUser);    //verify logged in user is not null
        assertEquals(user, loggedInUser);   //verify that logged-in user matches expected user obj
    }

    @Test
    public void loginUserNegative_UserNotFound() {
        when(userDatabase.get("invalidUser")).thenReturn(null); //set up mock behavior for existing username in database
        User loggedInUser = userService.loginUser("invalidUser", "pw1234"); //logging user in
        assertNull(loggedInUser);   //verify logged in user is null
    }

    @Test
    public void loginUserEdge_WrongPassword() {
        User user = new User("BookHunter", "KnowledgeISpower!1213", "BookHunter1213@gmail.com");
        when(userDatabase.get("BookHunter")).thenReturn(user);   //set up mock behavior for existing username in database
        User loggedInUser = userService.loginUser("BookHunter", "bookHunterFoundBook"); //logging user in
        assertNull(loggedInUser);   //verify logged in user is null
    }

    //test updateUserProfile() - Optional so testing with @Ignore
    @Ignore
    @Test
    public void updateProfilePositive() {
        User user = new User("BookHunter", "KnowledgeISpower!1213", "BookHunter1213@gmail.com");
        when(userDatabase.containsKey("FairyReads")).thenReturn(false);  //set up mock behavior for existing username in database, return false
        boolean result = userService.updateUserProfile(user, "FairyReads", "FairyMagicPixie", "FairyWings23@gmail.com");  //attempt at updating profile info
        assertTrue(result); //verify result comes back true
        assertEquals("FairyReads", user.getUsername());  //verify that users info is updated correctly
        assertEquals("FairyMagicPixie", user.getPassword());
        assertEquals("FairyWings23@gmail.com", user.getEmail());
        verify(userDatabase).put("FairyReads", user);    //verify that 'put'  method of 'userDatabase' is called with expected arguments
    }

    @Test
    public void updateProfileNegative_UsernameExistsAlready() {
        User user1 = new User("BookHunter", "KnowledgeISpower!1213", "BookHunter1213@gmail.com");
        when(userDatabase.containsKey("FairyReads")).thenReturn(true);   //set up mock behavior for existing username in database, return true
        boolean result = userService.updateUserProfile(user1, "FairyReads", "FairyMagicWords#45", "FairyReads93@gmail.com");  //attempt at updating profile info
        assertFalse(result);    //verify result comes back false
        assertEquals("BookHunter", user1.getUsername()); //verify user info remains the same
        assertEquals("KnowledgeISpower!1213", user1.getPassword());
        assertEquals("BookHunter1213@gmail.com", user1.getEmail());
        verify(userDatabase, never()).put(anyString(), any(User.class));    //verify that the 'put' method of 'userDatabase' is never called
    }

    @Test
    public void updateProfileEdge() {
        User user1 = new User("BookHunter", "KnowledgeISpower!1213", "BookHunter1213@gmail.com");
        when(userDatabase.containsKey(anyString())).thenReturn(true);   //set up mock behavior for existing username in database
        boolean result = userService.updateUserProfile(user1, "FairyReads", "FairyMagicPixie", "FairyWings23@gmail.com");   //attempt to update profile with existing username
        assertFalse(result);    //verify result comes back false
        assertEquals("BookHunter", user1.getUsername()); //verify original profile remains the same
        assertEquals("KnowledgeISpower!1213", user1.getPassword());
        assertEquals("BookHunter1213@gmail.com", user1.getEmail());
        verify(userDatabase, never()).put(anyString(), any(User.class));    //verify that user info was not modified
    }
    @Test
    public void updateProfileSetNewInfo() {
        User user = mock(User.class);
        when(userDatabase.containsKey(anyString())).thenReturn(false);  //set up mock behavior in user database - check username is not yet taken
        boolean result = userService.updateUserProfile(user, "BookHunter", "KnowledgeISpower!1213", "BookHunter1213@gmail.com");  //update user info
        verify(user).setUsername("BookHunter");  //verify new info is set
        verify(user).setPassword("KnowledgeISpower!1213");
        verify(user).setEmail("BookHunter1213@gmail.com");
        verify(userDatabase).put("BookHunter", user);
        assertTrue(result); //verify the user info was set

    }


}
