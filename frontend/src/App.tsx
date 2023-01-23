import React from "react";

import styled from "styled-components";

const StyledApp = styled.div`
	width: 100%;
	display: flex;
	flex-direction: column;
	align-items: center;
`;

function App() {
	return (
		<StyledApp>
			<div>components</div>
			<div>components</div>
		</StyledApp>
	);
}

export default App;
