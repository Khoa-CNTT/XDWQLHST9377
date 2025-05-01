import createApiService from "./commonService/baseApiService";

const api = createApiService({
  baseURL: import.meta.env.VITE_API_URL,
});

export const create = (payload) => {
  return api.makeRequest({
    url: "/api/student/create",
    method: "POST",
    data: payload,
  });
};

export const update = (payload) => {
  return api.makeRequest({
    url: `/api/student/update/${payload}`,
    method: "PUT",
  });
};

export const getall = (payload) => {
  return api.makeRequest({
    url: "/api/student/studentList",
    method: "GET",
    data: payload,
  });
};

export const deleteStudent = (payload) => {
  return api.makeRequest({
    url: `/api/student/delete/${payload}`,
    method: "DELETE",
  });
};

export const search = (payload) => {
  return api.makeRequest({
    url: `/api/student/search?name=${payload}`,
    method: "GET",
  });
};
