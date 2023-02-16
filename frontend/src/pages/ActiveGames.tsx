import React from 'react';
import ActiveGamesTemplate from '../components/templates/ActiveGamesTemplate';
import { data } from '../data/activeGamesData';
import { fakeGames } from '../data/placeholderGames';
import IGame from '../interfaces/IGame';
import IGamesData from '../interfaces/IGamesData';

const defaultData:{data: IGamesData, games: IGame[]} = { data: data, games: [] };
export const ActiveGamesContext = React.createContext(defaultData);

export default function StartGame() {
	// Here goes a useEffect to feth the active games from backend
  const games = fakeGames;
	return (
		<ActiveGamesContext.Provider value={{data: data, games: games}}>
			<ActiveGamesTemplate />
		</ActiveGamesContext.Provider>
	);
}
