import {
  Navigate,
  Outlet,
  Route,
  Routes,
  createHashRouter,
} from "react-router-dom";
import PageContent from "../layouts/Pagecontent";
import SignInSide from "../screens/login/Login";
import Error404 from "../screens/errorpage/Error";
import Dashboard from "../layouts";
import { isLoggedInText } from "../utils/constants";
import { getLocalData } from "../services/localStorage";

function isLoggedIn() {
  return getLocalData(isLoggedInText);
}

function GuestGuard({ children }) {
  console.log();
  if (isLoggedIn()) {
    return <Navigate to={"/"} />;
  }
  return <>{children}</>;
}

function ProtectedRoute({ children }) {
  console.log("**log protected");
  console.log(isLoggedIn());
  if (!isLoggedIn()) {
    return <Navigate to={"/login"} />;
  }
  return children ? children : <Outlet />;
}

function MainRoutes() {
  return (
    <Routes>
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
