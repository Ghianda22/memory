import styled from "styled-components";
import ITextInputProps from "../../interfaces/ITextInputProps";

const InputContainer = styled.div`
	display: flex;
	flex-direction: row;
	justify-content: center;
	align-items: center;
    padding: 16;
    gap: 16px;

	padding: 16px 20px;
	border: 0.5px solid #e2e3e4;
	border-radius: 12px;

	font-weight: 600;
	font-size: 16px;
	color: ${(props) => props.theme.text.colors.dark60};
`;

const InputIcon = styled.img`
    flex: 3;
`;
const TextField = styled.input`
    border: none;
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
