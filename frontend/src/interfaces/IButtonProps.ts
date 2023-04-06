export default interface IButtonProps {
    type?: "button" | "submit" | "reset" | undefined;
    buttonStyle: "normal" | "secondary" | "delicate" | "negative";
    text: string;
    onClickHandler: () => void;
}
