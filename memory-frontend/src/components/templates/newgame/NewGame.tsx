import React from "react";
import { Title } from "../../generics/titles/StyledTitle";
import ScrollBar from "./ScrollBar";
import { NewGamePage } from "./StyledNewGame";

export default function NewGame(props : any){
    return(
        <NewGamePage>

            <Title newGame>{props.dataNewGame[0].text}</Title>

            <ScrollBar
            text = {props.dataNewGame[1].text}
            optionsScrollBar = {props.dataNewGame[10].array}
            phrases = {true}
            />

            <ScrollBar
            text = {props.dataNewGame[2].text}
            optionsScrollBar = {props.dataNewGame[11].array}
            phrases = {true}
            />

            <ScrollBar
            text = {props.dataNewGame[3].text}
            optionsScrollBar = {props.dataNewGame[12].array}
            phrases = {true}
            />

            <ScrollBar 
            text = {props.dataNewGame[4].text}
            optionsScrollBar = {props.dataImages}
            phrases = {false}
            />
            
        </NewGamePage>
    );
}