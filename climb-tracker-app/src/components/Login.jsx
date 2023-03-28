import React from "react";

const Login = () => {
  return (
    <div class="jumbotron d-flex align-items-center min-vh-100 d-flex justify-content-center">
      <main class="d-flex justify-content-center form-signin w-100 m-auto">
        <form>
          <h1 class="h3 mb-3 fw-normal">Please sign in</h1>

          <div class="form-floating">
            <input type="email" class="form-control" id="floatingInput" placeholder="name@example.com" />
            <label for="floatingInput">Email address</label>
          </div>
          <div class="form-floating">
            <input type="password" class="form-control" id="floatingPassword" placeholder="Password" />
            <label for="floatingPassword">Password</label>
          </div>
          <button class="w-100 btn btn-lg btn-primary" type="submit">Sign in</button>
          <p class="mt-5 mb-3 text-body-secondary">&copy; 2017–2023</p>
        </form>
      </main>
    </div>
  )
}

export default Login;