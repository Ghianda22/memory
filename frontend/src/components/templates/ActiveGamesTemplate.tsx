import React, { useContext } from "react";
import Title from "../generics/Title";
import { ActiveGamesContext } from "../../pages/ActiveGames";
import FullPage from "../generics/FullPage";
import GameCard from "../GameCard";

export default function ActiveGamesTemplate() {
	const { data, games } = useContext(ActiveGamesContext);
	const renderedGames = games.map((game, i) => {
		return <GameCard key={i} game={game} />;
	});

	console.log(renderedGames);

	return (
		<>
			<Title>{data.title}</Title>
			<FullPage>{games.length ? renderedGames : data.noGames}</FullPage>
		</>
	);
}
