package org.example.learning.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.jws.soap.SOAPBinding;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CompartmentDetail {
    private User user;
    private SeatLocation seatLocation;
}
