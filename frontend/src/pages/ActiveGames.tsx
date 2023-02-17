import React from 'react';
import { useNavigate } from 'react-router-dom';
import ActiveGamesTemplate from '../components/templates/ActiveGamesTemplate';
import { data } from '../data/activeGamesData';
import { fakeGames } from '../data/placeholderGames';
import IGame from '../interfaces/IGame';
import IGamesData from '../interfaces/IGamesData';

const defaultData:{data: IGamesData, games: IGame[]} = { data: data, games: [] };
export const ActiveGamesContext = React.createContext(defaultData);

export default function StartGame() {
	const navigate = useNavigate();
	// Here goes a useEffect to feth the active games from backend
	
	const games = fakeGames;

	const joinGame = (gameId: string) => {
		navigate("/livegame/" + gameId);
	};



	return (
		<ActiveGamesContext.Provider value={{data: data, games: games}}>
			<ActiveGamesTemplate />
		</ActiveGamesContext.Provider>
	);
}
