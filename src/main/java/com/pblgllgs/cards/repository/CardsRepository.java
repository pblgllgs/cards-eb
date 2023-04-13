package com.pblgllgs.cards.repository;

import com.pblgllgs.cards.model.Cards;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CardsRepository extends CrudRepository<Cards,Long> {

    List<Cards> findByCustomerId(int customerId);
}
