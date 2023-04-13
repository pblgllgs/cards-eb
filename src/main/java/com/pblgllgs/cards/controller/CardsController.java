package com.pblgllgs.cards.controller;

import com.pblgllgs.cards.model.Cards;
import com.pblgllgs.cards.model.Customer;
import com.pblgllgs.cards.repository.CardsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CardsController {
    @Autowired
    private CardsRepository cardsRepository;

    @PostMapping("/myCards")
    public List<Cards> getAccountDetails(@RequestBody Customer customer){
        List<Cards> cards =  cardsRepository.findByCustomerId(customer.getCustomerId());
        if(cards != null){
            return cards;
        }else{
            return null;
        }
    }
}
