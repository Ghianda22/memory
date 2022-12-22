import styled,{css} from "styled-components";

export const ColumnScrollBar = styled.div<{clicked?:boolean, images?: boolean, matchImages ?: boolean}>`
display: flex;
align-items: center;
justify-content: center;
width: 100%;
cursor: pointer;

${props => props.clicked && css`
background: #FFFFFF;
border: 0.5px solid rgba(0, 0, 0, 0.04);
box-shadow: 0px 3px 8px rgba(0, 0, 0, 0.12), 0px 3px 1px rgba(0, 0, 0, 0.04);
border-radius: 7px;
`
}

${props => props.images && css`
margin-right: 15px;
`
}

${props => props.matchImages && css`
margin-right: 20px;
`
}


`
export const DivScrollBar = styled.div<{phrases ?: boolean, images ?: boolean, matchImages ?: boolean}>`
display: flex;

${props => props.phrases && css`
height: 32px;
background: rgba(118, 118, 128, 0.12);
border-radius: 8px;
`
}

${props => props.images && css`
overflow-x: scroll;
`
}

`

export const DivChoices = styled.div`
margin-bottom:60px;
`

export const Images = styled.img<{matchImages ?: boolean}>`
${props => props.matchImages && css`
width: 150px;
height: 150px;
`
}
`