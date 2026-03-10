package com.klef.fsad.exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Date;
import java.util.Scanner;

public class ClientDemo {

    public static void main(String[] args) {

        Configuration cfg = new Configuration();
        cfg.configure();
        cfg.addAnnotatedClass(Department.class);

        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        @SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

        System.out.println("1.Insert");
        System.out.println("2.Delete");
        int choice = sc.nextInt();

        if(choice == 1) {

            Department d = new Department();

            System.out.println("Enter Name:");
            d.setName(sc.next());

            System.out.println("Enter Description:");
            d.setDescription(sc.next());

            d.setDate(new Date());

            System.out.println("Enter Status:");
            d.setStatus(sc.next());

            session.persist(d);

            System.out.println("Record Inserted");

        }
        else if(choice == 2) {

            System.out.println("Enter ID:");
            int id = sc.nextInt();

            Department d = session.get(Department.class, id);

            if(d != null) {
                session.remove(d);
                System.out.println("Record Deleted");
            } 
            else {
                System.out.println("Record Not Found");
            }
        }

        tx.commit();
        session.close();
        sf.close();
    }
}