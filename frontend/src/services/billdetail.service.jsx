import { method } from "lodash";
import createApiService from "./commonService/baseApiService";

const api = createApiService({
  baseURL: import.meta.env.VITE_API_URL,
});

export const update = (payload) => {
  return api.makeRequest({
    url: `/api/billdetail/update/${payload.id}`,
    method: "PUT",
    data: {
      description: payload.description,
      amount: payload.amount,
      currency: payload.currency,
      studentId: payload.studentId,
      parentId: payload.parentId,
    },
  });
};

export const get = (payload) => {
  return api.makeRequest({
    url: `/api/billdetail/get/${payload}`,
    method: "GET",
    data: payload,
  });
};
