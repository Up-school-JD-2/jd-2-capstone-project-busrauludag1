package io.upschool.repository;

import io.upschool.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

    @Query(value = "select count(c) from Company c " + "where c.name = :name")
    int findCompanyCountByName(@Param("name") String name);

}
