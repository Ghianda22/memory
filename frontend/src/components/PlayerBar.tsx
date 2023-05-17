import React from 'react';
import styled from "styled-components";
import UserIcon from "./generics/UserIcon";

interface IPlayerBarProps {
    userIcon: string,
    userName: string,
    isTurnPlayer: boolean
}

const StatusBar = styled.div`
`
const ActiveTurnLabel = styled.div`
    
`

export default function PlayerBar(props: IPlayerBarProps) {

    return (
        <ActiveTurnLabel>
            <StatusBar>
                <UserIcon image={props.userIcon}/>

            </StatusBar>
        </ActiveTurnLabel>
    );
}
