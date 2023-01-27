import React from "react";

import styled, { ThemeProvider } from "styled-components";
import Button from "./components/generics/Button";
import Title from "./components/generics/Title";
import UserIcon from "./components/generics/UserIcon";
import theme from "./styles/theme";

const StyledApp = styled.div`
	width: 100%;
	display: flex;
	flex-direction: column;
	align-items: center;

	font-family: "Poppins";
	font-style: normal;
	line-height: 24px;
	background-color: ${(props) => props.theme.colors.white};
`;

function App() {
	return (
		<ThemeProvider theme={theme}>
			<StyledApp>
				<Title/>
				<div>components</div>
				<Button/>
				<div>components</div>
				<UserIcon/>
			</StyledApp>
		</ThemeProvider>
	);
}

export default App;
