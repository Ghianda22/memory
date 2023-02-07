import React from "react";
import IButtonProps from "../../../interfaces/IButtonProps";
import StyledButton from "./StyledButton";


export default function Button(props: IButtonProps) {
	const { buttonStyle, text, onClickHandler } = props;
	return (
		<StyledButton buttonStyle={buttonStyle} onClick = {onClickHandler}>
			{text}
		</StyledButton>
	);
}
