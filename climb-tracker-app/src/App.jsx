import Login from './components/Login';
import Main from './components/Main';

import React from 'react';
import { useCookies } from "react-cookie";
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import { getUserFromToken } from './services/authServices';

function App() {
  const [cookies, setCookie] = useCookies();
  const user = getUserFromToken(cookies.climbtracker);

  if (user === undefined) {
    return (
      <Login />
    )
  }

  const logout = () => {
    setCookie('climbtracker', undefined);
    console.log('Logged out');
  }

  return (
    <div className="App">
      <BrowserRouter>
        <Routes>
          <Route path='/' element={<Main logout={logout} />} />
          <Route path='/login' element={<Login />} />
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
