package io.upschool.repository;

import io.upschool.entity.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AirportRepository extends JpaRepository<Airport, Long> {

    List<Airport> findByCityContainingIgnoreCase(String name);

    Airport findByCode(String code);

    @Query(value = "select count(a) from Airport a " + "where a.name = :name")
    int findAirportCountByName(@Param("name") String name);
}
