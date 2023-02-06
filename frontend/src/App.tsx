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

	background-position: top;
	background-size: cover;
	background-repeat: no-repeat;
	background-image: url("data:image/svg+xml,%3Csvg width='376' height='285' viewBox='0 0 376 285' fill='none' xmlns='http://www.w3.org/2000/svg'%3E%3Cpath fill-rule='evenodd' clip-rule='evenodd' d='M161.041 -357.961C214.277 -352.94 263.074 -332.353 307.289 -302.287C352.807 -271.335 396.642 -235.331 416.737 -184.091C437.561 -130.991 435.825 -71.7148 419.097 -17.1862C402.164 38.0116 360.59 77.9921 322.914 121.746C272.05 180.815 237.608 267.846 161.041 282.5C83.2321 297.392 8.93977 242.939 -53.1303 193.718C-113.125 146.143 -165.44 85.1784 -182.044 10.4376C-197.864 -60.7735 -173.612 -134.009 -140.361 -198.939C-111.001 -256.27 -63.7025 -301.846 -6.72937 -331.905C44.5792 -358.976 103.284 -363.409 161.041 -357.961Z' fill='url(%23paint0_linear_602_5679)'/%3E%3Cdefs%3E%3ClinearGradient id='paint0_linear_602_5679' x1='299.5' y1='192' x2='122.5' y2='285' gradientUnits='userSpaceOnUse'%3E%3Cstop stop-color='%23F8F8FA'/%3E%3Cstop offset='1' stop-color='%23F8F8FA' stop-opacity='0'/%3E%3C/linearGradient%3E%3C/defs%3E%3C/svg%3E");
`;

function App() {
	return (
		<ThemeProvider theme={theme}>
			{/* <Background /> */}
			<StyledApp>
				{/* <Title />
				<div>components</div>
				<Button />
				<div>components</div>
				<UserIcon />
				<SelectionBar /> */}
				<StartGame />
			</StyledApp>
		</ThemeProvider>
	);
}

export default App;
