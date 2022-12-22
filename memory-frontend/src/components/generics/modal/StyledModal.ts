import styled, { css } from "styled-components";

export const ShadowDiv =  styled.div`
background-color: rgba(0,0,0,0.4);
width: 100%;
height: 100%;
left: 0;
top: 0;
position: fixed;
z-index: 1;
display: flex;
align-items: center;
justify-content: center;
`
export const ModalDiv = styled.div`
width: 80%;
height: 65%;
border-radius: 10px;
background-color: #FFFFFF;
position: absolute;
z-index: 2;
padding: 30px;
`