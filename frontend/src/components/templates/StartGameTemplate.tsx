import React, { useContext } from "react";
import styled from "styled-components";
import { StartGameContext } from "../../pages/StartGame";
import Button from "../generics/Button/Button";
import Title from "../generics/Title";
import { useNavigate } from "react-router-dom";
import FullPage from "../generics/FullPage";

const StartFullPage = styled(FullPage)`
	padding: 0 13px;
`

// --- DOLPHIN LOGO ------------------------------------------
const DivLogo = styled.div`
	align-self: flex-start;
	margin-left: 13.47px;
	background: linear-gradient(45deg, #554af0, #554af0);
	-webkit-mask-image: linear-gradient(
		90deg,
		${(props) => props.theme.colors.accent100},
		#0000009e
	);
	max-height: 76px;
	max-width: fit-content;
`;
const Logo = styled.img`
	filter: saturate(0);
	mix-blend-mode: hard-light;
	background-color: white;
`;

// --- TEXT ------------------------------------------
const StyledP = styled.p`
	padding-bottom: 12px;

	font-weight: 400;
	font-size: 16px;
	color: ${(props) => props.theme.colors.dark60};
`;
const StartTitle = styled(Title)`
	font-weight: 700;
	padding: 38px 0;
`;
// --- BUTTONS ------------------------------------------
const ButtonsContainer = styled.div`
	display: flex;
	flex-direction: row;
	justify-content: space-between;
	gap: 8px;
`;

export default function StartGameTemplate() {
	const context = useContext(StartGameContext);
	const navigate = useNavigate();
	return (
		<StartFullPage>
			<div>
				<DivLogo>
					<Logo src={context.image.src} alt={context.image.alt} />
				</DivLogo>

				<StartTitle>{context.title}</StartTitle>
				<StyledP>{context.presentationText.paragraph1}</StyledP>
				<StyledP>{context.presentationText.paragraph2}</StyledP>
			</div>

			<ButtonsContainer>
				<Button
					buttonStyle="normal"
					text={context.buttons.button1}
					onClickHandler={() => navigate("/newgame")}
				/>
				<Button
					buttonStyle="secondary"
					text={context.buttons.button2}
					onClickHandler={() => navigate("/activegames")}
				/>
			</ButtonsContainer>
		</StartFullPage>
	);
}
