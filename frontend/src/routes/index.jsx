import {
  Navigate,
  Outlet,
  Route,
  Routes,
  createHashRouter,
  useLocation,
  useNavigate,
} from "react-router-dom";

import { useEffect } from "react";
import Error404 from "../screens/errorpage/Error";
import { isLoggedInText } from "../utils/constants";
import { getLocalData } from "../services/localStorage";
import Dashboard from "../layouts";
import SignInSide from "../screens/login/login.screen";
import HomePage from "../screens/home/home.screen";

function isLoggedIn() {
  return getLocalData(isLoggedInText);
}

function GuestGuard({ children }) {
  console.log(children);
  if (isLoggedIn()) {
    return <Navigate to={"/"} />;
  }
  return <>{children}</>;
}

function ProtectedRoute({ children }) {
  // console.log("**log protected");
  // console.log(isLoggedIn());
  if (!isLoggedIn()) {
    return <Navigate to={"/login"} />;
  }
  return children ? children : <Outlet />;
}

function MainRoutes() {
  const navigate = useNavigate();
  const location = useLocation();

  useEffect(() => {
    if (location.pathname === "/") {
      navigate("/home", { replace: true });
    } else if (
      !isLoggedIn() &&
      location.pathname !== "/login" &&
      location.pathname !== "/home"
    ) {
      navigate("home", { replace: true });
    }
  }, [navigate, isLoggedIn, location.pathname]);

  return (
    <Routes>
      <Route path="/home" element={<HomePage />} />
      <Route path="*" element={<Error404 />} />
      <Route
        path="/login"
        element={
          <GuestGuard>
            <SignInSide />
          </GuestGuard>
        }
      />
      <Route element={<ProtectedRoute />}>
        <Route path="/" element={<Dashboard />} />
      </Route>
    </Routes>
  );
}

export const router = createHashRouter([
  {
    path: "*",
    Component: MainRoutes,
    errorElement: <Error404 />,
  },
]);
