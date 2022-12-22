import styled from "styled-components";

export const NewGamePage = styled.div`
padding : 40px 15px 40px 15px;
height: 100%;
`
export const InputNewGamePage = styled.input.attrs(props => ({
    type: "text",
}))`
display:flex;
align-items: center;
padding-top: 16px;
padding-bottom: 16px;
padding-left: 0px;
padding-right: 0px;
text-indent: 16px;
background: #FFFFFF;
width: 100%;
border: 0.5px solid #E2E3E4;
border-radius: 12px;
margin-bottom: 41px;
`