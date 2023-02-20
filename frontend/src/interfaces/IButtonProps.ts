export default interface IButtonProps{
    buttonStyle: "normal" | "secondary" | "delicate" | "negative",
    text: string,
    onClickHandler: () => void
}