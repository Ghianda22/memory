import React, { useContext } from "react";
import styled from "styled-components";

const Title = styled.h1`
	padding: 11px;
	font-weight: 600;
	font-size: 32px;
	line-height: 120%;
	color: ${(props) => props.theme.colors.accentBlue100};
`;

export default Title;
