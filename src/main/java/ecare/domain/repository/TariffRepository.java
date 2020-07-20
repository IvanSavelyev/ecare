package ecare.domain.repository;

import ecare.domain.Tariff;

import java.util.List;

public interface TariffRepository {

    List<Tariff> getAllTariffs();
    Tariff getTariffById(Integer id);
}
