import { useContext } from "react";
import styled from "styled-components";
import { images } from "../../data/imagesData";
import { CreateGameContext } from "../../pages/CreateGame";
import Button from "../generics/Button/Button";
import LabelText from "../generics/LabelText";
import TextInput from "../generics/TextInput";
import Title from "../generics/Title";

const FullPage = styled.div`
	display: flex;
	height: 100%;
	flex-direction: column;
	justify-content: space-between;
`;

export default function SendInvitationsTemplate() {
	const { sendInvitations, next } = useContext(CreateGameContext);

	let avatarIcons: string[] = images.icon;
	avatarIcons = avatarIcons.filter(
		(icon) => icon !== sendInvitations.pageData.unavailableAvatar
	);

	const numOfInvitations =
		parseInt(sendInvitations.pageData.numberOfPlayers) - 1;

	const renderInputs: JSX.Element[] = [];
	for (let i = 0; i < numOfInvitations; i++) {
		renderInputs[i] = (
			<>
				<LabelText>
					{sendInvitations.pageData.label + " " + (i + 1)}
				</LabelText>
				<TextInput
					image={avatarIcons[i]}
					placeholder={sendInvitations.pageData.placeholder}
					fieldName={`${i}`}
					handleOnChange={sendInvitations.updateState}
				/>
			</>
		);
	}

	return (
		<FullPage>
			<div>
				<Title>{sendInvitations.pageData.title}</Title>
				{renderInputs}
			</div>
			<Button
				buttonStyle={"normal"}
				text={sendInvitations.pageData.button}
				onClickHandler={next}
			/>
		</FullPage>
	);
}
