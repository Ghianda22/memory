import React, {useContext, useState} from 'react'
import Title from "../generics/Title";
import FullPage from "../generics/FullPage";
import {LiveGameContext} from "../../pages/LiveGame";
import Button from "../generics/Button/Button";
import styled from "styled-components";

const CardSection = styled.section`
    
`
const PlayersSection = styled.section`
    
`

export default function LiveGameTemplate() {
    const context = useContext(LiveGameContext);

    const cards = "halo";
    const players = "bubu";

    return (
        <>
            <Title>{context.gameName}</Title>
            <FullPage>
                <CardSection>{cards}</CardSection>
                <PlayersSection>{players}</PlayersSection>
                <Button buttonStyle="delicate" text={context.quitGame} onClickHandler={() => console.log("Clicked")}/>
            </FullPage>
        </>
    )
}
