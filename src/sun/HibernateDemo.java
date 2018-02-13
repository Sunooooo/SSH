package sun;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sun.domain.User;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class HibernateDemo {
    @Resource(name="sessionFactory")
    private  SessionFactory sf;
    @Test
    public void fun1(){
        Configuration conf = new Configuration().configure();
        SessionFactory sf = conf.buildSessionFactory();
        Session session = sf.openSession();
        Transaction ts = session.beginTransaction();
//        - - - - --
        User u = new User();

        u.setUser_name("sun");
        u.setUser_password("12345");

        session.save(u);

//        - - - - - -
        ts.commit();
    }

    @Test
    public void fun2(){

        Session session = sf.openSession();
        Transaction ts = session.beginTransaction();
//        - - - - --
        User u = new User();

        u.setUser_name("sun2");
        u.setUser_password("12345");

        session.save(u);

//        - - - - - -
        ts.commit();
        session.close();
    }
}
