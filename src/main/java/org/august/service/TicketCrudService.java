package org.august.service;

import org.august.model.Ticket;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class TicketCrudService {
    private SessionFactory factory;

    public TicketCrudService() {
        factory = new Configuration().configure().buildSessionFactory();
    }

    public void addTicket(Ticket ticket) {
        if (ticket.getClient() == null || ticket.getFromPlanet() == null || ticket.getToPlanet() == null) {
            throw new IllegalArgumentException("Ticket must have a valid client and planets.");
        }

        try (Session session = factory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(ticket);
            transaction.commit();
        }
    }

    public Ticket getTicket(int id) {
        try (Session session = factory.openSession()) {
            return session.get(Ticket.class, id);
        }
    }

    public void updateTicket(Ticket ticket) {
        if (ticket.getClient() == null || ticket.getFromPlanet() == null || ticket.getToPlanet() == null) {
            throw new IllegalArgumentException("Ticket must have a valid client and planets.");
        }

        try (Session session = factory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(ticket);
            transaction.commit();
        }
    }

    public void deleteTicket(int id) {
        try (Session session = factory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Ticket ticket = session.get(Ticket.class, id);
            if (ticket != null) {
                session.delete(ticket);
            }
            transaction.commit();
        }
    }

    public List<Ticket> getAllTickets() {
        try (Session session = factory.openSession()) {
            return session.createQuery("from Ticket", Ticket.class).list();
        }
    }
}