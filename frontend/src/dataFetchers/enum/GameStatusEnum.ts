export enum GameStatus {
	CREATED, // game just created but not waiting for players
	PENDING, // the author entered the game and it's waiting for players
	IN_PROGRESS,
	FINISHED,
}
