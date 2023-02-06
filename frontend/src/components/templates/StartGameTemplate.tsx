import React, { useContext } from 'react'
import { StartGameContext } from '../../pages/StartGame'
// import "../../../public/images/icons/dolphin-icon.png"


export default function StartGameTemplate() {
    const context = useContext(StartGameContext)
  return (
      <>
          <img src={context.image.src} alt={context.image.alt} />
      </>
  )
}
