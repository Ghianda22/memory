import React from "react";
import StyledButton from "../button/StyledButton";
import StyledParagraph from "../paragraphs/StyledParagraph";
import { ShadowDiv, ModalDiv } from "./StyledModal";

export default function Modal(props: any) {
    return (
        <ShadowDiv>

            <ModalDiv>
                {props.children}

                <StyledButton startNewGame  onClick={props.closeModal}>
                    <StyledParagraph start> Save </StyledParagraph>
                </StyledButton>
                
            </ModalDiv>

        </ShadowDiv>
    );
}