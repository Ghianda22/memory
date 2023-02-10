import { useState, useContext } from "react";
import styled from "styled-components";
import { images } from "../../data/imagesData";
import { SendInvitationsContext } from "../../pages/SendInvitations";
import LabelText from "../generics/LabelText";
import TextInput from "../generics/TextInput";
import Title from "../generics/Title";

const FullPage = styled.div`
	display: flex;
	height: 100%;
	flex-direction: column;
`;

export default function SendInvitationsTemplate() {
	const context = useContext(SendInvitationsContext);
	const [contacts, setContacts] = useState<string[]>([]);
	let avatarIcons: string[] = images.icon;
	avatarIcons.filter((icon) => icon !== context.unavailableAvatar);

  const updateContacts = (name: string, value: string) => {
    setContacts(contacts.map((val, i) => i === parseInt(name) ? value : val));
  }

  const renderInputs: JSX.Element[] = [];
		for (let i = 0; i < context.numberOfPlayers-1; i++) {
      renderInputs[i] =
        <>
          <LabelText>{context.label + " " + (i + 1)}</LabelText>
          <TextInput
            image={avatarIcons[i]}
            placeholder={context.placeholder}
            fieldName={`${i}`}
            handleOnChange={updateContacts}
          />
        </>;
  };

	return (
		<FullPage>
			<Title>{context.title}</Title>
			{renderInputs}
		</FullPage>
	);
}
