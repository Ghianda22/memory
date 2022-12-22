import React from 'react';
import Background from './components/generics/background/Background';
import Start from './components/templates/start/Start';
import dataImages from './data/dataImages';
import dataStart from './data/dataStart';
import dataNewGame from './data/dataNewGame';
import NewGame from './components/templates/newgame/NewGame';


function App() {
  return (
    <div>
        <Background />
        <Start 
          dataImages = {dataImages}
          dataStart = {dataStart}
        />
        {/* <NewGame
          dataNewGame = {dataNewGame}
          dataImages = {dataImages}
        /> */}
    </div>
  );
}

export default App;
