package javadeveloper.module11.client;

import javadeveloper.module11.storage.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ClientCrudService {
    public void createClient(Client client) {
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(client);
        transaction.commit();
        session.close();
    }

    public Client getClientById(long id) {
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        Client client = session.get(Client.class, id);
        session.close();
        return client;
    }

    public void updateClientName(long id, String name) {
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Client client = session.get(Client.class, id);
        client.setName(name);
        transaction.commit();
        session.close();
    }

    public void deleteClientById(long id) {
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Client client = session.get(Client.class, id);
        session.remove(client);
        transaction.commit();
        session.close();
    }

    public List<Client> getAllClients() {
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        List<Client> allClient = session
                .createQuery("from Client", Client.class)
                .list();
        session.close();
        return allClient;
    }
}
