import React from "react";
import styled, { css } from "styled-components";
import ISelectionBarProps from "../interfaces/ISelectionbarProps";
import LabelText from "./generics/LabelText";

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
	padding: 6px 8px;

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
	font-family: "SF Pro Text";
	font-weight: 400;
	font-size: 13px;
	line-height: 20px;
`;

// TODO: fix separator height
const Separator = styled.div`
box-sizing: border-box;
  height: 55%;
  width: 0;
  border: 0.5px solid ${(props) => props.theme.colors.separator}
  border-radius: 0.5px;
`;

export default function SelectionBar(props: ISelectionBarProps) {
	const { label, options } = props.selectionBar;
	const { selectedOption, setOption } = props;

	const renderedOptions = options.map((option) => {
		return (
			<OptionContainer selected={option === selectedOption} onClick = {() => setOption(option)}>
				<OptionText>{option}</OptionText>
			</OptionContainer>
		);
	});

	return (
		<>
			<LabelText>{label}</LabelText>
			<SelectionBarContainer>{renderedOptions}</SelectionBarContainer>
		</>
	);
}
