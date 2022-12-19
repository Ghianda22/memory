import styled, { css } from "styled-components";

export default styled.p<{ start?: boolean, join?: boolean, startParagraph?: boolean }>`

    font-family: "Poppins";
    font-style: normal;
    font-weight: 500;
    font-size: 16px;
    line-height: 24px;

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
    `}
    
    `