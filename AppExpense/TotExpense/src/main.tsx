import React from 'react'
import ReactDOM from 'react-dom/client'
import User from './assets/pages/user/User.tsx'
import './index.css'
import {   createBrowserRouter, RouterProvider} from 'react-router-dom';
import Expense from './assets/pages/expense/Expense.tsx';
import Graph from './assets/pages/graph/Graph.tsx';
import Home from './assets/pages/home/Home.tsx';

const router = createBrowserRouter([
  {
    path: "/user",
    element: <User/>
  },
  {
    path: "/user/:id",
    element: <User/>
  },
  {
    path: "/expense",
    element: <Expense/>
  },
  {
    path: "/graph",
    element: <Graph/>
  },
  {
    path: "/",
    element: <Home/>
  },
]);
ReactDOM.createRoot(document.getElementById('root')!).render(
  <React.StrictMode>
    <RouterProvider router={router}/>
  </React.StrictMode>,
)
