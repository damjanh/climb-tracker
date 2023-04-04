const createRoutes = ` create table if not exists routes(
  id int primary key auto_increment,
  title varchar(255) not null,
  description varchar(255) not null,
  length int not null,
  dificulty varchar(255) not null
)`;

module.exports = createRoutes;