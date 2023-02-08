import React from "react";
import styled, { css } from "styled-components";
import ISelectionBarProps from "../interfaces/ISelectionbarProps";
import LabelText from "./generics/LabelText";

// --- TEXT SELECTION ---------------------------------------------------------------------------------
const SelectionBarContainer = styled.div<{ areImages: boolean }>`
	display: flex;
	flex-direction: row;
	justify-content: center;
	align-items: center;
	text-align: center;
	letter-spacing: -0.08px;

	height: fit-content;
	padding: 2px;
	${(props) =>
		props.areImages &&
		css`
			gap: 48px;
			justify-content: left;
			padding: 0px 11px;

		`}

	background-color: ${(props) =>
		props.areImages ? "none" : props.theme.colors.selector};
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

const Separator = styled.div`
  height: 55%;
  width: 0;
  border: 0.5px solid ${(props) => props.theme.colors.separator}
  border-radius: 0.5px;
`;

// --- IMAGES SELECTION ---------------------------------------------------------------------------------
const SelectionImageContainer = styled.div``;
//TODO: set a responsive width
const ImageContainer = styled.div`
	width: 64px;
`;
const ImageOption = styled.img``;

export default function SelectionBar(props: ISelectionBarProps) {
	// state?
	const { label, options } = props.selectionBar;
	const { areImages, selectedOption, setOption } = props;

	const renderedOptions = options.map((option, i) => {
		const isSelected = option === selectedOption;
		if (areImages) {
			return (
				<>
					<ImageContainer>
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

		// separator just if 2 consequentely not selected
		// const next = options[i + 1];
		// const nextNotSelected = next != null && next !== selectedOption;
		// return (
		// 	<>
		// 		<OptionContainer
		// 			selected={isSelected}
		// 			onClick={() => setOption(option)}
		// 		>
		// 			{areImages
		// 				? <img src={option} alt={option.substring(12)} />
		// 				: <OptionText>{option}</OptionText>
		// 			}
		// 		</OptionContainer>
		// 		{!isSelected && nextNotSelected && <Separator />}
		// 	</>
		// );
	});

	return (
		<div>
			<LabelText>{label}</LabelText>
			{/* {areImages 
				? 
				: <SelectionBarContainer>{renderedOptions}</SelectionBarContainer>
			} */}
			<SelectionBarContainer areImages={areImages}>
				{renderedOptions}
			</SelectionBarContainer>
		</div>
	);
}
