import React, { useContext } from "react";
import styled from "styled-components";

const Title = styled.h1`
	padding: 0px 11px;
	margin-bottom: 28px;
	font-weight: 600;
	font-size: 32px;
	line-height: 120%;
	color: ${(props) => props.theme.colors.accent100};
`;

export default Title;
