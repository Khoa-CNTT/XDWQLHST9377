import createApiService from "./commonService/baseApiService";

const api = createApiService({
  baseURL: process.env.VITE_API_URL,
});

export const login = (payload) => {
  return api.makeRequest({
    url: "/auth/authenticate",
    method: "POST",
    data: payload,
  });
};

export const logout = () => {
  return api.makeRequest({
    url: "/auth/logout",
    method: "POST",
  });
};
