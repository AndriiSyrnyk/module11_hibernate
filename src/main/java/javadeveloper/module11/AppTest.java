package javadeveloper.module11;

import javadeveloper.module11.client.ClientCrudService;
import javadeveloper.module11.migration.DatabaseMigrationService;
import javadeveloper.module11.planet.PlanetCrudService;
import javadeveloper.module11.ticket.Ticket;
import javadeveloper.module11.ticket.TicketCrudService;

import java.util.List;

public class AppTest {
    public static void main(String[] args) {
//        new DatabaseMigrationService().migrate();
        ClientCrudService clientCrudService = new ClientCrudService();
        TicketCrudService ticketCrudService = new TicketCrudService();
        PlanetCrudService planetCrudService = new PlanetCrudService();

        for (Ticket ticket : ticketCrudService.getAllTickets())
            System.out.println(ticket);

        Ticket newTicket = new Ticket();
        newTicket.setClient(clientCrudService.getClientById(1L));
        newTicket.setFromPlanet(planetCrudService.getPlanetById("KHJ211"));
        newTicket.setToPlanet(planetCrudService.getPlanetById("TRE123"));
        ticketCrudService.createTicket(newTicket);

        for (Ticket ticket : ticketCrudService.getAllTickets())
            System.out.println(ticket);

        ticketCrudService.deleteTicketById(1L);
        ticketCrudService.updateTicketClient(2l, clientCrudService.getClientById(5L));
        ticketCrudService.updateTicketFromPlanet(2L, planetCrudService.getPlanetById("JKG345"));
        ticketCrudService.updateTicketToPlanet(2L, planetCrudService.getPlanetById("TFD412"));

        for (Ticket ticket : ticketCrudService.getAllTickets())
            System.out.println(ticket);
    }
}