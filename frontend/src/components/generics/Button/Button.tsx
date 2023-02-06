import React from "react";
import StyledButton from "./StyledButton";


export default function Button({ buttonStyle, text }: { buttonStyle:string, text:string }) {
	return <StyledButton buttonStyle={buttonStyle}>{text}</StyledButton>;
}
