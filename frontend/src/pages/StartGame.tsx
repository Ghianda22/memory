import React from 'react';
import StartGameTemplate from '../components/templates/StartGameTemplate';
import { data } from '../data/start';

export const StartGameContext = React.createContext(data);

export default function StartGame() {
  return (
    <StartGameContext.Provider value={data}>
      <StartGameTemplate />
    </StartGameContext.Provider>
  )
}
