import { ChangeEventHandler } from "react";

export default interface ITextInputProps {
	image: string,
	placeholder: string,
	handleOnChange: ChangeEventHandler
}
