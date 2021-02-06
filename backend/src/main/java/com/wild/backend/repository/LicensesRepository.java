package com.wild.backend.repository;

import com.wild.backend.enitity.Licenses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LicensesRepository extends JpaRepository<Licenses, Long> {
}
