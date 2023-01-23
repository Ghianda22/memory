import styled, { css } from "styled-components";
import React from "react";

const StyledButton = styled.button<{ buttonStyle: string }>`
	width: 100%;
	padding: 16px;
	border-radius: 12px;
	border: none;
	text-align: center;

	${(props) =>
		props.buttonStyle === "normal" &&
		css`
			background-color: ${props.theme.colors.accentBlue100};
			color: ${props.theme.colors.white};
			:active {
				background-color: ${props.theme.colors.normalActive};
			}
		`}
	${(props) =>
		props.buttonStyle === "secondary" &&
		css`
			background-color: ${props.theme.colors.almostWhite};
			color: ${props.theme.colors.accentBlue100};
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
			color: ${props.theme.colors.accentBlue80};
			:active {
				background-color: ${props.theme.colors.almostWhite};
			}
		`}
`;


export default function Button() {
  return (
    <StyledButton buttonStyle="normal">
      CLICK
    </StyledButton>
  )
}
