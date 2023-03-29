import jwtDecode from "jwt-decode";

const getUserFromToken = (token) => {
  try {
    console.log(token);

    const {sub, exp} = jwtDecode(token);
    if (exp < (new Date().getTime() + 1) / 1000) {
      return undefined;
    }

    return {
      userName: sub
    }
    
  } catch (error) {
    console.log(error);
    return undefined;
  }
}

export { getUserFromToken };

