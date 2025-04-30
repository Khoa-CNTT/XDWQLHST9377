import { createSlice } from "@reduxjs/toolkit";

import { getLocalData, setLocalData } from "../../services/localStorage";
import { isLoggedInText, roles } from "../../utils/constants";

const initialState = {
  userData: {
    username: "",
    password: "",
  },
  isLoggedIn: getLocalData(isLoggedInText)
    ? getLocalData(isLoggedInText)
    : false,
  role: getLocalData(roles) ? getLocalData(roles) : "user",
  errorMassage: false,
};

const reducer = createSlice({
  name: "auth",
  initialState,
  reducers: {
    login: (state, action) => {
      state.userData = action.payload;
    },
    loginSuccess: (state, action) => {
      state.isLoggedIn = true;
      state.role = action.payload;
      setLocalData(roles, action.payload);
      setLocalData(isLoggedInText, true);
    },
    logout: (state, action) => {
      state.isLoggedIn = false;
      state.role = "user";
    },
  },
});

export default reducer;
