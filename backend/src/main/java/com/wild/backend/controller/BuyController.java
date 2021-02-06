package com.wild.backend.controller;

import com.wild.backend.service.BuyService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/buy")
public class BuyController {

    private BuyService buyService;

    public BuyController(BuyService buyService) {
        this.buyService = buyService;
    }

    @PostMapping
    public String getCheckout(){
        return buyService.getCheckout("user","a");
    }
}