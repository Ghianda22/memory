import React, { useContext } from 'react'
import { useNavigate } from "react-router-dom";
import styled from 'styled-components';
import { SendInvitationsContext } from '../../pages/SendInvitations';
import Title from '../generics/Title';

const FullPage = styled.div`
	display: flex;
	height: 100%;
	flex-direction: column;
`;

export default function SendInvitationsTemplate() {
    const context = useContext(SendInvitationsContext);
	const navigate = useNavigate();
  return (
      <FullPage>
          <Title>{context.title}</Title>
    </FullPage>
  )
}
