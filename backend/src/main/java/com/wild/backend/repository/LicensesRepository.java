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

    Licenses findLicensesByLicensesKey(String licenseKey);

    Licenses findLicensesById(long id);

    @Modifying
    @Query("UPDATE Licenses l SET l.isActivated = true " +
            "WHERE l.licensesKey = :licenseKey ")
    void setLicenseKeyToActive(@Param("licenseKey") String licenseKey);

    @Query("SELECT l.licensesKey, p.name FROM Licenses l " +
                    "left join Product p on p.id = l.productId " +
                    "left join User u on u.id = l.userId " +
            "where u.username=:username and l.isActivated =:flag")
    List<Licenses> findalllicensesbyusername(@Param("username") String username, @Param("flag") Boolean bool);
}
