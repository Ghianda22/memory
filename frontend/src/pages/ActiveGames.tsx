import React from "react";
import { useNavigate } from "react-router-dom";
import ActiveGamesTemplate from "../components/templates/ActiveGamesTemplate";
import { data } from "../data/activeGamesData";
import { fakeGames } from "../data/placeholderGames";
import { IJoinGame } from "../interfaces/IDtoGame";
import IGame from "../interfaces/IGame";
import IGamesData from "../interfaces/IGamesData";

const defaultData: { data: IGamesData; games: IGame[]; joinGame: IJoinGame } = {
	data: data,
	games: [],
	joinGame: () => {},
};
export const ActiveGamesContext = React.createContext(defaultData);

export default function StartGame() {
	const navigate = useNavigate();
	// Here goes a useEffect to feth the active games from backend

	const games = fakeGames;

	const joinGame = (game: IGame) => {
		navigate("/livegame/" + game.gameId, {state: {gameId: "prova" + game.gameId}});
	};

	return (
		<ActiveGamesContext.Provider
			value={{ data: data, games: games, joinGame: joinGame }}
		>
			<ActiveGamesTemplate />
		</ActiveGamesContext.Provider>
	);
}
