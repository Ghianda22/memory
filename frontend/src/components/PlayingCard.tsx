import React, {useState} from 'react'
import styled from "styled-components";
import theme from "../styles/theme";
import IPlayingCardProps from "../interfaces/IPlayingCardProps";


const Wrapper = styled.div`
  background-color: ${props => theme.colors.white};
  border-radius: 16px;
`

const Card = styled.img`
  border: 6px solid ${props => theme.colors.white};
  border-radius: 13px;
`

export default function PlayingCard(props: IPlayingCardProps) {
  const { cardImage, isFaceUp, toggleFunction} = props;

  return (
    <Wrapper onClick={toggleFunction}>
      <Card src={isFaceUp ? cardImage : "/images/card_back/card-tint.png"} />
    </Wrapper>
  )
}

