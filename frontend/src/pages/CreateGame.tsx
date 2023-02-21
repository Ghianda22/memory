import React, { useState } from "react";
import { Outlet, useLocation, useNavigate} from "react-router-dom";
import { data as newGameData } from "../data/newGameData";
import { data as sendInvitationsData } from "../data/sendInvitationsData";
import INewGame from "../interfaces/INewGame";

/** STEPS
 * 1. newgame
 * 2. sendInvitations
 * */
const creationSteps = ["/newgame", "/newgame/sendinvitations"];

export const CreateGameContext = React.createContext({
	newGame: {
		pageData: newGameData,
		state: {
			numberOfPlayers: "",
			mode: "",
			difficulty: "",
			avatar: "",
			gameImage: "",
			gameName: "",
		},
		updateState: (name: string, value: string) => {},
	},
	sendInvitations: {
		pageData: {
			...sendInvitationsData,
			unavailableAvatar: "",
			numberOfPlayers: "",
		},
		state: {},
		updateState: (name: string, value: string) => {},
	},
	next: () => {},
});

export default function CreateGame() {
	const navigate = useNavigate();
	const currentStep = creationSteps.indexOf(useLocation().pathname);
	// console.log(currentStep);
	// console.log(creationSteps.indexOf(currentStep));

	const [newGame, setNewGame] = useState<INewGame>({
		numberOfPlayers: newGameData.selectionBar[0].options[1],
		mode: newGameData.selectionBar[1].options[0],
		difficulty: newGameData.selectionBar[2].options[0],
		avatar: "",
		gameImage: "",
		gameName: "",
	});
	const [contacts, setContacts] = useState<string[]>([]);
	// const [currentStep, setCurrentStep] = useState<number>(0);

	const updateGameDetails = (name: string, value: string) => {
		console.log(name + "  = " + value);
		setNewGame({ ...newGame, [name]: value });
	};
	const updateContacts = (name: string, value: string) => {
		setContacts(
			contacts.map((val, i) => (i === parseInt(name) ? value : val))
		);
	};
	// const navigateToNextStep = () => {
	// 	if (newGame.mode === newGameData.selectionBar[1].options[0]) {
	// 		// if it's private
	// 		navigate("/newgame/sendinvitations");
	// 	} else navigate("/livegame");
	// };
	const navigateToNextStep = () => {
		if (currentStep < creationSteps.length -1) {
			if (newGame.mode === newGameData.selectionBar[1].options[0]){ // if it's private
				navigate(creationSteps[currentStep + 1]);
			}else navigate("/livegame/" + "635")
		}else navigate("/livegame/" + "635")
	};

	const context = {
		newGame: {
			pageData: newGameData,
			state: newGame,
			updateState: updateGameDetails,
		},
		sendInvitations: {
			pageData: {
				...sendInvitationsData,
				unavailableAvatar: newGame.avatar,
				numberOfPlayers: newGame.numberOfPlayers,
			},
			state: contacts,
			updateState: updateContacts,
		},
		next: navigateToNextStep,
	};

	return (
		<CreateGameContext.Provider value={context}>
			<Outlet />
		</CreateGameContext.Provider>
	);
}
