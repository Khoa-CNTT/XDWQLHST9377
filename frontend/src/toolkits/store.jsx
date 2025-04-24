import { configureStore } from "@reduxjs/toolkit";
import rootSaga from "./rootSaga";
import createSagaMiddleware from "redux-saga";
import authSlice from "./auth/slice";
import alertSlice from "./alert/slice";

const sagaMiddleware = createSagaMiddleware();

const middleware = (getDefaultMiddleware) =>
  getDefaultMiddleware().concat(sagaMiddleware);

export const store = configureStore({
  reducer: { auth: authSlice.reducer, alert: alertSlice.reducer },
  middleware,
});

sagaMiddleware.run(rootSaga);
