package io.upschool.repository;

import io.upschool.entity.AirwayCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirwayCompanyRepository extends JpaRepository<AirwayCompany, Long> {


}
