package javadeveloper.module11.planet;

import javadeveloper.module11.storage.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class PlanetCrudService {
    public void createPlanet(Planet planet) {
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(planet);
        transaction.commit();
        session.close();
    }

    public Planet getPlanetById(String id) {
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        Planet planet = session.get(Planet.class, id);
        session.close();

        return planet;
    }

    public void updatePlanetName(String id, String name) {
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Planet planet = session.get(Planet.class, id);
        planet.setName(name);
        transaction.commit();
        session.close();
    }

    public void deletePlanetById(String id) {
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Planet planet = session.get(Planet.class, id);
        session.remove(planet);
        transaction.commit();
        session.close();
    }

    public List<Planet> getAllPlanets() {
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        List<Planet> allPlanet = session
                .createQuery("from Planet", Planet.class)
                .list();
        session.close();

        return allPlanet;
    }
}
