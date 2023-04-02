import IGame from "../interfaces/IGame"
import IGameResponse from "./interfaces/game/IGameResponse"
import INewGameResponse from "./interfaces/game/INewGameResponse"
import IRequestNewGame from "./interfaces/game/IRequestNewGame"

export async function getActiveGames(): Promise<IGame[]> {
    const response = await fetch(`http://localhost:8080/activegames`)
    if (!response.ok) {
        throw new Error('Network response was not ok')
    }
    const iGameResponse:IGameResponse = await response.json()
	return iGameResponse.activeGames
}

export async function newGame(request: IRequestNewGame): Promise<INewGameResponse> {
    const response = await fetch(`http://localhost:8080/newgame/create`, {
		method: "POST",
		mode: "cors", // no-cors, *cors, same-origin
		headers: {
		"Content-Type": "application/json",
		},
		body: JSON.stringify(request)
	})
    if (!response.ok) {
        throw new Error('Network response was not ok')
    }
    return response.json()
}
