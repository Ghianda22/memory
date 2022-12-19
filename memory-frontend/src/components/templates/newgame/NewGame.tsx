import React from "react";
import { Title } from "../../generics/titles/StyledTitle";
import { NewGamePage } from "./StyledNewGame";

export default function NewGame(props : any){
    return(
        <NewGamePage>
            <Title>{props.dataNewGame[0].text}</Title>
            
        </NewGamePage>
    );
}