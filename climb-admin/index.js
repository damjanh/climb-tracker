const express = require('express');
const app = express();
const expressValidator = require('express-validator');
const bodyParser = require('body-parser');

const routes = require('./routes/routes');

app.use(bodyParser.urlencoded({ extended: true }))
app.use(bodyParser.json());

app.use('/routes', routes);

app.listen(8081, () => {
  console.log('Server running...');
});





