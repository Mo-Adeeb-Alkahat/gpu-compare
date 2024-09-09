import React, { Fragment, useState } from "react";
import axios from "axios";

function SignIn() {
  const [password, setPassword] = useState([]);
  const [email, setEmail] = useState([]);

  const handleSubmit = async (e) => {
    e.preventDefault();
    const response = await axios.post("http://localhost:8080/admin/signIn", {
      email: email,
      password: password,
    });
    console.log(response.data);
  };
  const onEmailChange = (e) => {
    setEmail(e.target.value);
  };

  const onPasswordChange = (e) => {
    setPassword(e.target.value);
  };

  return (
    <Fragment>
      <form onSubmit={handleSubmit}>
        <label htmlFor="email">email:</label>
        <input
          type="email"
          id="email"
          name="email"
          value={email}
          onChange={onEmailChange}
        ></input>

        <label htmlFor="password">password</label>
        <input
          type="password"
          id="password"
          name="password"
          value={password}
          onChange={onPasswordChange}
        ></input>

        <input type="submit" value="Submit"></input>
      </form>
    </Fragment>
  );
}

export default SignIn;
