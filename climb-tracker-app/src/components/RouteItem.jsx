import React from 'react';

const RouteItem = (props) => {
  const { title, description, grade } = props.route;
  return (
    <div class="card m-3">
      <div class="card-body">
        <h5 class="card-title">{title}</h5>
        <p class="card-text">{description}</p>
        <p class="card-text">{grade}</p>
        <a href="#" class="btn btn-primary">Redpoint</a>
      </div>
    </div>
  )
}

export default RouteItem;