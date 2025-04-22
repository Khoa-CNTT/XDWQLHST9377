import { all } from "redux-saga/effects";
import authSaga from "./auth/saga";
import alertSaga from "./alert/saga";

export default function* rootSaga() {
  yield all([authSaga(), alertSaga()]);
}
