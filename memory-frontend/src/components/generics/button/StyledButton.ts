import styled,{css} from "styled-components";

export default styled.button<{start?:boolean,join?:boolean}>`
    width: 164px;
    height: 56px;
    border-radius: 12px;
    border: 0px;
    
    ${props => props.start && css`
        background: #554AF0;
    `}
    ${props => props.join && css`
        background: #F8F8FA;;
    `}

    `