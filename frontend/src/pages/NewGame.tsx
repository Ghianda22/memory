import React from "react";
import NewGameTemplate from "../components/templates/NewGameTemplate";
import { data } from "../data/newGameData";

export const NewGameContext = React.createContext(data);

export default function NewGame() {
	return (
		<NewGameContext.Provider value={data}>
			<NewGameTemplate />
		</NewGameContext.Provider>
	);
}
