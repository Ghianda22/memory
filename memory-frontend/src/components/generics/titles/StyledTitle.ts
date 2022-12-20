import styled,{css} from "styled-components";


export const Title = styled.h2<{start?:boolean,newGame?:boolean}>`
margin: 0px;
font-family: "Poppins";
font-style: normal;
font-weight: 700;
font-size: 32px;
line-height: 120%;
color: #554AF0;

${props => props.start && css`
padding-bottom: 32px;
width: 328px;
height: 76px;
`
}
${props => props.newGame && css`
padding-left: 2px;
padding-bottom: 28px;
`
}
`