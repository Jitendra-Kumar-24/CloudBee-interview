package org.example.learning.model;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Unit test file to validate the class {@link Receipt}
 */
public class ReceiptTest {

    /**
     * Test to validate the setter and getter methods.
     */
    @Test
    public void testSetterAndGetter() {
        Receipt receipt = new Receipt();
        receipt.setFromStation("London");
        receipt.setToStation("France");
        receipt.setTicketId(1212);

        assertThat(receipt.getFromStation(), is("London"));
        assertThat(receipt.getToStation(), is("France"));
        assertThat(receipt.getTicketId(), is(1212L));
    }

    /**
     * Test to validate the equals method.
     */
    @Test
    public void testEquals() {
        Receipt receipt1 = new Receipt();
        receipt1.setFromStation("London");
        receipt1.setToStation("France");
        receipt1.setTicketId(1212);

        Receipt receipt2 = new Receipt();
        receipt2.setFromStation("London");
        receipt2.setToStation("France");
        receipt2.setTicketId(1212);

        assertThat(receipt1.equals(receipt2), is(true));
    }

    /**
     * Test to validate the toString method.
     */
    @Test
    public void testToString() {
        String expectedString = "Receipt(ticketId=1212, fromStation=London, toStation=France)";

        Receipt receipt = new Receipt();
        receipt.setFromStation("London");
        receipt.setToStation("France");
        receipt.setTicketId(1212);

        assertThat(receipt.toString(), is(expectedString));

    }
}