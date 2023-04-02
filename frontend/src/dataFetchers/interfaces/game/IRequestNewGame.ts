import { GameBgImage } from "../../enum/GameBgImageEnum";
import { GameDifficulty } from "../../enum/GameDifficultyEnum";

export default interface IRequestNewGame {
	name: string;
	maxNumberOfPlayers: number;
	isPublic: boolean;
	bgImage: GameBgImage;
	difficulty: GameDifficulty;
}
