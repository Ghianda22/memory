import React, { useContext } from "react";
import styled from "styled-components";
import { StartGameContext } from "../../pages/StartGame";
// import "../../../public/images/icons/dolphin-icon.png"

const DivLogo = styled.div`
	background: linear-gradient(45deg, #554af0, #554af0);
	-webkit-mask-image: linear-gradient(
		90deg,
		${(props) => props.theme.colors.accentBlue100},
		#0000009e
	);
	max-height: 76px;
`;
const Logo = styled.img`
	filter: saturate(0);
	mix-blend-mode: hard-light;
	background-color: white;
`;
// const Logo = styled.img<{ src: String; alt: String }>`
// 	background: linear-gradient(
// 			0deg,
// 			${(props) => props.theme.colors.accentBlue100},
// 			${(props) => props.theme.colors.accentBlue100}
// 		),
// 		url(${({ src }) => src});
// 	background-blend-mode: overlay, normal;
// `;

export default function StartGameTemplate() {
	const context = useContext(StartGameContext);
	return (
		<>
			<DivLogo>
				<Logo src={context.image.src} alt={context.image.alt} />
            </DivLogo>
		</>
	);
}
