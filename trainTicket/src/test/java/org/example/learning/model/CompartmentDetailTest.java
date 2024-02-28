package org.example.learning.model;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Unit test file to validate the class {@link CompartmentDetail}
 */
public class CompartmentDetailTest {

    private static User user;
    private static SeatLocation seatLocation;

    /**
     * Method to initialize the variable before any test is executed.
     */
    @BeforeClass
    public static void setUp() {
        user = new User(1, "Ajay", "Sharma", 34, "test1@gmail.com");
        seatLocation = new SeatLocation(23, "A", user.getUserId());
    }

    /**
     * Method to release the resource once all the tests are executed.
     */
    @AfterClass
    public static void tearDown() {
        user = null;
        seatLocation = null;
    }

    /**
     * Test to validate the setter and getter methods.
     */
    @Test
    public void testGetterAndSetter() {
        CompartmentDetail compartmentDetail = new CompartmentDetail();
        compartmentDetail.setUser(user);
        compartmentDetail.setSeatLocation(seatLocation);

        assertThat(compartmentDetail.getUser(), is(user));
        assertThat(compartmentDetail.getSeatLocation(), is(seatLocation));
    }

    /**
     * Test to validate the equals method.
     */
    @Test
    public void testEquals() {
        CompartmentDetail compartmentDetail1 = new CompartmentDetail();
        compartmentDetail1.setUser(user);
        compartmentDetail1.setSeatLocation(seatLocation);

        CompartmentDetail compartmentDetail2 = new CompartmentDetail();
        compartmentDetail2.setUser(user);
        compartmentDetail2.setSeatLocation(seatLocation);

        assertThat(compartmentDetail1.equals(compartmentDetail2), is(true));
    }

    /**
     * Test to validate the toString method.
     */
    @Test
    public void testToString() {

        String expectedString = "CompartmentDetail(user=User(userId=1, firstName=Ajay, lastName=Sharma, age=34, " +
                "emailId=test1@gmail.com), seatLocation=SeatLocation(seatNumber=23, compartment=A, userId=1))";
        CompartmentDetail compartmentDetail1 = new CompartmentDetail();
        compartmentDetail1.setUser(user);
        compartmentDetail1.setSeatLocation(seatLocation);

        assertThat(compartmentDetail1.toString(), is(expectedString));
    }
}