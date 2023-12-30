import axios from "axios";

export const serverHost = "http://localhost:8081";

const handleRequest = async (requestPromise) => {
  try {
    const response = await requestPromise;
    return response.data;
  } catch (error) {
    return "failed";
  }
};

export const register = async (data) => {
  return handleRequest(axios.post(serverHost + "/auth/register", data));
};

export const login = async (data) => {
  return handleRequest(axios.post(serverHost + "/auth/login", data));
}