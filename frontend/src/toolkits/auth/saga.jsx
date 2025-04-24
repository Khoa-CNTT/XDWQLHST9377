import { all, call, put, takeEvery } from "redux-saga/effects";

import { login, logout } from "../../services/auth.service";
import { removeLocalData, setLocalData } from "../../services/localStorage";
import { isLoggedInText } from "../../utils/constants";
import authSlice from "./slice";
import alertSlice from "../alert/slice";

function* loginSaga({ payload }) {
  try {
    const response = yield call(login, payload);
    if (response.status === 200) {
      const data = response.data;
      const { accessToken, role } = data;
      if (accessToken) {
        setLocalData(isLoggedInText, true);
        setLocalData("accessToken", accessToken);
        setLocalData("role", role);
        yield put(authSlice.actions.loginSuccess(role));
        window.location.reload();
        yield put(alertSlice.actions.success("Đăng nhập thành công"));
      } else {
        console.log("**Error");
      }
    } else {
      yield put(alertSlice.actions.error("Đăng nhập không thành công"));
      console.log("** API error");
    }
  } catch (e) {
    yield put(alertSlice.actions.error("Đăng nhập không thành công"));
    console.log(e);
  }
}

function* logoutSaga() {
  try {
    const response = yield call(logout);
    if (response.status === 200) {
      yield put(alertSlice.actions.success("Đăng xuất thành công"));
      console.log("Đăng xuất thành công");
    } else {
      console.log("** API error");
    }
  } catch (e) {
    console.log(e);
  } finally {
    removeLocalData(isLoggedInText);
    removeLocalData("accessToken");
    removeLocalData("role");
    window.location.reload();
  }
}

export default function* saga() {
  yield all([
    takeEvery(authSlice.actions.login().type, loginSaga),
    takeEvery(authSlice.actions.logout().type, logoutSaga),
  ]);
}
