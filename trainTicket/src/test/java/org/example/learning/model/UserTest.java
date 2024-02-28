package org.example.learning.model;

import org.apache.commons.lang3.RandomUtils;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Unit test file to validate the class {@link User}
 */
public class UserTest {

    /**
     * Test to validate the setter and getter methods.
     */
    @Test
    public void testSetterAndGetter() {
        long userid = RandomUtils.nextLong();

        final User user = new User();
        user.setUserId(userid);
        user.setFirstName("Manjunath");
        user.setLastName("M");
        user.setAge(45);
        user.setEmailId("test2@gmail.com");

        assertThat(user.getUserId(), is(userid));
        assertThat(user.getAge(), is(45));
        assertThat(user.getFirstName(), is("Manjunath"));
        assertThat(user.getLastName(), is("M"));
        assertThat(user.getEmailId(), is("test2@gmail.com"));
    }

    /**
     * Test to validate the equals method.
     */
    @Test
    public void testEquals() {
        final long userid = RandomUtils.nextLong();

        final User user1 = new User();
        user1.setUserId(userid);
        user1.setFirstName("Manjunath");
        user1.setLastName("M");
        user1.setAge(45);
        user1.setEmailId("test2@gmail.com");

        final User user2 = new User();
        user2.setUserId(userid);
        user2.setFirstName("Manjunath");
        user2.setLastName("M");
        user2.setAge(45);
        user2.setEmailId("test2@gmail.com");

        assertThat(user1.equals(user2), is(true));
    }

    /**
     * Test to validate the toString method.
     */
    @Test
    public void testToString() {
        final long userid = RandomUtils.nextLong();

        final String expectedString = "User(userId=" + userid + ", firstName=Manjunath, lastName=M, " +
                "age=45, emailId=test2@gmail.com)";

        final User user = new User();
        user.setUserId(userid);
        user.setFirstName("Manjunath");
        user.setLastName("M");
        user.setAge(45);
        user.setEmailId("test2@gmail.com");

        assertThat(user.toString(), is(expectedString));
    }
}