import React from "react";
import IButtonProps from "../../../interfaces/IButtonProps";
import StyledButton from "./StyledButton";

/* STYLES:
* normal
* secondary
* delicate
* negative
*/
export default function Button(props: IButtonProps) {
	const { buttonStyle, text, onClickHandler } = props;
	return (
		<StyledButton buttonStyle={buttonStyle} onClick = {onClickHandler}>
			{text}
		</StyledButton>
	);
}
