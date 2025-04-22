import { createSlice } from "@reduxjs/toolkit";

const initialState = {
  message: "",
  customAlert: {
    id: "",
    message: "",
    color: "",
    icon: "",
  },
  isModal: false,
  status: 0,
};

const reducer = createSlice({
  name: "alert",
  initialState,
  reducers: {
    info: (state, action) => {
      state.message = action.payload;
    },
    success: (state, action) => {
      state.message = action.payload;
    },
    warning: (state, action) => {
      state.message = action.payload;
    },
    error: (state, action) => {
      state.message = action.payload;
    },
    clear: (state, action) => {},
    custom: (state, action) => {
      state.customAlert = action.payload;
      state.isModal = true;
    },
    removeCustom: (state, action) => {
      state.customAlert = {
        id: "",
        message: "",
        color: "",
        icon: "",
      };
      state.isModal = false;
    },
  },
});

export default reducer;
