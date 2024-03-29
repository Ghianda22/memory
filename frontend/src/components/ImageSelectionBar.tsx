import React from "react";
import styled, { css } from "styled-components";
import { IImageBarProps } from "../interfaces/ISelectionbarProps";
import LabelText from "./generics/LabelText";

// --- HORIZONTAL LAYOUT ---------------------------------------------------------------------------------
const LayoutContainerX = styled.ul`
	display: flex;
	flex-direction: row;
	justify-content: left;
	align-items: center;
	letter-spacing: -0.08px;
	overflow-y: scroll;

	gap: 48px;
	padding: 9px 11px;

	border-radius: 8px;
`;
const ImageContainerX = styled.li<{ selected: boolean }>`
	display: flex;
	flex-direction: row;
	align-items: center;
	text-align: center;
	letter-spacing: -0.08px;

	padding: 3px;

	${(props) =>
		props.selected &&
		css`
			border: 0.5px solid rgba(0, 0, 0, 0.04);
			box-shadow: 0px 3px 8px rgba(0, 0, 0, 0.12),
				0px 3px 1px rgba(0, 0, 0, 0.04);
			border-radius: 7px;
		`}
`;
const OverflowHandler = styled.div<{ displayOnXAxis: boolean }>`
	${(props) =>
		!props.displayOnXAxis &&
		css`
			overflow: auto;
		`}
	padding-bottom: 10px;
`;
const ImageX = styled.img`
	width: 64px;
`;
// --- VERTICAL LAYOUT ---------------------------------------------------------------------------------
const LayoutContainerY = styled(LayoutContainerX)`
	flex-direction: column;
	justify-content: space-between;
	gap: 5px;
	height: 90%;
`;
//TODO: set a responsive width
const ImageContainerY = styled(ImageContainerX)`
	width: 75%;
	border: 0.5px solid rgba(0, 0, 0, 0.08);
	border-radius: 7px;

	${(props) =>
		props.selected &&
		css`
			border: 0.5px solid rgba(0, 0, 0, 0.04);
			box-shadow: 0px 3px 8px rgba(0, 0, 0, 0.12),
				0px 3px 8px rgba(0, 0, 0, 0.12);
			border-radius: 7px;
		`}
`;
const RadioOption = styled.input`
	width: 0;
`;

export default function SelectionBar(props: IImageBarProps) {
	const { label, options } = props.selectionBar;
	const { displayOnXAxis, selectedOption, optionName, setOption } = props;

	const renderedOptions = options.map((option, i) => {
		const isSelected = option === selectedOption;
		return displayOnXAxis ? (
			<ImageContainerX
				key={i}
				selected={isSelected}
				onClick={() => setOption(optionName, option)}
			>
				<ImageX src={option} alt={option.substring(12)} />
			</ImageContainerX>
		) : (
			<ImageContainerY
				key={i}
				selected={isSelected}
				onClick={() => setOption(optionName, option)}
			>
				<img src={option} alt={option.substring(12)} />
				<RadioOption
					type="radio"
					id={option}
					value={option}
					name={props.selectionBar.label}
					checked={isSelected}
				/>
			</ImageContainerY>
		);
	});

	return (
		<OverflowHandler displayOnXAxis={displayOnXAxis}>
			<LabelText>{label}</LabelText>
			{displayOnXAxis ? (
				<LayoutContainerX>{renderedOptions}</LayoutContainerX>
			) : (
				<LayoutContainerY>{renderedOptions}</LayoutContainerY>
			)}
		</OverflowHandler>
	);
}
