export interface ISelectionBarProps {
	selectionBar: ISelectionBarData;
	selectedOption: string;
	setOption: (optionValue: string) => void;
}
export interface IImageBarProps {
	displayOnXAxis: boolean;
	selectionBar: ISelectionBarData;
	selectedOption: string;
	setOption: (optionValue: string) => void;
}

interface ISelectionBarData {
	label: string;
	options: string[];
}
