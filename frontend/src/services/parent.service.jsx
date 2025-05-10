import createApiService from "./commonService/baseApiService";

const api = createApiService({
  baseURL: import.meta.env.VITE_API_URL,
});

export const create = (payload) => {
  return api.makeRequest({
    url: "/api/parent/create",
    method: "POST",
    data: payload,
  });
};

export const getall = (payload) => {
  return api.makeRequest({
    url: "/api/parent/listAll",
    method: "GET",
    data: payload,
  });
};

export const deleteParent = (payload) => {
  return api.makeRequest({
    url: `/api/parent/delete/${payload}`,
    method: "DELETE",
  });
};

export const search = (payload) => {
  return api.makeRequest({
    url: `/api/parent/search?name=${payload}`,
    method: "GET",
  });
};
