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

function isLoggedIn() {
  return localStorage.getItem("isLoggedIn") === "true";
}

function GuestGuard({ children }) {
  if (isLoggedIn()) {
    return <Navigate to={"/"} />;
  }
  return <>{children}</>;
}

function ProtectedRoute({ children }) {
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
        <Route path="/" element={<PageContent />}></Route>
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
