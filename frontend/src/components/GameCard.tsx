import React from "react";
import styled from "styled-components";
import { data } from "../data/activeGamesData";
import CalendarIcon from "./generics/icons/CalendarIcon";
import ProfileIcon from "./generics/icons/ProfileIcon";
import Button from "./generics/Button/Button";
import UserIcon from "./generics/UserIcon";
import IDtoGame from "../interfaces/IDtoGame";

const CardContainer = styled.div<{ image: string }>`
	min-height: 209px;
	display: flex;
	flex-direction: column;
	justify-content: flex-end;
	padding: 16px;
	margin-bottom: 19px;

	background: linear-gradient(
			180deg,
			rgba(85, 74, 240, 0.2) 0%,
			#554af0 66.15%
		),
		url(${(props) => props.image});
	background-repeat: no-repeat;
	background-size: cover;
	background-position: center;
	border-radius: 12px;

	color: ${(props) => props.theme.colors.white};
`;
const InfoStyle = styled.p`
	font-weight: 600;
	font-size: 14px;
	flex: none;
	width: auto;
`;

// --- INFO CONTAINERS ----------------------------------------------------------------------------
const GameName = styled.h6`
	font-weight: 700;
	font-size: 24px;
	line-height: 36px;
`;
const InfoContainer = styled.div`
	display: flex;
	flex-direction: row;
	justify-content: left;
	padding: 12px 0 7px;
	gap: 32px;
`;
const IconInfo = styled.div`
	display: flex;
	flex-direction: row;
	justify-content: flex-start;
	gap: 8px;
	width: fit-content;
`;
const Difficulty = styled.p`
	font-weight: 400;
	font-size: 14px;
	color: ${(props) => props.theme.colors.accent10};
`;

// --- FOOTER CONTAINERS ----------------------------------------------------------------------------
const CardFooter = styled.div`
	display: flex;
	flex-direction: row;
	justify-content: space-between;
	align-items: center;
	padding-top: 9px;
`;
const AuthorContainer = styled.div`
	display: flex;
	flex-direction: row;
	justify-content: flex-start;
	gap: 10px;
`;
const UsernameImageContainer = styled.div`
	width: auto;
`;
const ThisIsAuthor = styled.p`
	font-weight: 500;
	font-size: 10px;
	line-height: 16px;

	color: ${(props) => props.theme.colors.accent30};
`;

const ButtonContainer = styled.div``;

export default function GameCard({ game, joinGame }: IDtoGame) {
	return (
		<CardContainer image={game.gameImage}>
			<GameName>{game.gameName}</GameName>
			<InfoContainer>
				<IconInfo>
					<CalendarIcon />
					<InfoStyle>{game.gameDate}</InfoStyle>
				</IconInfo>
				<IconInfo>
					<ProfileIcon />
					<InfoStyle>
						{game.freeSeats}
						{game.freeSeats > 1 ? " seats" : " seat"} left
					</InfoStyle>
				</IconInfo>
			</InfoContainer>
			<Difficulty>Difficulty: {game.difficulty}</Difficulty>
			<CardFooter>
				<AuthorContainer>
					<UsernameImageContainer>
						<UserIcon image={game.gameCreator.image} />
					</UsernameImageContainer>

					<div>
						<InfoStyle>{game.gameCreator.username}</InfoStyle>
						<ThisIsAuthor>Started this game</ThisIsAuthor>
					</div>
				</AuthorContainer>
				<ButtonContainer>
					<Button
						buttonStyle={"negative"}
						text={data.button}
						onClickHandler={() => joinGame(game)}
					/>
				</ButtonContainer>
			</CardFooter>
		</CardContainer>
	);
}
