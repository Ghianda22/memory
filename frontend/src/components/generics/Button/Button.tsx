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
	const buttonType = props.type ? props.type : "button";
	return (
		<StyledButton
			type={buttonType}
			buttonStyle={buttonStyle}
			onClick={onClickHandler}
		>
			{text}
		</StyledButton>
	);
}
