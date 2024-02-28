package org.example.learning.resource;

import org.apache.commons.lang3.RandomUtils;
import org.example.learning.model.CompartmentDetail;
import org.example.learning.model.Journey;
import org.example.learning.model.Receipt;
import org.example.learning.model.SeatLocation;
import org.example.learning.model.Ticket;
import org.example.learning.model.User;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.Map;

/**
 * API resource class.
 */
@Path("/train")
public class ApplicationResource {

    private static final Map<Long, User> userMap =  new HashMap<>();
    private static final Set<Ticket> ticketList = new HashSet<>();
    private static final Map<Long, SeatLocation> seatLocationMap = new HashMap<>();

    /**
     * API to get the ticket details. If the query parameter is not provided while calling the API,
     * the API will return all the tickets otherwise details of the provided ticket id will be returned.
     * @param ticketId represents the ticket id.
     * @return the set of tickets.
     */
    @Path("/ticket")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Set<Ticket> getTicket(
            @QueryParam("ticketId") final String ticketId
    )
    {
        try {
            if (null != ticketId) {
                final long id = Long.parseLong(ticketId);
                for (Ticket ticket : ticketList) {
                    if (ticket.getTicketId() == id) {
                        return Collections.singleton(ticket);
                    }
                }
            }
        }catch (NumberFormatException exception)
        {
            throw new WebApplicationException(
                    Response.status(Response.Status.BAD_REQUEST).type(MediaType.TEXT_PLAIN_TYPE).entity(exception).build()
            );
        }
        return ticketList;
    }

    /**
     * The API provides the user to book a train ticket and return the ticket detail if the booking is successful.
     *
     * @param journey the {@link Journey} detail of the user.
     * @return the {@link Receipt} detail of the ticket.
     */
    @Path("/purchaseTicket")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Receipt createTicket(
            final Journey journey
            )
    {
        User user = journey.getUser();
        user.setUserId(RandomUtils.nextInt());
        user.setAge(journey.getUser().getAge());
        user.setEmailId(journey.getUser().getEmailId());
        user.setFirstName(journey.getUser().getFirstName());
        user.setLastName(journey.getUser().getLastName());
        userMap.put(user.getUserId(), user);

        SeatLocation seatLocation = new SeatLocation();
        seatLocation.setSeatNumber((int) (Math.random() * 100));
        seatLocation.setCompartment((seatLocationMap.size() % 2 == 0) ? "A" : "B");
        seatLocation.setUserId(user.getUserId());
        seatLocationMap.put(user.getUserId(), seatLocation);

        Ticket ticket = new Ticket();
        ticket.setFromStation(journey.getFromStation());
        ticket.setToStation(journey.getToStation());
        ticket.setTicketId(RandomUtils.nextInt());
        ticket.setTicketPrice(100);
        ticket.setUser(user);
        ticket.setSeatLocation(seatLocation);
        ticketList.add(ticket);

        final Receipt receipt = new Receipt();
        receipt.setTicketId(ticket.getTicketId());
        receipt.setFromStation(journey.getFromStation());
        receipt.setToStation(journey.getToStation());

        return receipt;
    }

    /**
     * The API provides the compartment details. The detail includes the user and the allocated seat for the requested
     * compartment.
     *
     * @param section represent the compartment name. Here for this APP it is only two compartment (A and B).
     */
    @GET
    @Path("/compartment/{section}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<CompartmentDetail> compartmentDetail(@PathParam("section") final String section)
    {
        List<CompartmentDetail> compartmentDetailList = new ArrayList<>();
        if (section != null && !section.isEmpty()) {
            List<Long> userIds = new ArrayList<>();
            for (SeatLocation seatLocation : seatLocationMap.values()) {
                if (seatLocation.getCompartment().equals(section)) {
                    userIds.add(seatLocation.getUserId());
                }
            }

            for (Long userid : userIds) {
                CompartmentDetail compartmentDetail = new CompartmentDetail();
                compartmentDetail.setSeatLocation(seatLocationMap.get(userid));
                compartmentDetail.setUser(userMap.get(userid));
                compartmentDetailList.add(compartmentDetail);
            }
        }

        return compartmentDetailList;
    }

    @Path("updateSeat")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateSeat(){

    }


    /**
     * The API delete the user and its detail from the system.
     * @param userId represents the user id for which the details need to be deleted.
     */
    @Path("/deleteUser/{userId}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteUser(@PathParam("userId") final String userId) {
        try {
            long id = Long.parseLong(userId);
            if (userMap.remove(id) == null) {
                throw new WebApplicationException(Response.status(Response.Status.NOT_FOUND)
                        .type(MediaType.TEXT_PLAIN_TYPE).entity("userId does not exist in the system").build());
            }
            if (seatLocationMap.remove(id) == null)
            {
                throw new WebApplicationException(Response.status(Response.Status.NOT_FOUND)
                        .type(MediaType.TEXT_PLAIN_TYPE).entity("No seat allocated for the given user").build());
            }

            ticketList.removeIf(ticket -> ticket.getUser().getUserId() == id);

        } catch (NumberFormatException exception) {
            throw new WebApplicationException(Response.status(Response.Status.BAD_REQUEST)
                    .type(MediaType.TEXT_PLAIN_TYPE).entity("userId does not exist in the system").build());
        }
    }
}
