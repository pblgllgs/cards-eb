package com.pblgllgs.cards.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.pblgllgs.cards.config.CardsServiceConfig;
import com.pblgllgs.cards.model.Cards;
import com.pblgllgs.cards.model.Customer;
import com.pblgllgs.cards.model.Properties;
import com.pblgllgs.cards.repository.CardsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CardsController {

    private static final Logger logger = LoggerFactory.getLogger(CardsController.class);
    @Autowired
    private CardsRepository cardsRepository;

    @Autowired
    CardsServiceConfig cardsConfig;

    @PostMapping("/myCards")
    public List<Cards> getCardsDetails(
            @RequestHeader("pblgllgs-correlation-id") String correlationid,
            @RequestBody Customer customer){
        logger.info("getCardsDetails() method started");
        List<Cards> cards =  cardsRepository.findByCustomerId(customer.getCustomerId());
        logger.info("getCardsDetails() method ended");
        if(cards != null){
            return cards;
        }else{
            return null;
        }
    }

    @GetMapping("/cards/properties")
    public String getPropertyDetails() throws JsonProcessingException {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        Properties properties = new Properties(cardsConfig.getMsg(), cardsConfig.getBuildVersion(),
                cardsConfig.getMailDetails(), cardsConfig.getActiveBranches());
        String jsonStr = ow.writeValueAsString(properties);
        return jsonStr;
    }
}
