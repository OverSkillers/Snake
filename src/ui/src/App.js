import React from 'react';
import board from './board.PNG';
import './App.css';
import UserComponent from './component/UserComponent';

function App() {


    function refreshPage() {
        window.location.reload(false);
    }

    return (
        <div className="App">
            <UserComponent />
            <img src={board} />
            <div>
                <button onClick={refreshPage}>Click to refresh the scoreboard</button>
            </div>
        </div>
    );
}

export default App;

