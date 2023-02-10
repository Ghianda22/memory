import React from 'react'
import { useParams } from 'react-router-dom'

export default function SendInvitations() {
  const params = useParams();
  console.log(params);
  return (
    <div>SendInvitations    { params.numberOfPlayers}</div>
  )
}
