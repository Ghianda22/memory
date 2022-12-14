import React from 'react';
import './App.css';
import Background from './components/generics/background/Background';
import Start from './components/templates/start/Start';
import dataImages from './data/dataImages';
import dataStart from './data/dataStart';

function App() {
  return (
    <div className="App">
        <Background />
        <Start 
          dataImages = {dataImages}
          dataStart = {dataStart}
        />
    </div>
  );
}

export default App;
