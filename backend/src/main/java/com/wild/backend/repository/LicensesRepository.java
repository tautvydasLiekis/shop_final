package com.wild.backend.repository;

import com.wild.backend.enitity.Licenses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LicensesRepository extends JpaRepository<Licenses, Long> {

    Licenses findLicensesByLicensesKey(String licenseKey);

    Licenses findLicensesByLicensesKeyAndProductIdAndUserId(String licenseKey, Long productId, Long userId);

    @Modifying
    @Query("UPDATE Licenses l SET l.isActivated = true " +
            "WHERE l.licensesKey = :licenseKey ")
    void setLicenseKeyToActive(@Param("licenseKey")String licenseKey);
}
