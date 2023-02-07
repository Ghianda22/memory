import React, { useContext } from "react";
import styled from "styled-components";
import { images } from "../../data/imagesData";
import { NewGameContext } from "../../pages/NewGame";
import LabelText from "../generics/LabelText";
import SelectionBar from "../SelectionBar";

const FullPage = styled.div`
	display: flex;
	height: 100%;
	flex-direction: column;
`;

export default function NewGameTemplate() {
	const context = useContext(NewGameContext);
	const [gameName, setGameName] = React.useState<string>();
	const [numberOfPlayers, setNumberOfPlayers] = React.useState<string>(context.selectionBar[0].options[1]);
	const [mode, setMode] = React.useState<string>(context.selectionBar[1].options[0]);
	const [difficulty, setDifficulty] = React.useState<string>(context.selectionBar[2].options[0]);
	const [image, setImage] = React.useState<string>(images.icon[0]);
	const [matchImage, setMatchImage] = React.useState<string>(images.background[0]);
	const [showBrowseImages, setShowBrowseImages] = React.useState<boolean>(false);


	//  const showGameImages = () => {
	// 		setShowBrowseImages(!showBrowseImages);
	// 	}

	// 	const handleChangeName = (event: any) =>  {
	// 		setGameName(event.target.value);
	// 	}

		const handleNumberOfPlayers = (value: string) => {
			setNumberOfPlayers(value);
		}

		// const handleMode = (id: number) => {
		// 	setMode();
		// }

		// const handleDifficulty = (id: number) => {
		// 	setDifficulty();
		// }

		// const handleImage = (id: number) => {
		// 	setImage();
		// }

		// const handleMatchImage = (id: number) => {
		// 	setMatchImage();
		// }

		// const handleSubmit = () => {
		// 	// Backend
		// }
	return (
		<FullPage>
			<LabelText>Prova</LabelText>
			<SelectionBar
				selectionBar={context.selectionBar[0]}
				selectedOption={numberOfPlayers}
				setOption={handleNumberOfPlayers}
			/>
		</FullPage>
	);
}
