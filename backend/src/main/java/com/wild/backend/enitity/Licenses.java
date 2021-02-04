package com.wild.backend.enitity;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Data
@Entity
public class Licenses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Type(type="uuid-char")
    private String licenseKey;
}
