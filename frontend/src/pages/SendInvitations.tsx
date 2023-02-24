import React from 'react'
import { useParams } from 'react-router-dom'
import SendInvitationsTemplate from "../components/templates/SendInvitationsTemplate";
import { data } from "../data/sendInvitationsData";

export const SendInvitationsContext = React.createContext({...data, numberOfPlayers: 0, unavailableAvatar: ""});

export default function SendInvitations() {
  const params = useParams();
  
  const context = {
    ...data,
    numberOfPlayers: params.numberOfPlayers ? parseInt(params.numberOfPlayers) : 0,
    unavailableAvatar: params.unavailableAvatar ? params.unavailableAvatar : ""
  }
	return (
		<SendInvitationsContext.Provider value={context}>
			<SendInvitationsTemplate />
		</SendInvitationsContext.Provider>
	);
}
