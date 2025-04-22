import { createSlice } from "@reduxjs/toolkit";

import { getLocalData } from "../../services/localStorage";
import { isLoggedInText } from "../../utils/constants";

const initialState = {
  userData: {
    username: "",
    password: "",
  },
  isLoggedIn: getLocalData(isLoggedInText)
    ? getLocalData(isLoggedInText)
    : false,
  role: getLocalData("role") ? getLocalData("role") : "user",
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
    },
    logout: (state, action) => {},
  },
});

export default reducer;
