package org.august.service;

import org.august.model.Client;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ClientCrudService {
    private SessionFactory factory = new Configuration().configure().buildSessionFactory();

    public void addClient(Client client) {
        try (Session session = factory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(client);
            transaction.commit();
        }
    }

    public Client getClient(int id) {
        try (Session session = factory.openSession()) {
            return session.get(Client.class, id);
        }
    }

    public void updateClient(Client client) {
        try (Session session = factory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(client);
            transaction.commit();
        }
    }

    public void deleteClient(int id) {
        try (Session session = factory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Client client = session.get(Client.class, id);
            if (client != null) {
                session.delete(client);
            }
            transaction.commit();
        }
    }

    public List<Client> getAllClients() {
        try (Session session = factory.openSession()) {
            return session.createQuery("from Client", Client.class).list();
        }
    }
}