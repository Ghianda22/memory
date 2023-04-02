
export default async function registerPlayer(gameId: string): Promise<string> {
	const response = await fetch(`http://localhost:8080/livegame/${gameId}`)
    if (!response.ok) {
        throw new Error('Network response was not ok')
    }
    return response.json()
}