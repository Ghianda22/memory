import React from 'react'
import styled from "styled-components";

const StyledTitle = styled.p`
	font-weight: 600;
	font-size: 32px;
	line-height: 120%;
	color: ${(props) => props.theme.colors.accentBlue100};
`;


export default function Title() {
  return (
    <StyledTitle>
      TITOLO
    </StyledTitle>
  )
}
