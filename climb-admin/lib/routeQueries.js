const getRoutes = 'SELECT * FROM routes'

const insertRoute = (title, description, length, dificulty) =>
 'INSERT INTO routes (title, description, length, dificulty) VALUES ("' + title + '", "' + description + '" ,' + length + ', "' + dificulty +'");';

const deleteRoute = (id) => 'DELETE FROM routes WHERE id='+ id +';';

module.exports = { getRoutes, insertRoute, deleteRoute };