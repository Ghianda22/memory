import React from "react";
import styled, { css } from "styled-components";
import {ISelectionBarProps} from "../interfaces/ISelectionbarProps";
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
	background-color: ${(props) =>props.theme.colors.selector};
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
//TODO: fix again this damn separator height
// the div wrapping the return causes this somehow
const Separator = styled.div`
  height: 55%;
  width: 0;
  border: 0.5px solid ${(props) => props.theme.colors.separator}
  border-radius: 0.5px;
`;


export default function SelectionBar(props: ISelectionBarProps) {
	// state?
	const { label, options } = props.selectionBar;
	const { optionName, selectedOption, setOption } = props;

	const renderedOptions = options.map((option, i) => {
		const isSelected = option === selectedOption;
			const next = options[i + 1];
			const nextNotSelected = next != null && next !== selectedOption;
			return (
				<>
					<OptionContainer
						key={i}
						selected={isSelected}
						onClick={() => setOption(optionName, option)}
					>
						<OptionText>{option}</OptionText>
					</OptionContainer>
					{!isSelected && nextNotSelected && <Separator />}
				</>
			);

	});

	return (
		<div>
			<LabelText>{label}</LabelText>
			<SelectionBarContainer>{renderedOptions}</SelectionBarContainer>
		</div>
	);
}
