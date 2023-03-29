import React, { useState } from "react";
import { useCookies } from "react-cookie";


const Login = () => {
  const [cookies, setCookie] = useCookies();

  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');

  const login = async () => {
    await fetch('http://localhost:8080/api/auth/signin', {
      method: 'POST',
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
          username,
          password
        })
      }
    ).then((response) => {
      if (response.status === 200) {
        return response.json();
      } else {
        throw Error(response.status);
      }
    })
    .then((data) => {
      console.log(data);
      setCookie('climbtracker', data.token);
    })
  }

  const submit = (event) => {
    event.preventDefault();
    login();
  }

  return (
    <div className="jumbotron d-flex align-items-center min-vh-100 d-flex justify-content-center">
      <main className="d-flex justify-content-center form-signin w-100 m-auto">
        <form onSubmit={submit}>
          <h1 className="h3 mb-3 fw-normal">Please sign in</h1>

          <div className="form-floating">
            <input type="" className="form-control" id="floatingInput" placeholder="Username" onChange={e => setUsername(e.target.value)}/>
            <label htmlFor="floatingInput">Username</label>
          </div>
          <div className="form-floating">
            <input type="password" className="form-control" id="floatingPassword" placeholder="Password" onChange={e => setPassword(e.target.value)}/>
            <label htmlFor="floatingPassword">Password</label>
          </div>
          <button className="w-100 btn btn-lg btn-primary" type="submit">Sign in</button>
          <p className="mt-5 mb-3 text-body-secondary">&copy; 2017–2023</p>
        </form>
      </main>
    </div>
  )
}

export default Login;