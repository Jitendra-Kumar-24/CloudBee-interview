package org.example.learning.model;

import org.apache.commons.lang3.RandomUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Unit test file to validate the class {@link Ticket}
 */
public class TicketTest {

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
    public void testSetterAndGetter() {
        long ticketId = RandomUtils.nextLong();

        Ticket ticket = new Ticket();
        ticket.setTicketId(ticketId);
        ticket.setTicketPrice(100);
        ticket.setUser(user);
        ticket.setFromStation("France");
        ticket.setToStation("London");
        ticket.setSeatLocation(seatLocation);

        assertThat(ticket.getTicketId(), is(ticketId));
        assertThat(ticket.getTicketPrice(), is(100L));
        assertThat(ticket.getUser(), is(user));
        assertThat(ticket.getFromStation(), is("France"));
        assertThat(ticket.getToStation(), is("London"));
        assertThat(ticket.getSeatLocation(), is(seatLocation));
    }

    /**
     * Test to validate the equals method.
     */
    @Test
    public void testEquals() {
        long ticketId = RandomUtils.nextLong();

        Ticket ticket1 = new Ticket();
        ticket1.setTicketId(ticketId);
        ticket1.setTicketPrice(100);
        ticket1.setUser(user);
        ticket1.setFromStation("France");
        ticket1.setToStation("London");
        ticket1.setSeatLocation(seatLocation);


        Ticket ticket2 = new Ticket();
        ticket2.setTicketId(ticketId);
        ticket2.setTicketPrice(100);
        ticket2.setUser(user);
        ticket2.setFromStation("France");
        ticket2.setToStation("London");
        ticket2.setSeatLocation(seatLocation);

        assertThat(ticket1.equals(ticket2), is(true));
    }

    /**
     * Test to validate the toString method.
     */
    @Test
    public void testToString() {
        long ticketId = RandomUtils.nextLong();
        String expectedString = "Ticket(ticketId=" + ticketId + ", fromStation=France, toStation=London, " +
                "user=User(userId=1, firstName=Ajay, lastName=Sharma, age=34, emailId=test1@gmail.com), " +
                "ticketPrice=100, seatLocation=SeatLocation(seatNumber=23, compartment=A, userId=1))";

        Ticket ticket = new Ticket();
        ticket.setTicketId(ticketId);
        ticket.setTicketPrice(100);
        ticket.setUser(user);
        ticket.setFromStation("France");
        ticket.setToStation("London");
        ticket.setSeatLocation(seatLocation);

        assertThat(ticket.toString(), is(expectedString));
    }
}