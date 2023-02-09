import React from "react";
import styled, { css } from "styled-components";
import ISelectionBarProps from "../interfaces/ISelectionbarProps";
import LabelText from "./generics/LabelText";

// --- TEXT SELECTION ---------------------------------------------------------------------------------
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
const Separator = styled.div`
  height: 55%;
  width: 0;
  border: 0.5px solid ${(props) => props.theme.colors.separator}
  border-radius: 0.5px;
`;

// --- IMAGES SELECTION ---------------------------------------------------------------------------------
const SelectionImageContainer = styled(SelectionBarContainer)`
	gap: 48px;
	justify-content: left;
	padding: 0px 11px;
	background: none;
`;
//TODO: set a responsive width
const ImageContainer = styled(OptionContainer)<{ selected: boolean }>`
	width: 64px;
	padding: 3px;
`;

export default function SelectionBar(props: ISelectionBarProps) {
	// state?
	const { label, options } = props.selectionBar;
	console.log(options);
	const { areImages, selectedOption, setOption } = props;

	const renderedOptions = options.map((option, i) => {
		const isSelected = option === selectedOption;
		if (areImages) {
			return (
				<>
					<ImageContainer
						selected={isSelected}
						onClick={() => setOption(option)}
					>
						<img src={option} alt={option.substring(12)} />
					</ImageContainer>
				</>
			);
		} else {
			// separator just if 2 consequentely not selected
			const next = options[i + 1];
			const nextNotSelected = next != null && next !== selectedOption;
			return (
				<>
					<OptionContainer
						selected={isSelected}
						onClick={() => setOption(option)}
					>
						<OptionText>{option}</OptionText>
					</OptionContainer>
					{!isSelected && nextNotSelected && <Separator />}
				</>
			);
		}

	});

	return (
		<div>
			<LabelText>{label}</LabelText>
			{areImages ? (
				<SelectionImageContainer>
					{renderedOptions}
				</SelectionImageContainer>
			) : (
				<SelectionBarContainer>{renderedOptions}</SelectionBarContainer>
			)}
		</div>
	);
}
