import React from 'react';
import {BrowserRouter as Router, Route, Routes} from 'react-router-dom';
import routes from './Routes';

const AppRouter = () => (
  <Router>
    <Routes>
      {routes.map(({path, component}, i) => (
        <Route key={i} path={path} element={component}/>
      ))}
    </Routes>
  </Router>
);

export default AppRouter;
