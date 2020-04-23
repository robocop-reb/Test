import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.Query;

import javax.persistence.*;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.List;

public class Utils {


    private DataInputStream consoleInput = null;

    SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public String getStringConsole() {
        consoleInput = new DataInputStream(new BufferedInputStream(System.in));
        String temp=null;
                try {
             temp = consoleInput.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return temp;
    }

    public void updateWarmachine(int id,String name){
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
       Query query = session.createQuery("Update vehicles_table set name=:name where id=:id");
       query.setParameter("id",id);
       query.setParameter("name",name);
        query.executeUpdate();
        tx.commit();
        selectWarmachine();
        session.close();
    }


    public void insertWarmachine(String name,String type) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Warmachine warmachine = new Warmachine();
        warmachine.setName(name);
        warmachine.setType(type);
        session.save(warmachine);
        tx.commit();
        session.close();
        selectWarmachine();
    }

    public List<Warmachine> returnWarmachine() {
        Session session = sessionFactory.openSession();
        return session.createQuery("from vehicles_table", Warmachine.class).getResultList();
    }
    public void selectWarmachine() {
        Session session = sessionFactory.openSession();
        List<Warmachine> list = session.createQuery("from vehicles_table", Warmachine.class).getResultList();
        printResult(list);
    }


    public void printResult(List<Warmachine> list) {
        list.stream().forEach(l -> System.out.println(l));
    }

    public void deleteWarmachine(int id){
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Query query=session.createQuery("delete from vehicles_table where id="+id);
        int rowsDeleted=query.executeUpdate();
        tx.commit();
        session.close();
        selectWarmachine();

    }

}
