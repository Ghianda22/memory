import { useState, useContext } from "react";
import { Form } from "react-router-dom";
import styled from "styled-components";
import { images } from "../../data/imagesData";
import { CreateGameContext } from "../../pages/CreateGame";
import Button from "../generics/Button/Button";
import LabelText from "../generics/LabelText";
import Modal from "../generics/Modal";
import TextInput from "../generics/TextInput";
import Title from "../generics/Title";
import ImageSelectionBar from "../ImageSelectionBar";
import SelectionBar from "../SelectionBar";

const FullPage = styled(Form)`
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
	padding: 0 11px;
`;
const GameImageContainer = styled.div`
	text-align: end;
	width: 120%;
	padding: 5px;
`;

//TODO: use the image component in the active game page
// const SelectedGameImage = styled.img`
// 	width: 75%;
// `;

export default function NewGameTemplate() {
	const {newGame, next} = useContext(CreateGameContext);
	const [modalIsVisible, setModalIsVisible] = useState<boolean>(false);


	

	const toggleModal = () => {
		setModalIsVisible(!modalIsVisible);
	};
	// const navigateToNextPage = () => {
	// 	if(newGame.mode === context.selectionBar[1].options[0])
	// 		navigate("/sendinvitations/" + newGame.numberOfPlayers);
	// 	// else navigate("/livegame");
	// };


	return (
		<>
			<Title>{newGame.pageData.title}</Title>
			<FullPage method="post">
				<SelectionBar
					selectionBar={newGame.pageData.selectionBar[0]}
					selectedOption={newGame.state.numberOfPlayers}
					optionName="numberOfPlayers"
					setOption={newGame.updateState}
				/>
				<SelectionBar
					selectionBar={newGame.pageData.selectionBar[1]}
					selectedOption={newGame.state.mode}
					optionName="mode"
					setOption={newGame.updateState}
				/>
				<SelectionBar
					selectionBar={newGame.pageData.selectionBar[2]}
					selectedOption={newGame.state.difficulty}
					optionName="difficulty"
					setOption={newGame.updateState}
				/>
				<ImageSelectionBar
					selectionBar={newGame.pageData.selectionBar[3]}
					selectedOption={newGame.state.avatar}
					optionName="avatar"
					setOption={newGame.updateState}
					displayOnXAxis={true}
				/>

				{/* Game name input */}
				<div>
					<LabelText>{newGame.pageData.gameName.label}</LabelText>
					<TextInput
						image={""}
						placeholder={newGame.pageData.gameName.placeholder}
						fieldName="gameName"
						handleOnChange={newGame.updateState}
					/>
				</div>

				{/* Browse Image modal */}
				<div>
					<LabelText>{newGame.pageData.gameImage.label}</LabelText>
					<BrowseImageContainer>
						<Button
							buttonStyle={"secondary"}
							text={newGame.pageData.gameImage.placeholder}
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
						text={newGame.pageData.gameImage.closeModal}
						closeModal={toggleModal}
					>
						<ImageSelectionBar
							selectionBar={{
								label: newGame.pageData.gameImage.label,
								options: images.background,
							}}
							selectedOption={newGame.state.gameImage}
							setOption={newGame.updateState}
							displayOnXAxis={false}
							optionName="gameImage"
						/>
					</Modal>
				)}

				<Button
					type="submit"
					buttonStyle={"normal"}
					text={newGame.pageData.button}
					onClickHandler={next}
				/>
			</FullPage>
		</>
	);
}
