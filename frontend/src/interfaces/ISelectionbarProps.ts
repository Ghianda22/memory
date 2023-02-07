export default interface ISelectionBarProps {
	selectionBar: ISelectionBarData,
	selectedOption: string,
	setOption: (optionValue: string) => void
}

interface ISelectionBarData {
    label: string,
    options: string[]
}
