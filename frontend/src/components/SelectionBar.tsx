import React from "react";
import styled, { css } from "styled-components";

const SelectionBarContainer = styled.div`
	display: flex;
	flex-direction: row;
	justify-content: center;
	align-items: center;
	text-align: center;
	letter-spacing: -0.08px;

	height: fit-content;
	padding: 2px;

	background-color: ${(props) => props.theme.colors.selector};
	border-radius: 8px;
`;

const OptionContainer = styled.div<{ selected?: boolean }>`
	display: flex;
	flex-direction: row;
	align-items: center;
	text-align: center;
	letter-spacing: -0.08px;

	background-color: none;
	${(props) =>
		props.selected &&
		css`
			background-color: ${props.theme.colors.white};
			border: 0.5px solid rgba(0, 0, 0, 0.04);
			box-shadow: 0px 3px 8px rgba(0, 0, 0, 0.12),
				0px 3px 1px rgba(0, 0, 0, 0.04);
			border-radius: 7px;
		`}
`;

const OptionText = styled.p`
	padding: 6px 8px;

	font-family: "SF Pro Text";
	font-weight: 400;
	font-size: 13px;
	line-height: 20px;
`;

const Separator = styled.div`
  height: 100%;
  width: 0;
  padding: 8px 0;
  border: 0.5px solid ${(props) => props.theme.colors.separator}
  border-radius: 0.5px;
`;

export default function SelectionBar() {
	const optionText = "1";
	return (
		<SelectionBarContainer>
			<OptionContainer selected>
				<OptionText>{optionText}</OptionText>
			</OptionContainer>

			<OptionContainer>
				<OptionText>{optionText}</OptionText>
			</OptionContainer>

			<Separator></Separator>

			<OptionContainer>
				<OptionText>{optionText}</OptionText>
			</OptionContainer>
		</SelectionBarContainer>
	);
}
