export default interface IGame {
	gameId: string,
	gameName: string;
	gameDate: string;
	gameImage: string;
	freeSeats: number;
	difficulty: string;
	gameCreator: gameCreator;
}

interface gameCreator {
	username: string;
	image: string;
}
