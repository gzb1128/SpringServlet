import com.pkg.dao.UserMapper;
import com.pkg.pojo.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest
        extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        System.out.println("1");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationConfig.xml");
        UserMapper userMapper = context.getBean("userMapperImpl", UserMapper.class);
        List<User> users = userMapper.getUsers();
        for(User user: users) {
            System.out.println(user);
        }
    }
}
