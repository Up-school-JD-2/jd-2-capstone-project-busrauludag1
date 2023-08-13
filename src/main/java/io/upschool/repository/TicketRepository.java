package io.upschool.repository;

import io.upschool.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    @Query(value = "select count(t) from Ticket t where t.number = :number")
    public int findTicketCountByTicketNumber(@Param("number") String number);

    Ticket getTicketByNumber(String number);
}
