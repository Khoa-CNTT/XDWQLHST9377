import axios from "axios";

import { getLocalData, removeLocalData } from "../localStorage";

const baseApi = axios.create({
  baseURL: `${import.meta.env.VITE_API_URL}`,
});

baseApi.interceptors.request.use(
  (config) => {
    const accessToken = getLocalData("accessToken");
    if (accessToken) {
      config.headers["Authorization"] = `Bearer ${accessToken}`;
    }

    return Promise.resolve(config);
  },

  (error) => {
    return Promise.reject(error);
  }
);

baseApi.interceptors.response.use(
  (response) => {
    return Promise.resolve(response);
  },

  (error) => {
    if (
      error.response?.status === 401 &&
      !error.config?.url?.includes("/users/authenticate")
    ) {
      removeLocalData("isLoggedIn");
      removeLocalData("accessToken");
      // removeLocalData("role");
      window.location.reload();
    }

    return Promise.reject(error);
  }
);

const _makeRequest = (createRequest, options) => async (args) => {
  console.log(args);
  const _headers = args.headers ? args.headers : {};
  const body = args.body ? args.body : {};
  const defaultHeaders = {};

  const mergedArgs = {
    ...args,
    headers: {
      ...defaultHeaders,
      ..._headers,
      "Access-Control-Allow-Origin": "*",
      "Access-Control-Allow-Headers":
        "Origin, X-Requested-With, Content-Type, Accept",
    },
    body,
    ...options,
  };

  console.log("Making request to:", mergedArgs);

  try {
    const response = await createRequest(mergedArgs);
    console.log("Make request", response);
    return response;
  } catch (e) {
    // console.log(e);
    // console.error("API request Error:", e.response?.data || e);
    throw e;
  }
};

const baseService = (options = {}) => {
  return {
    makeRequest: _makeRequest(baseApi, options),
  };
};

export default baseService;
