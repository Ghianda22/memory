import { useState, useContext } from "react";
import { useNavigate } from "react-router-dom";
import styled from "styled-components";
import { images } from "../../data/imagesData";
import { NewGameContext } from "../../pages/NewGame";
import Button from "../generics/Button/Button";
import LabelText from "../generics/LabelText";
import TextInput from "../generics/TextInput";
import Title from "../generics/Title";
import SelectionBar from "../SelectionBar";

const FullPage = styled.div`
	display: flex;
	height: 100%;
	flex-direction: column;
	justify-content: space-between;
`;

export default function NewGameTemplate() {
	const context = useContext(NewGameContext);
	const navigate = useNavigate();

	// const [newGame, setNewGame] = useState<INewGame>({
	// 	numberOfPlayers: context.selectionBar[0].options[1],
	// 	mode: context.selectionBar[1].options[0],
	// 	difficulty: context.selectionBar[2].options[0],
	// 	avatar: "",
	// 	gameImage: "",
	// 	gameName: ""
	// })

	const [gameName, setGameName] = useState<string>();
	const [numberOfPlayers, setNumberOfPlayers] = useState<string>(context.selectionBar[0].options[1]);
	const [mode, setMode] = useState<string>(context.selectionBar[1].options[0]);
	const [difficulty, setDifficulty] = useState<string>(context.selectionBar[2].options[0]);
	const [avatar, setAvatar] = useState<string>("");
	const [gameImage, setGameImage] = useState<string>(images.background[0]);
	const [showGameImageModal, setshowGameImageModal] = useState<boolean>(false);

	 const browseGameImages = () => {
			setshowGameImageModal(!showGameImageModal);
		}

	const changeNumberOfPlayers = (numOption: string) => {
		setNumberOfPlayers(numOption);
	};
	const changeMode = (modeOption: string) => {
		setMode(modeOption);
	};
	const changeDifficulty = (difficultyOption: string) => {
		setDifficulty(difficultyOption);
	};
	const handleChangeName = (event: any) => {
		setGameName(event.target.value);
	};
	const selectAvatar = (imageAddress: string) => {
		setAvatar(imageAddress);
	};

	const navigateToNextPage = () => {
		// if(mode === context.selectionBar[1].options[0])
		// 	navigate("/sendinvitations/" + numberOfPlayers);
		// else navigate("/livegame");
	};
	// const changeSubmit = () => {
	// 	// Backend
	// }
	return (
		<FullPage>
			<Title>{context.title}</Title>
			<SelectionBar
				selectionBar={context.selectionBar[0]}
				selectedOption={numberOfPlayers}
				setOption={changeNumberOfPlayers}
				areImages={false}
			/>
			<SelectionBar
				selectionBar={context.selectionBar[1]}
				selectedOption={mode}
				setOption={changeMode}
				areImages={false}
			/>
			<SelectionBar
				selectionBar={context.selectionBar[2]}
				selectedOption={difficulty}
				setOption={changeDifficulty}
				areImages={false}
			/>
			<SelectionBar
				selectionBar={context.selectionBar[3]}
				selectedOption={avatar}
				setOption={selectAvatar}
				areImages={true}
			/>

			<div>
				<LabelText>{context.gameName.label}</LabelText>
				<TextInput
					image={""}
					placeholder={context.gameName.placeholder}
					handleOnChange={handleChangeName}
				/>
			</div>

			{/* Browse Image modal */}
			{/* <div>
				<LabelText>{context.gameImage.label}</LabelText>
				<Button
					buttonStyle={"secondary"}
					text={context.gameImage.placeholder}
					onClickHandler={browseGameImages}
				/>
			</div>
			{ showGameImageModal && (
				
			)} */}

			<Button
				buttonStyle={"normal"}
				text={context.button}
				onClickHandler={navigateToNextPage}
			/>
		</FullPage>
	);
}
