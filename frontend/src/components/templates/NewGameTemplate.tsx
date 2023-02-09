import { useState, useContext } from "react";
import { useNavigate } from "react-router-dom";
import styled from "styled-components";
import { images } from "../../data/imagesData";
import { NewGameContext } from "../../pages/NewGame";
import Button from "../generics/Button/Button";
import LabelText from "../generics/LabelText";
import Modal from "../generics/Modal";
import TextInput from "../generics/TextInput";
import Title from "../generics/Title";
import ImageSelectionBar from "../ImageSelectionBar";
import SelectionBar from "../SelectionBar";

const FullPage = styled.div`
	display: flex;
	height: 100%;
	flex-direction: column;
	justify-content: space-between;
`;

const BrowseImageContainer = styled.div`
	display: flex;
	flex-direction: row;
	align-items: flex-start;
	justify-content: space-between;
`;
const GameImageContainer = styled.div`
	text-align: end;
	width: 135%;
	padding: 5px;
`;

//TODO: use the image component in the active game page
// const SelectedGameImage = styled.img`
// 	width: 75%;
// `;

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
	const [numberOfPlayers, setNumberOfPlayers] = useState<string>(
		context.selectionBar[0].options[1]
	);
	const [mode, setMode] = useState<string>(
		context.selectionBar[1].options[0]
	);
	const [difficulty, setDifficulty] = useState<string>(
		context.selectionBar[2].options[0]
	);
	const [avatar, setAvatar] = useState<string>("");
	const [gameImage, setGameImage] = useState<string>("");
	const [modalIsVisible, setModalIsVisible] = useState<boolean>(false);

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
	const selectAvatar = (image: string) => {
		setAvatar(image);
	};

	const toggleModal = () => {
		setModalIsVisible(!modalIsVisible);
	};
	const selectGameImage = (image: string) => {
		setGameImage(image);
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
		<>
			<Title>{context.title}</Title>
			<FullPage>
				<SelectionBar
					selectionBar={context.selectionBar[0]}
					selectedOption={numberOfPlayers}
					setOption={changeNumberOfPlayers}
				/>
				<SelectionBar
					selectionBar={context.selectionBar[1]}
					selectedOption={mode}
					setOption={changeMode}
				/>
				<SelectionBar
					selectionBar={context.selectionBar[2]}
					selectedOption={difficulty}
					setOption={changeDifficulty}
				/>
				<ImageSelectionBar
					selectionBar={context.selectionBar[3]}
					selectedOption={avatar}
					setOption={selectAvatar}
					displayOnXAxis={true}
				/>

				{/* Game name input */}
				<div>
					<LabelText>{context.gameName.label}</LabelText>
					<TextInput
						image={""}
						placeholder={context.gameName.placeholder}
						handleOnChange={handleChangeName}
					/>
				</div>

				{/* Browse Image modal */}
				<div>
					<LabelText>{context.gameImage.label}</LabelText>
					<BrowseImageContainer>
						<Button
							buttonStyle={"secondary"}
							text={context.gameImage.placeholder}
							onClickHandler={toggleModal}
						/>
						{/* <div></div> */}
						<GameImageContainer>
							{/* <SelectedGameImage
									src={gameImage}
									alt={gameImage.substring(12)}
								/> */}
						</GameImageContainer>
					</BrowseImageContainer>
				</div>

				{modalIsVisible && (
					<Modal
						text={context.gameImage.closeModal}
						closeModal={toggleModal}
					>
						<ImageSelectionBar
							selectionBar={{
								label: context.gameImage.label,
								options: images.background,
							}}
							selectedOption={gameImage}
							setOption={selectGameImage}
							displayOnXAxis={false}
						/>
					</Modal>
				)}

				<Button
					buttonStyle={"normal"}
					text={context.button}
					onClickHandler={navigateToNextPage}
				/>
			</FullPage>
		</>
	);
}
