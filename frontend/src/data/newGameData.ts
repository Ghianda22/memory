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
			options: [
				"images/icons/lion-icon.png",
				"images/icons/dog-icon.png",
				"images/icons/tophat-icon.png",
			]
		}
	],
	// selectionBar: {
	// 	numOfPlayersSelectionBar: {
	// 		label: "Number of participants",
	// 		options: [2, 3, 4],
	// 	},
	// 	modeSelectionBar: {
	// 		label: "Game mode",
	// 		options: ["Private", "Public"],
	// 	},
	// 	difficultySelectionBar: {
	// 		label: "Number of cards (difficulty)",
	// 		options: ["8 (easy)", "16 (medium)", "24 (hard)"],
	// 	},
	// },
	gameName: {
		label: "Name your game",
		placeholder: "Game name",
	},
	gameImage: {
		label: "Choose an image for your game",
		placeholder: "Browse image...",
		closeModal: "Select Image"
	},
	button: "Start"
};
