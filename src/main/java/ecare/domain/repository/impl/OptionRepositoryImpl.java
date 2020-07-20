package ecare.domain.repository.impl;
/*
import ecare.domain.Option;
import ecare.domain.repository.OptionRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
public class OptionRepositoryImpl implements OptionRepository {

    private SessionFactory sessionFactory;

    @Autowired
    public OptionRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public List<Option> getAllOptions() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Option").list();
    }

    @Override
    public void addOption(Option option) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(option);
    }

    @Override
    public void deleteOption(Option option) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(option);
    }
}


 */