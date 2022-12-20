/* eslint-disable jsx-a11y/img-redundant-alt */
import React from "react";
import StyledParagraph from "../../generics/paragraphs/StyledParagraph";
import { ColumnScrollBar, DivScrollBar, DivChoices } from "./StyledScrollBar";


export default function ScrollBar(props : any) {

    const options = props.phrases ? props.optionsScrollBar.map((item: any) => {
        return (
            <ColumnScrollBar>
                <StyledParagraph choicesNewGame>{item}</StyledParagraph>
            </ColumnScrollBar>
        );
    })
    :
    props.optionsScrollBar.filter((item: any) => item.id > 0).map((item: any) => {
        return (
            <ColumnScrollBar>
                <img src={item.img} alt="image"/>
            </ColumnScrollBar>
        );
    });
    
    return (
        <DivChoices>
            <StyledParagraph newGame>{props.text}</StyledParagraph>
            <DivScrollBar phrases = {props.phrases}>
                {options}
            </DivScrollBar>
        </DivChoices>
    );
}