const mysql = require('mysql');
const config = require('./config');
const createRoutes = require('./createRoutes');


const connection = mysql.createPool({
  connectionLimit: 10,
  host: config.database.host,
  user: config.database.user,
  password: config.database.password,
  database: config.database.db,
  port: config.database.port,
});

connection.query((error) => {
  if (!!error) {
    console.log(error);
  } else {
    console.log('DB Connection established!');

    connection.query(createRoutes, function(err, results, fields) {
      if (err) {
        console.log(err.message);
      } else {
        console.log("Created routes table.");
      }
    });
  }
});

module.exports = connection;