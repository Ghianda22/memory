import styled, { css } from "styled-components";
import Button from "./Button/Button";

export const ShadowDiv = styled.div`
	display: flex;
	align-items: center;
	justify-content: center;
	width: 100%;
	height: 100%;
	left: 0;
	top: 0;
	position: fixed;
	z-index: 1;
	background-color: rgba(0, 0, 0, 0.4);
`;
export const ModalDiv = styled.div`
	width: 80%;
	height: 65%;
	border-radius: 10px;
	background-color: #ffffff;
	position: absolute;
	z-index: 2;
	padding: 30px;
`;

export default function Modal(props: any) {
	const { children, closeModal, text } = props;

	return (
		<ShadowDiv>
			<ModalDiv>
				{children}
				<Button
					buttonStyle={"normal"}
					text={text}
					onClickHandler={closeModal}
				/>
			</ModalDiv>
		</ShadowDiv>
	);
}
