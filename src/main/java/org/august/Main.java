package org.august;

import org.august.model.Client;
import org.august.model.Planet;
import org.august.model.Ticket;
import org.august.service.ClientCrudService;
import org.august.service.PlanetCrudService;
import org.august.service.TicketCrudService;

import java.sql.Timestamp;


public class Main {
    public static void main(String[] args) {
        ClientCrudService clientService = new ClientCrudService();
        PlanetCrudService planetService = new PlanetCrudService();
        TicketCrudService ticketService = new TicketCrudService();

        Client client1 = new Client();
        client1.setName("John Doe");
        clientService.addClient(client1);

        Client client2 = new Client();
        client2.setName("Jane Doe");
        clientService.addClient(client2);

        Client client = clientService.getClient(1);
        if (client != null) {
            client.setName("John Smith");
            clientService.updateClient(client);
        }

        System.out.println("All Clients:");
        clientService.getAllClients().forEach(c -> System.out.println(c.getId() + ": " + c.getName()));

        clientService.deleteClient(2);

        Planet planet1 = new Planet();
        planet1.setId("MARS");
        planet1.setName("Mars");
        planetService.addPlanet(planet1);

        Planet planet2 = new Planet();
        planet2.setId("VEN");
        planet2.setName("Venus");
        planetService.addPlanet(planet2);

        Planet planet = planetService.getPlanet("MARS");  // Отримання планети за id
        if (planet != null) {
            planet.setName("Red Planet");
            planetService.updatePlanet(planet);
        }

        System.out.println("All Planets:");
        planetService.getAllPlanets().forEach(p -> System.out.println(p.getId() + ": " + p.getName()));

        planetService.deletePlanet("VEN");

        Ticket ticket1 = new Ticket();
        ticket1.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        ticket1.setClient(client1);
        ticket1.setFromPlanet(planet1);
        ticket1.setToPlanet(planet2);
        ticketService.addTicket(ticket1);

        Ticket ticket2 = new Ticket();
        ticket2.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        ticket2.setClient(client2);
        ticket2.setFromPlanet(planet2);
        ticket2.setToPlanet(planet1);
        ticketService.addTicket(ticket2);
    }
}
