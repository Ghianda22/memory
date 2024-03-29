import styled, { css } from "styled-components";

const StyledButton = styled.button<{ buttonStyle: string }>`
	font-weight: 500;
	font-size: 16px;
	padding: 16px 14px;
	border-radius: 12px;
	border: none;
	text-align: center;
	${(props) =>
		props.buttonStyle === "normal" &&
		css`
			background-color: ${props.theme.colors.accent100};
			color: ${props.theme.colors.white};
			:active {
				background-color: ${props.theme.colors.normalActive};
			}
		`}
	${(props) =>
		props.buttonStyle === "secondary" &&
		css`
			background-color: ${props.theme.colors.almostWhite};
			color: ${props.theme.colors.accent100};
			:active {
				background-color: ${props.theme.colors.secondaryActive};
			}
		`}
	${(props) =>
		props.buttonStyle === "delicate" &&
		css`
			padding: 10px 24px;
			border: 1px solid ${props.theme.colors.outlineDelicate};
			border-radius: 8px;
			font-size: 12px;
			line-height: 20px;
			background-color: ${props.theme.colors.white};
			color: ${props.theme.colors.accent80};
			:active {
				background-color: ${props.theme.colors.almostWhite};
			}
		`}
	${(props) =>
		props.buttonStyle === "negative" &&
		css`
			padding: 6px 12px;
			background-color: ${props.theme.colors.white};
			color: ${props.theme.colors.accent100};
			:active {
				background-color: ${props.theme.colors.secondaryActive};
			}
			border: 1px solid ${props.theme.colors.accent100};
			font-weight: 600;
		`}
`;

export default StyledButton;
