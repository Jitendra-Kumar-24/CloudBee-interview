package org.example.learning.model;

import org.apache.commons.lang3.RandomUtils;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Unit test file to validate the class {@link SeatLocation}
 */
public class SeatLocationTest {

    /**
     * Test to validate the setter and getter methods.
     */
    @Test
    public void testSetterAndGetter() {
        final long userId = RandomUtils.nextLong();
        final SeatLocation seatLocation = new SeatLocation();
        seatLocation.setSeatNumber(34);
        seatLocation.setCompartment("B");
        seatLocation.setUserId(userId);

        assertThat(seatLocation.getSeatNumber(), is(34));
        assertThat(seatLocation.getCompartment(), is("B"));
        assertThat(seatLocation.getUserId(), is(userId));
    }

    /**
     * Test to validate the equals method.
     */
    @Test
    public void testEquals() {
        final long userId = RandomUtils.nextLong();
        final SeatLocation seatLocation1 = new SeatLocation();
        seatLocation1.setSeatNumber(34);
        seatLocation1.setCompartment("B");
        seatLocation1.setUserId(userId);

        final SeatLocation seatLocation2 = new SeatLocation();
        seatLocation2.setSeatNumber(34);
        seatLocation2.setCompartment("B");
        seatLocation2.setUserId(userId);

        assertThat(seatLocation1.equals(seatLocation2), is(true));
    }

    /**
     * Test to validate the toString method.
     */
    @Test
    public void testToString() {
        final long userId = RandomUtils.nextLong();
        String expectedString = "SeatLocation(seatNumber=34, compartment=B, userId=" + userId + ")";


        final SeatLocation seatLocation = new SeatLocation();
        seatLocation.setSeatNumber(34);
        seatLocation.setCompartment("B");
        seatLocation.setUserId(userId);

        assertThat(seatLocation.toString(), is(expectedString));
    }
}