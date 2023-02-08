import styled from "styled-components";
import ITextInputProps from "../../interfaces/ITextInputProps";

const InputContainer = styled.div`
	display: flex;
	flex-direction: row;
	justify-content: center;
	align-items: center;
    padding: 16;
    gap: 16px;

	padding: 12px 14px;
	border: 0.5px solid #e2e3e4;
	border-radius: 12px;
`;

const InputIcon = styled.img`
    flex: 3;
	width: 37px;
	
`;
const TextField = styled.input`
	border: none;
	font-weight: 500;
	font-size: 16px;
	color: ${(props) => props.theme.text.colors.dark60};
`;

export default function TextInput(props: ITextInputProps) {
	const { image, placeholder, handleOnChange } = props;
	return (
		<InputContainer>
			{image && <InputIcon src={image} />}
			<TextField onChange={handleOnChange} placeholder={placeholder}/>
		</InputContainer>
	);
}
