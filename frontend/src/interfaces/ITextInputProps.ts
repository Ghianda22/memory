export default interface ITextInputProps {
	image: string,
	placeholder: string,
	fieldName: string,
	handleOnChange: (optionName: string, optionValue: string) => void
}
