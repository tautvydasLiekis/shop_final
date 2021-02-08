package com.wild.backend.repository;

import com.wild.backend.enitity.Licenses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LicensesRepository extends JpaRepository<Licenses, Long> {

    Licenses findLicensesByLicensesKey(Integer licenseKey);

    @Modifying
    @Query(value = "UPDATE Licenses l SET l.is_activated = true WHERE l.licenses_key = ?", nativeQuery = true)
    void setLicenseKeyToActive(@Param("licenseKey") Integer license_Key);

    @Query(value = "SELECT * FROM Licenses l left join Product p on p.id = l.product_id " +
            "left join User u on u.id = l.user_id where u.username = ? and l.is_activated = true", nativeQuery = true)
    List<Licenses> findalllicensesbyusername(@Param("username") String username);

}
