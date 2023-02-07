import React from 'react'
import { useParams } from 'react-router-dom'
import SendInvitationsTemplate from "../components/templates/SendInvitationsTemplate";
import { data } from "../data/sendInvitationsData";

export const SendInvitationsContext = React.createContext(data);

export default function SendInvitations() {
  const params = useParams();
  console.log(params);
	return (
		<SendInvitationsContext.Provider value={data}>
			<SendInvitationsTemplate />
		</SendInvitationsContext.Provider>
	);
}
