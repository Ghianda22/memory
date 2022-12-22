/* eslint-disable jsx-a11y/img-redundant-alt */
import React from "react";
import StyledParagraph from "../../generics/paragraphs/StyledParagraph";
import { ColumnScrollBar, DivScrollBar, DivChoices, Images } from "./StyledScrollBar";


export default function ScrollBar(props : any) {

    const options = props.optionsScrollBar.map((item: any) => {
        return (
            <ColumnScrollBar clicked = {item === props.defaultOption} images = {!props.phrases} matchImages = {props.matchImages} onClick = {() => props.handleOption(item.id)}>
                {props.phrases ? <StyledParagraph choicesNewGame>{item.data}</StyledParagraph> : <Images matchImages = {props.matchImages}src={item.img} alt="image"/>}
            </ColumnScrollBar>
        );
    })

    return (
        <DivChoices>
            <StyledParagraph newGame>{props.text}</StyledParagraph>
            <DivScrollBar phrases = {props.phrases} images = {!props.phrases}>
                {options}
            </DivScrollBar>
        </DivChoices>
    );
}