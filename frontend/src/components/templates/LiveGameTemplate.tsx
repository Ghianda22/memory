import React, {useContext, useState} from 'react'
import Title from "../generics/Title";
import FullPage from "../generics/FullPage";
import {LiveGameContext} from "../../pages/LiveGame";
import Button from "../generics/Button/Button";
import styled from "styled-components";
import {toggleFunction} from "../../interfaces/IPlayingCardProps";
import PlayingCard from "../PlayingCard";

const CardSection = styled.section`
  display: grid;
  grid-template-columns: repeat(5, 1fr);
  grid-template-rows: repeat(5, 1fr);
  grid-gap: 10px;
`
const PlayersSection = styled.section`
    
    
`

export default function LiveGameTemplate() {
    const context = useContext(LiveGameContext);

    const initCardStatus = () => {
        return [
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false
        ]
    }

    const [cardsStatus, setCardsStatus] = useState<boolean[]>(initCardStatus())



    const toggleCard: toggleFunction = (cardIndex) => {
        setCardsStatus(cardsStatus.map((card, index) => {
            if(index == cardIndex){
                return !card;
            }
            return card;
        }))
    }

    const carte = [
        "/images/icons/lion-icon.png",
        "/images/icons/dog-icon.png",
        "/images/icons/tophat-icon.png",
        "/images/icons/dolphin-icon.png",
        "/images/icons/lion-icon.png",
        "/images/icons/dog-icon.png",
        "/images/icons/tophat-icon.png",
        "/images/icons/dolphin-icon.png",
        "/images/icons/lion-icon.png",
        "/images/icons/dog-icon.png",
        "/images/icons/tophat-icon.png",
        "/images/icons/dolphin-icon.png",
        "/images/icons/lion-icon.png",
        "/images/icons/dog-icon.png",
        "/images/icons/tophat-icon.png",
        "/images/icons/dolphin-icon.png",
        "/images/icons/lion-icon.png",
        "/images/icons/dog-icon.png",
        "/images/icons/tophat-icon.png",
        "/images/icons/dolphin-icon.png",
        "/images/icons/lion-icon.png",
        "/images/icons/dog-icon.png",
        "/images/icons/tophat-icon.png",
        "/images/icons/dolphin-icon.png"
    ]

    const cardsList = carte.map((carta, index) => {
        return <PlayingCard key={index} cardImage={carta} isFaceUp={cardsStatus[index]} toggleFunction={() => toggleCard(index)}/>
    });

    const players = "bubu";

    return (
        <>
            <Title>{context.gameName}</Title>
            <FullPage>
                <CardSection>{cardsList}</CardSection>
                <PlayersSection>{players}</PlayersSection>
                <Button buttonStyle="delicate" text={context.quitGame} onClickHandler={() => console.log("Clicked")}/>
            </FullPage>
        </>
    )
}
