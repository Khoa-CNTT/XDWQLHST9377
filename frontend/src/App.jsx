import { BrowserRouter, Routes, Route } from "react-router";
import { router } from "./routers";
import { RouterProvider } from "react-router-dom";

function App() {
  return (
    <BrowserRouter>
      <RouterProvider router={router} />
    </BrowserRouter>
  );
}

export default App;
