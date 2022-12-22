import styled,{css} from "styled-components";

export default styled.button<{start?:boolean,join?:boolean,startNewGame?:boolean,browseImage ?: boolean}>`
    border-radius: 12px;
    border: 0px;
    
    ${props => props.start && css`
        width: 164px;
        height: 56px;
        background: #554AF0;
    `}

    ${props => props.join && css`
        width: 164px;
        height: 56px;
        background: #F8F8FA;;
    `}

    ${props => props.startNewGame && css`
        background: #554AF0;
        height: 56px;
        width: 100%;
    `}

    ${props => props.browseImage && css`
        width: 156px;
        height: 56px;
        background: #F8F8FA;
        margin-bottom: 58px;
    `}

    `