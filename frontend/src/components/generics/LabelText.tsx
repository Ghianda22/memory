import React, { useContext } from "react";
import styled from "styled-components";

const LabelText = styled.h3`
	padding: 13px;
	font-weight: 500;
	font-size: 16px;
	line-height: 120%;
	color: ${(props) => props.theme.text.colors.dark80};
`;

export default LabelText;
