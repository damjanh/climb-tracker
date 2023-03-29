import React, { useState } from 'react';
import Header from './Header';
import Routes from './Routes';

const Main = (props) => {
  const { logout } = props;
  return (
    <div>
      <Header logout={logout}/>
      <Routes />
    </div>
  )
}

export default Main;