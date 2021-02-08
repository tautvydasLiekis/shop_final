package com.wild.backend.controller;

import com.wild.backend.service.BuyService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/buy")
public class BuyController {

    private BuyService buyService;

    public BuyController(BuyService buyService) {
        this.buyService = buyService;
    }

    @PutMapping
    public Integer getCheckout(@RequestParam("prodName") String prodName,@RequestParam("user") String username){
        return buyService.getCheckout(prodName,username);
    }
}
