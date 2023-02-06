import React from "react";

import styled, { ThemeProvider } from "styled-components";
import Button from "./components/generics/Button/Button";
import Title from "./components/generics/Title";
import UserIcon from "./components/generics/UserIcon";
import SelectionBar from "./components/SelectionBar";
import StartGame from "./pages/StartGame";
import theme from "./styles/theme";

const StyledApp = styled.div`
	display: flex;
	width: auto;
	flex-direction: column;
	align-items: center;
	padding: 32px 24px;

	font-family: "Poppins";
	font-style: normal;
	line-height: 24px;
	background-color: ${(props) => props.theme.colors.white};
`;

function App() {
	return (
		<ThemeProvider theme={theme}>
			<StyledApp>
				{/* <Title />
				<div>components</div>
				<Button />
				<div>components</div>
				<UserIcon />
				<SelectionBar /> */}
				<StartGame/>
			</StyledApp>
		</ThemeProvider>
	);
}

export default App;
