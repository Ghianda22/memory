import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import ActiveGamesTemplate from "../components/templates/ActiveGamesTemplate";
import { data } from "../data/activeGamesData";
import { getActiveGames } from "../dataFetchers/gameFetcher";
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
	const [games, setGames] = useState<IGame[]>([])
	// Here goes a useEffect to feth the active games from backend

	useEffect(() => {
		getActiveGames()
			.then(games => {
				setGames(games)})
	}, []);

	const joinGame = (game: IGame) => {
		navigate("/livegame/" + game.gameId);
	};

	return (
		<ActiveGamesContext.Provider
			value={{ data: data, games: games, joinGame: joinGame }}
		>
			<ActiveGamesTemplate />
		</ActiveGamesContext.Provider>
	);
}
