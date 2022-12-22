import React from "react";
import StyledParagraph from "../../generics/paragraphs/StyledParagraph";
import { Title } from "../../generics/titles/StyledTitle";
import ScrollBar from "./ScrollBar";
import { NewGamePage, InputNewGamePage } from "./StyledNewGame";
import StyledButton from "../../generics/button/StyledButton";
import Modal from "../../generics/modal/Modal";

export default function NewGame(props: any) {

    const [gameName, setGameName] = React.useState<string>("Game name");
    const [numberOfPlayers, setNumberOfPlayers] = React.useState<number>(props.dataNewGame[10].array[0]);
    const [mode, setMode] = React.useState<number>(props.dataNewGame[11].array[0]);
    const [difficulty, setDifficulty] = React.useState<number>(props.dataNewGame[12].array[0]);
    const [image, setImage] = React.useState<number>(props.dataImages[0]);
    const [matchImage, setMatchImage] = React.useState(props.dataImages[14]);
    const [showBrowseImages, setShowBrowseImages] = React.useState<boolean>(false);

    function showGameImages() {
        setShowBrowseImages(!showBrowseImages);
    }

    function handleChangeName(event: any) {
        setGameName(event.target.value);
    }

    function handleNumberOfPlayers(id: number) {
        setNumberOfPlayers(props.dataNewGame[10].array[id]);
    }

    function handleMode(id: number) {
        setMode(props.dataNewGame[11].array[id]);
    }

    function handleDifficulty(id: number) {
        setDifficulty(props.dataNewGame[12].array[id]);
    }

    function handleImage(id: number) {
        setImage(props.dataImages[id]);
    }

    function handleMatchImage(id: number) {
        setMatchImage(props.dataImages[id]);
    }

    function handleSubmit() {
        // Backend
    }

    return (
        <NewGamePage>

            <Title newGame>{props.dataNewGame[0].text}</Title>

            <ScrollBar
                text={props.dataNewGame[1].text}
                optionsScrollBar={props.dataNewGame[10].array}
                handleOption={handleNumberOfPlayers}
                defaultOption={numberOfPlayers}
                phrases={true}
                matchImages = {false}
            />

            <ScrollBar
                text={props.dataNewGame[2].text}
                optionsScrollBar={props.dataNewGame[11].array}
                handleOption={handleMode}
                defaultOption={mode}
                phrases={true}
                matchImages = {false}
            />

            <ScrollBar
                text={props.dataNewGame[3].text}
                optionsScrollBar={props.dataNewGame[12].array}
                handleOption={handleDifficulty}
                defaultOption={difficulty}
                phrases={true}
                matchImages = {false}
            />

            <ScrollBar
                text={props.dataNewGame[4].text}
                optionsScrollBar={props.dataImages.filter((item: any) => item.id <= 13)}
                handleOption={handleImage}
                defaultOption={image}
                phrases={false}
                matchImages = {false}
            />


            <StyledParagraph newGame>{props.dataNewGame[5].text}</StyledParagraph>

            <InputNewGamePage placeholder={gameName} onChange={handleChangeName} />

            <StyledParagraph newGame>{props.dataNewGame[7].text}</StyledParagraph>

            {showBrowseImages && 
                <Modal closeModal={showGameImages}>
                    <ScrollBar
                        text={props.dataNewGame[7].text}
                        optionsScrollBar={props.dataImages.filter((item: any) => item.id > 13)}
                        handleOption={handleMatchImage}
                        defaultOption={matchImage}
                        phrases={false}
                        matchImages = {true}
                    />
                </Modal>
            }

            <StyledButton browseImage onClick={showGameImages}>
                <StyledParagraph join> {props.dataNewGame[8].text} </StyledParagraph>
            </StyledButton>

            <StyledButton startNewGame onClick={handleSubmit}>
                <StyledParagraph start> {props.dataNewGame[9].text} </StyledParagraph>
            </StyledButton>

        </NewGamePage>
    );
}