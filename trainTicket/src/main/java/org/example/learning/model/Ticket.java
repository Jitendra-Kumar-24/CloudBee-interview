package org.example.learning.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {
    private long ticketId;
    private String fromStation;
    private String toStation;
    private User user;
    private long ticketPrice;
    private SeatLocation seatLocation;
}
