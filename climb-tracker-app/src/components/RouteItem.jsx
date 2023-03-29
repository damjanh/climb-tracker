import React from 'react';

const RouteItem = (props) => {
  const { title, description, grade } = props.route;
  return (
    <div className="card m-3">
      <div className="card-body">
        <h5 className="card-title">{title}</h5>
        <p className="card-text">{description}</p>
        <p className="card-text">{grade}</p>
        <a href="#" className="btn btn-primary">Redpoint</a>
      </div>
    </div>
  )
}

export default RouteItem;