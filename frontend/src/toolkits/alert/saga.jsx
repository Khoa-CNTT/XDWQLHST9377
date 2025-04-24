import { all, call, takeEvery } from "redux-saga/effects";

import alertSlice from "./slice";

import {
  clear,
  error,
  info,
  success,
  warning,
} from "../../services/alert.service";

function* infoSaga({ payload }) {
  const message = payload;

  try {
    yield call(info, message);
  } catch (error) {
    console.log(error);
  }
}

function* successSaga({ payload }) {
  const message = payload;

  try {
    yield call(success, message);
  } catch (error) {
    console.log(error);
  }
}

function* warningSaga({ payload }) {
  const message = payload;

  try {
    yield call(warning, message);
  } catch (error) {
    console.log(error);
  }
}

function* errorSaga({ payload }) {
  const message = payload;
  try {
    yield call(error, message);
  } catch (error) {
    console.log(error);
  }
}

function* clearSaga({ payload }) {
  try {
    yield call(clear);
  } catch (error) {
    console.log(error);
  }
}

export default function* saga() {
  yield all([
    takeEvery(alertSlice.actions.info().type, infoSaga),
    takeEvery(alertSlice.actions.success().type, successSaga),
    takeEvery(alertSlice.actions.warning().type, warningSaga),
    takeEvery(alertSlice.actions.error().type, errorSaga),
    takeEvery(alertSlice.actions.clear().type, clearSaga),
  ]);
}
