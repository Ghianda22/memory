import React from "react";
import styled from "styled-components";
const StyledIcon = styled.div<{ iconStyle: string }>`
	display: flex;
	align-items: center;
	border: 2px solid ${(props) => props.theme.colors.accentBlue80};
	overflow: hidden;
	border-radius: 50%;
`;
const InnerDiv = styled(StyledIcon)`
	border: 2px solid white;
`;

export default function UserIcon() {
	const path = "../../images/icons/cherry-icon.png";
	return (
		<StyledIcon iconStyle="">
			<InnerDiv iconStyle="">
				<img src={path} alt="cherry-icon" />
			</InnerDiv>
		</StyledIcon>
	);
}
