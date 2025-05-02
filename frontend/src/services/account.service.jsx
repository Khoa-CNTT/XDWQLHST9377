import { roles } from "../utils/constants";
import createApiService from "./commonService/baseApiService";
import { getLocalData } from "./localStorage";

const api = createApiService({
  baseURL: import.meta.env.VITE_API_URL,
});

const getCurrentLoggedInUser = () => {
  const token = getLocalData("accessToken");
  const role = getLocalData(roles);
  if (token && role) {
    return { token, role };
  }
  return null;
};

export const create = (payload) => {
  return api.makeRequest({
    url: "/api/account/create",
    method: "POST",
    data: payload,
  });
};

export const update = (payload) => {
  return api.makeRequest({
    url: `/api/account/update/${payload.id}`,
    method: "PUT",
    data: {
      username: payload.username,
      password: payload.password,
      role: payload.role,
    },
  });
};

export const getall = (payload) => {
  return api.makeRequest({
    url: "/api/account/listacc",
    method: "GET",
    data: payload,
  });
};

export const deleteAccount = (payload) => {
  const token = getLocalData("accessToken");
  const loggedInUser = getCurrentLoggedInUser();

  if (!token) {
    console.error("No accessToken found!");
    return;
  }

  if (
    loggedInUser &&
    loggedInUser.token === token &&
    loggedInUser.role === "ADMIN"
  ) {
    console.warn("Không thể xóa tài khoản ADMIN hiện tại đang đăng nhập.");
    return;
  }

  return api.makeRequest({
    url: `/api/account/delete/${payload}`,
    method: "DELETE",
    headers: {
      Authorization: `Bearer ${token}`,
    },
  });
};

export const search = (payload) => {
  return api.makeRequest({
    url: `/api/account/search?name=${payload}`,
    method: "GET",
  });
};
