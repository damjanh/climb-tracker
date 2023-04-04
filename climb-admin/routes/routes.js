const express = require('express');
const router = express.Router()
const databaseConnection = require('../lib/db');
const { getRoutes, insertRoute, deleteRoute } = require('../lib/routeQueries');
const sendRoute = require('../publisher');

const allowedDificulties = [
  'DIF_4a', 'DIF_4b', 'DIF_4c',
  'DIF_5a', 'DIF_5b', 'DIF_5c',
  'DIF_6a', 'DIF_6b', 'DIF_6c',
  'DIF_7a', 'DIF_7b', 'DIF_7c',
  'DIF_8a', 'DIF_8b', 'DIF_8c',
  'DIF_9a', 'DIF_9b', 'DIF_9c'
]

router.get('/', async (_, res) => {
  databaseConnection.query(getRoutes, (err, routes) => {
    if (err) {
      res.send(err);
    } else {
      res.send({ routes });
    }
  });
});

router.post('/', async (req, res) => {
  const { title, description, lengthMeters, dificulty } = req.body;
  if (title == undefined || description == undefined || lengthMeters == undefined) {
    res.send(400, 'Invalid body!');
    return;
  }
  if (!allowedDificulties.includes(dificulty)) {
    res.send(400, 'Invalid body!');
    return;
  }

  databaseConnection.query(insertRoute(title, description, lengthMeters, dificulty), (err, routes) => {
    if (err) {
      res.send(err);
    } else {
      const route = {
        title,
        description,
        lengthMeters,
        dificulty
      };
      sendRoute(route);
      res.send(route);
    }
  });
});


module.exports = router;