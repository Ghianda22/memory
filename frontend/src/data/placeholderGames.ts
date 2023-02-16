import IGame from "../interfaces/IGame";

export const fakeGames: IGame[] = [
	{
		gameName: "The lions cage",
		gameDate: "31 May",
		gameImage: "images/active_games/lion-ag-bg.jpg",
		freeSeats: 1,
		difficulty: "16 cards (medium)",
		gameCreator: {
			username: "Lion",
			image: "images/icons/lion-icon.png",
		},
	},
	{
		gameName: "The memory challenge",
		gameDate: "31 May",
		gameImage: "images/active_games/brain-ag-bg.jpg",
		freeSeats: 2,
		difficulty: "16 cards (medium)",
		gameCreator: {
			username: "Dog",
			image: "images/icons/dog-icon.png",
		},
	},
	{
		gameName: "Memory master",
		gameDate: "31 May",
		gameImage: "images/active_games/einstein-ag-bg.jpg",
		freeSeats: 2,
		difficulty: "16 cards (medium)",
		gameCreator: {
			username: "Hat",
			image: "images/icons/tophat-icon.png",
		},
	},
];