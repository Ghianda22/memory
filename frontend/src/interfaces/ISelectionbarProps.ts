export interface ISelectionBarProps {
	selectionBar: ISelectionBarData;
	selectedOption: string;
	optionName: string,
	setOption: (optionName: string, optionValue: string) => void
}
export interface IImageBarProps {
	displayOnXAxis: boolean,
	selectionBar: ISelectionBarData,
	selectedOption: string,
	optionName: string,
	setOption: (optionName: string, optionValue: string) => void
}

interface ISelectionBarData {
	label: string;
	options: string[];
}
