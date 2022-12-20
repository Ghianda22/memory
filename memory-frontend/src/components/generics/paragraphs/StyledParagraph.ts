import styled, { css } from "styled-components";

export default styled.p<{ start?: boolean, join?: boolean, startParagraph?: boolean , newGame ?: boolean, choicesNewGame ?: boolean}>`

    font-family: "Poppins";
    font-style: normal;
    font-weight: 500;
    font-size: 16px;
    line-height: 24px;
    margin: 0px;

    ${props => props.start && css`
        color: #FFFFFF;
        text-align: center;
    `}
    ${props => props.join && css`
        color: #554AF0;
        text-align: center;
    `}
    ${props => props.startParagraph && css`
        color: #686777;
        text-align: left;
        padding: 5px;
    `}
    ${props => props.newGame && css`
        padding: 2px;
        color: #36354A;
        text-align: left;
        margin-bottom: 15px;
    `}
    ${props => props.choicesNewGame && css`
        font-weight: 400;
        font-size: 13px;
        line-height: 20px;
        color: #36354A;
    `}

    `