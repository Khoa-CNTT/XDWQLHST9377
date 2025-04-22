import { RouterProvider } from "react-router-dom";
import { router } from "./routes";
import { Provider } from "react-redux";
import { store } from "./toolkits/store";

function App() {
  return (
    <Provider store={store}>
      <RouterProvider
        future={{
          v7_relativeSplatPath: true,
          v7_fetcherPersist: true,
          v7_normalizeFormMethod: true,
          v7_partialHydration: true,
          v7_skipActionErrorRevalidation: true,
          v7_startTransition: true,
        }}
        router={router}
      />
    </Provider>
  );
}

export default App;
