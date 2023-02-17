import IGame from "../interfaces/IGame";

export const fakeGames: IGame[] = [
	{
		gameId: "123",
		gameName: "The lions cage",
		gameDate: "31 May",
		gameImage: "images/active_games/desaturated/lion-ag-bg-des.jpg",
		freeSeats: 1,
		difficulty: "16 cards (medium)",
		gameCreator: {
			username: "Lion",
			image: "images/icons/lion-icon.png",
		},
	},
	{
		gameId: "456",
		gameName: "The memory challenge",
		gameDate: "31 May",
		gameImage: "images/active_games/desaturated/brain-ag-bg-des.jpg",
		freeSeats: 2,
		difficulty: "16 cards (medium)",
		gameCreator: {
			username: "Dog",
			image: "images/icons/dog-icon.png",
		},
	},
	{
		gameId: "789",
		gameName: "Memory master",
		gameDate: "31 May",
		gameImage: "images/active_games/desaturated/einstein-ag-bg-des.jpg",
		freeSeats: 2,
		difficulty: "16 cards (medium)",
		gameCreator: {
			username: "Hat",
			image: "images/icons/tophat-icon.png",
		},
	},
];