import React, { useEffect, useState } from 'react';
import { useCookies } from "react-cookie";

import RouteItem from './RouteItem';

const Routes = () => {

  const [routes, setRoutes] = useState([]);
  const [cookies, setCookie] = useCookies();

  useEffect(() => {
    const requestRoutes = async () => {
      await fetch('http://localhost:8080/routes', {
        headers: {
          'Authentication': 'Bearer ' + cookies.climbtracker
        }
      }).then((response) => {
        if (response.status === 200) {
          return response.json();
        } else {
          throw Error(response.status);
        }
      })
        .then((data) => {
          setRoutes(data);
          console.log(data);
        });
    };

    requestRoutes();
  }, []);

  return (
    routes.map(route => {
      return <RouteItem key={route.id} route={route} />;
    })
  )

}

export default Routes;