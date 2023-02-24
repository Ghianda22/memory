import { images } from "./imagesData";

export const data = {
	title: "New game",
	selectionBar: [
		{
			label: "Number of participants",
			options: ["2", "3", "4"],
		},
		{
			label: "Game mode",
			options: ["Private", "Public"],
		},
		{
			label: "Number of cards (difficulty)",
			options: ["8 (easy)", "16 (medium)", "24 (hard)"],
		},
		{
			label: "Choose your avatar",
			options: images.icon
		},
	],
	gameName: {
		label: "Name your game",
		placeholder: "Game name",
	},
	gameImage: {
		label: "Choose an image for your game",
		placeholder: "Browse image...",
		closeModal: "Select Image",
	},
	button: "Start",
};
