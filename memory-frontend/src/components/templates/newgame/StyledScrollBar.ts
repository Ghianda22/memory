import styled,{css} from "styled-components";

export const ColumnScrollBar = styled.div<{clicked?:boolean}>`
display: flex;
align-items: center;
justify-content: center;

${props => props.clicked && css`
background: #FFFFFF;
border: 0.5px solid rgba(0, 0, 0, 0.04);
box-shadow: 0px 3px 8px rgba(0, 0, 0, 0.12), 0px 3px 1px rgba(0, 0, 0, 0.04);
border-radius: 7px;
`
}
`
export const DivScrollBar = styled.div<{phrases ?: boolean}>`
display: flex;
justify-content: space-around;

${props => props.phrases && css`
height: 32px;
background: rgba(118, 118, 128, 0.12);
border-radius: 8px;
`
}

`

export const DivChoices = styled.div`
margin-bottom:60px;
`