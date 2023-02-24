export default interface IButtonProps {
	type?: "button" | "submit" | "reset" | undefined;
	buttonStyle: string;
	text: string;
	onClickHandler: () => void;
}
