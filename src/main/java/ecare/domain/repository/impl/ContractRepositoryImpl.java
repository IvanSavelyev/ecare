package ecare.domain.repository.impl;

import ecare.controllers.ContractController;
import ecare.domain.Contract;
import ecare.domain.Tariff;
import ecare.domain.repository.ContractRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class ContractRepositoryImpl implements ContractRepository {

    private static final Logger logger = LoggerFactory.getLogger(ContractController.class);
    private SessionFactory sessionFactory;

    @Autowired
    public ContractRepositoryImpl(SessionFactory sessionFactory) {
        logger.info("Contract Repository Implementation Class creating");
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public List<Contract> showContract() {
        logger.info("showContract method calling");
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Contract ").list();
    }
}
