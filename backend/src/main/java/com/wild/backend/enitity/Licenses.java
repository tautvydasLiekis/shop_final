package com.wild.backend.enitity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Random;

@Setter
@Getter
@ToString
@Entity
public class Licenses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private Integer licensesKey;

    private Boolean isActivated;

    private LocalDateTime localDateTime;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "product_id")
    private Long productId;

    public Integer newLicenseKey() {
        Random rnd = new Random();
        char [] digits = new char[32];
        digits[0] = (char) (rnd.nextInt(9) + '1');
        for(int i=1; i<digits.length; i++) {
            digits[i] = (char) (rnd.nextInt(10) + '0');
        }
        return Integer.parseInt(new String(digits));
    }
}
