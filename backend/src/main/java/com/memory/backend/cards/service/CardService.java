package com.memory.backend.cards.service;

import com.memory.backend.Icons;
import com.memory.backend.cards.data.persistence.CardEntity;
import com.memory.backend.cards.data.persistence.CardEntityBuilder;
import com.memory.backend.cards.data.persistence.CardRepository;
import com.memory.backend.game.data.enums.GameDifficulty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CardService {

    private CardRepository cardRepository;

    @Autowired
    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public void createDeckForGame(UUID gameId, GameDifficulty difficulty){
        Integer cardNumber = 0;
        List<Icons> deck = new ArrayList<>();
        switch(difficulty){
            case EASY -> cardNumber = 4;
            case MEDIUM -> cardNumber = 8;
            case HARD -> cardNumber = 12;
            default -> throw new IllegalArgumentException("Value of enum not valid");
        }

        for(int i = 0; i < cardNumber; i++){
            deck.add(Icons.values()[i]);
            deck.add(Icons.values()[i]);
        }
        Collections.shuffle(deck);

        for(int i = 0; i < deck.size(); i++){
            CardEntity cardToSave = new CardEntityBuilder()
                    .setGameId(gameId)
                    .setIcon(deck.get(i))
                    .setOrderInDeck(i)
                    .createCardEntity();
            cardRepository.saveAndFlush(cardToSave);
        }

    }

    public Boolean areCardsEqual(UUID card1, UUID card2){
        Optional<CardEntity> cardOptional1 = cardRepository.findById(card1);
        Optional<CardEntity> cardOptional2 = cardRepository.findById(card2);
        if(cardOptional1.isEmpty() || cardOptional2.isEmpty()){
            return null;
        }
        Icons icon1 = cardOptional1.get().getIcon();
        Icons icon2 = cardOptional2.get().getIcon();

        return icon1.equals(icon2);
    }

    public List<CardEntity> getCardsInGameWithId(UUID gameId){
        return cardRepository.findAllByGameId(gameId);
    }

    public List<CardEntity> getCardsFacedUpNotCollected(UUID gameId){
        return cardRepository.findAllByGameIdAndIsFaceUpTrueAndIsCollectedFalse(gameId);
    }

}
