package org.august.service;

import org.august.model.Planet;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class PlanetCrudService {
    private SessionFactory factory = new Configuration().configure().buildSessionFactory();

    public void addPlanet(Planet planet) {
        try (Session session = factory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(planet);
            transaction.commit();
        }
    }

    public Planet getPlanet(String id) {
        try (Session session = factory.openSession()) {
            return session.get(Planet.class, id);
        }
    }

    public void updatePlanet(Planet planet) {
        try (Session session = factory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(planet);
            transaction.commit();
        }
    }

    public void deletePlanet(String id) {
        try (Session session = factory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Planet planet = session.get(Planet.class, id);
            if (planet != null) {
                session.delete(planet);
            }
            transaction.commit();
        }
    }

    public List<Planet> getAllPlanets() {
        try (Session session = factory.openSession()) {
            return session.createQuery("from Planet", Planet.class).list();
        }
    }
}