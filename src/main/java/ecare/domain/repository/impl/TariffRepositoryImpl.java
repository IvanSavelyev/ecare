package ecare.domain.repository.impl;

import ecare.controllers.ContractController;
import ecare.domain.Tariff;
import ecare.domain.repository.TariffRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
public class TariffRepositoryImpl implements TariffRepository {

    private SessionFactory sessionFactory;
    private static final Logger logger = LoggerFactory.getLogger(ContractController.class);

    @Autowired
    public TariffRepositoryImpl(SessionFactory sessionFactory) {
        logger.info("Tariff Repository Implementation Class creating");

        this.sessionFactory = sessionFactory;
    }


    @Override
    @Transactional
    public List<Tariff> getAllTariffs() {
        logger.info("getAllTariffs method calling");

        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Tariff ").list();
    }



    @Override
    @Transactional
    public Tariff getTariffById(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Tariff.class, id);
    }




}
