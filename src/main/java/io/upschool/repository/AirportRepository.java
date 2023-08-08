package io.upschool.repository;

import io.upschool.entity.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AirportRepository extends JpaRepository<Airport, Long> {

    //select * from airports a where a.name = name
    List<Airport> findAllByNameIs(String name);

    List<Airport> findByNameContainingIgnoreCase(String name);


}
