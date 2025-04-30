import createApiService from "./commonService/baseApiService";

const api = createApiService({
  baseURL: import.meta.env.VITE_API_URL,
});

export const login = (payload) => {
  return api.makeRequest({
    url: "/api/auth/authenticate",
    method: "POST",
    data: payload,
  });
};

export const logout = () => {
  return api.makeRequest({
    url: "/api/auth/logout",
    method: "POST",
  });
};
