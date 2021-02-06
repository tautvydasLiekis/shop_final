package com.wild.backend.enitity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.UUID;

@Setter
@Getter
@ToString
@Entity
public class Licenses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String licensesKey;

    private Boolean isActivated;

    public String newLicenseKey(){
        return UUID.randomUUID().toString();
    }

}
