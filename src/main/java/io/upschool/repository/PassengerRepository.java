package io.upschool.repository;

import io.upschool.entity.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Long> {

    @Query(value = "select count(p) from Passenger p " + "where p.tcNo = :tcNo")
    int findPassengerByCountByTcNo(@Param("tcNo") String tcNo);

}
