package javadeveloper.module11.ticket;

import javadeveloper.module11.client.Client;
import javadeveloper.module11.planet.Planet;
import javadeveloper.module11.storage.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class TicketCrudService {
    public void createTicket(Ticket ticket) {
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(ticket);
        transaction.commit();
        session.close();
    }

    public Ticket getTicketById(long id) {
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        Ticket ticket = session.get(Ticket.class, id);
        session.close();
        return ticket;
    }

    public void updateTicketClient(long id, Client client) {
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Ticket ticket = session.get(Ticket.class, id);
        ticket.setClient(client);
        transaction.commit();
        session.close();
    }

    public void updateTicketFromPlanet(long id, Planet fromPlanet) {
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Ticket ticket = session.get(Ticket.class, id);
        ticket.setFromPlanet(fromPlanet);
        transaction.commit();
        session.close();
    }

    public void updateTicketToPlanet(long id, Planet toPlanet) {
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Ticket ticket = session.get(Ticket.class, id);
        ticket.setToPlanet(toPlanet);
        transaction.commit();
        session.close();
    }

    public void deleteTicketById(long id) {
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Ticket ticket = session.get(Ticket.class, id);
        session.remove(ticket);
        transaction.commit();
        session.close();
    }

    public List<Ticket> getAllTickets() {
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        List<Ticket> allTickets = session
                .createQuery("from Ticket", Ticket.class)
                .list();
        session.close();
        return allTickets;
    }
}
