import IGame from "./IGame";

export default interface IDtoGame {
	game: IGame;
	joinGame: IJoinGame;
}

export type IJoinGame = (game: IGame) => void;
