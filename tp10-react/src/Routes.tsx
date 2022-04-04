import Home from './pages/Home'
import Kanban from "./pages/Kanban";
import User from "./pages/User";

const routes = [
  {
    path: "/",
    name: "Home",
    component: <Home/>,
  },
  {
    path: "/kanban",
    name: "Kanban",
    component: <Kanban/>,
  },
  {
    path: "/user",
    name: "User",
    component: <User/>,
  },
]

export default routes;
