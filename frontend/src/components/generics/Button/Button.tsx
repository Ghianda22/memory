import React from "react";
import StyledButton from "./StyledButton";


export default function Button(props: {buttonStyle: string, text: string, onClickHandler: () => void}) {
	const { buttonStyle, text, onClickHandler } = props;
	return (
		<StyledButton buttonStyle={buttonStyle} onClick = {onClickHandler}>
			{text}
		</StyledButton>
	);
}
