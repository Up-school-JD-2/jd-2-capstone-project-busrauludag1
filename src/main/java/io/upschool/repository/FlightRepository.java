package io.upschool.repository;

import io.upschool.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

    @Query(value = "select f from Flight f where f.company.name = :companyName")
    Optional<Flight> findByCompany_Name(@Param("companyName") String name);

    @Query(value = "select count(f) from Flight f")
    int findFlightCount();

}
