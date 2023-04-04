import React, {useEffect, useState} from "react";
import Stomp, {Client} from "stompjs";
import SockJS from "sockjs-client";
import {useLocation} from "react-router-dom";
import TextInput from "../components/generics/TextInput";

const wsURL = "http://localhost:8080";

interface MessageReceived {
    from: string;
    text: string;
}

let stompClient: Client;
export default function LiveGame() {
    const [messages, setMessages] = useState<MessageReceived[]>([]);
    const gameId = useLocation().state.gameId;
    const [prova, setProva] = useState<String>()

    console.log(gameId);
    useEffect(() => {
        connect();
    }, []);

    console.log([...messages]);
    function connect() {
        let socket = new SockJS(`${wsURL}/actions`);
        stompClient = Stomp.over(socket);
        stompClient.connect({}, onConnected);
    }
    const onConnected = () => {
        stompClient.subscribe(`/livegame/${gameId}`, function (messageOutput) {
            showMessageOutput(JSON.parse(messageOutput.body));
        });
    }
    function sendMessage() {
        stompClient.send(
            `/game/actions`,
            {},
            JSON.stringify({
                from: gameId,
                text: "Ciao, io sono " + prova
            })
        );
    }
    function showMessageOutput(messageOutput: MessageReceived) {

        setMessages([...messages, messageOutput]);
        console.log(messageOutput);
    }

    function handleChange(name: string, value: string) {
        setProva(value);
    }

    const mappedMessages = messages.map(msg => {
        return <div>
            <p><b>{msg.from}</b></p>
            <p>{msg.text}</p>
        </div>
    })


    return (
        <div>
            LiveGame
            <div>{mappedMessages}</div>
            <TextInput image={""} placeholder={"nome utente"} fieldName={"prova"} handleOnChange={handleChange}/>
            <button onClick={sendMessage}>Send message</button>
        </div>
    );
}
