import { useState, useContext } from "react";
import { useNavigate } from "react-router-dom";
import styled from "styled-components";
import { images } from "../../data/imagesData";
import INewGame from "../../interfaces/INewGame";
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

	const [newGame, setNewGame] = useState<INewGame>({
		numberOfPlayers: context.selectionBar[0].options[1],
		mode: context.selectionBar[1].options[0],
		difficulty: context.selectionBar[2].options[0],
		avatar: "",
		gameImage: "",
		gameName: ""
	})
	const [modalIsVisible, setModalIsVisible] = useState<boolean>(false);


	const updateGameDetails = (name:string, value: string) => {
		console.log(name + "  = " + value);
		setNewGame({ ...newGame, [name]: value });
	}

	const toggleModal = () => {
		setModalIsVisible(!modalIsVisible);
	};
	const navigateToNextPage = () => {
		if(newGame.mode === context.selectionBar[1].options[0])
			navigate("/sendinvitations/" + newGame.numberOfPlayers);
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
					selectedOption={newGame.numberOfPlayers}
					optionName="numberOfPlayers"
					setOption={updateGameDetails}
				/>
				<SelectionBar
					selectionBar={context.selectionBar[1]}
					selectedOption={newGame.mode}
					optionName="mode"
					setOption={updateGameDetails}
				/>
				<SelectionBar
					selectionBar={context.selectionBar[2]}
					selectedOption={newGame.difficulty}
					optionName="difficulty"
					setOption={updateGameDetails}
				/>
				<ImageSelectionBar
					selectionBar={context.selectionBar[3]}
					selectedOption={newGame.avatar}
					optionName="avatar"
					setOption={updateGameDetails}
					displayOnXAxis={true}
				/>

				{/* Game name input */}
				<div>
					<LabelText>{context.gameName.label}</LabelText>
					<TextInput
						image={""}
						placeholder={context.gameName.placeholder}
						fieldName="gameName"
						handleOnChange={updateGameDetails}
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
							selectedOption={newGame.gameImage}
							setOption={updateGameDetails}
							displayOnXAxis={false}
							optionName="gameImage"
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
