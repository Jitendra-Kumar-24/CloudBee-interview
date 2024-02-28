package org.example.learning.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Unit test file to validate the class {@link Journey}
 */
public class JourneyTest {
    private static User user;

    /**
     * Method to initialize the variable before any test is executed.
     */
    @Before
    public void setUp() {
        user = new User(1, "Ajay", "Sharma", 34, "test1@gmail.com");
    }

    /**
     * Method to release the resource once all the tests are executed.
     */
    @After
    public void tearDown() {
        user = null;
    }

    /**
     * Test to validate the setter and getter methods.
     */
    @Test
    public void testSetterAndGetter() {
        final Journey journey = new Journey();
        journey.setFromStation("London");
        journey.setToStation("France");
        journey.setUser(user);

        assertThat(journey.getFromStation(), is("London"));
        assertThat(journey.getToStation(), is("France"));
        assertThat(journey.getUser(), is(user));
    }

    /**
     * Test to validate the equals method.
     */
    @Test
    public void testEquals() {
        final Journey journey1 = new Journey();
        journey1.setFromStation("London");
        journey1.setToStation("France");
        journey1.setUser(user);

        final Journey journey2 = new Journey();
        journey2.setFromStation("London");
        journey2.setToStation("France");
        journey2.setUser(user);

        assertThat(journey1.equals(journey2), is(true));
    }

    /**
     * Test to validate the toString method.
     */
    @Test
    public void testToString() {
        String expectedString = "Journey(fromStation=London, toStation=France, user=User(userId=1, firstName=Ajay, " +
                "lastName=Sharma, age=34, emailId=test1@gmail.com))";

        final Journey journey = new Journey();
        journey.setFromStation("London");
        journey.setToStation("France");
        journey.setUser(user);

        assertThat(journey.toString(), is(expectedString));
    }
}