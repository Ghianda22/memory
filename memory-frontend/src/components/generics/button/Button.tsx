import React from "react";
import StyledButton from "./StyledButton";
import StyledParagraph from "../paragraphs/StyledParagraph";

export function Button(props : any){
    return (
        <div>
            <StyledButton start = {props.start} join = {props.join}>
                <StyledParagraph start = {props.start} join = {props.join}>{props.text}</StyledParagraph>
            </StyledButton>
        </div>

    );
}