export default interface ISelectionBarProps {
	areImages: boolean,
	selectionBar: ISelectionBarData,
	selectedOption: string,
	setOption: (optionValue: string) => void
}

interface ISelectionBarData {
    label: string,
    options: string[]
}
