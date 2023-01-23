import React from "react";

import styled, { ThemeProvider } from "styled-components";
import theme from "./styles/theme";

const StyledApp = styled.div`
	width: 100%;
	display: flex;
	flex-direction: column;
	align-items: center;

	font-family: "Poppins";
	font-style: normal;
	background-color: ${(props) => props.theme.colors.white};
`;

function App() {
	return (
		<ThemeProvider theme={theme}>
			<StyledApp>
				<div>components</div>
				<div>components</div>
			</StyledApp>
		</ThemeProvider>
	);
}

export default App;
