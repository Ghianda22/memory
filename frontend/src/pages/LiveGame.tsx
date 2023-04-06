import React, {useEffect, useState} from "react";
import {Client} from "stompjs";
import {useLocation} from "react-router-dom";
import LiveGameTemplate from "../components/templates/LiveGameTemplate";
import {data} from "../data/liveGameData";


export const LiveGameContext = React.createContext({
    ...data,
    gameName: ""
    // cardsList: [],
    // playersList: []
});
const wsURL = "http://localhost:8080";
let stompClient: Client;


export default function LiveGame() {
    const playerId: string = useLocation().state.playerId;
    const isPlayerAdmin: boolean = useLocation().state.isAdmin;
    const gameTitle: string = useLocation().state.gameName;

    // --- STATES -------------------------------------------------------------

    const [cardsList, setCardsList] = useState<Map<string, object>[]>();
    const [playersList, setPlayersList] = useState<string[]>();
    const [isTurnPlayer, setIsTurnPlayer] = useState<boolean>(false)

    const updateCards = (cardsToUpdate: string[]) => {

    }


    return (
        <LiveGameContext.Provider value={{...data, gameName: "Placeholder game"}}>
            <LiveGameTemplate />
        </LiveGameContext.Provider>
    );
}
