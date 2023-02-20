import React from "react";
import styled from "styled-components";
const StyledIcon = styled.div`
	display: flex;
	align-items: center;
	border: 2px solid ${(props) => props.theme.colors.accent80};
	overflow: hidden;
	border-radius: 50%;
	width: 40px;
`;
const InnerDiv = styled(StyledIcon)`
	border: 1px solid ${(props) => props.theme.colors.white};
	background: ${(props) => props.theme.colors.white};
`;

export default function UserIcon({ image }: { image: string }) {
	return (
		<StyledIcon>
			<InnerDiv>
				<img src={image} alt={image.substring(13)} />
			</InnerDiv>
		</StyledIcon>
	);
}
