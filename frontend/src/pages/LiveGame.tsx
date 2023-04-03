import React, { useEffect, useState } from "react";
import SockJS from "sockjs-client";
import Stomp, { Client } from "stompjs";

const wsURL = "http://localhost:8080";

interface MessageReceived {
	from: string;
	text: string;
}

let stompClient: Client;
export default function LiveGame() {
	const [messages, setMessages] = useState<MessageReceived[]>([]);

	useEffect(() => {
		connect();
	}, []);

	function connect() {
		var socket = new SockJS(wsURL+"/chat");
		stompClient = Stomp.over(socket);
		stompClient.connect({}, function (frame) {
			stompClient.subscribe("/topic/messages", function (messageOutput) {
				showMessageOutput(JSON.parse(messageOutput.body));
			});
		});
	}

	function sendMessage() {
		stompClient.send(
			"/app/chat",
			{},
			JSON.stringify({ from: "from", text: "testo di prova" })
		);
	}

	function showMessageOutput(messageOutput: MessageReceived) {
		console.log("Questo è il messaggio " + messageOutput);
    
  }

	return (
		<div>
			LiveGame
			<button onClick={sendMessage}>Send message</button>
		</div>
	);
}
