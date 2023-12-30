import axios from "axios";

export const serverHost = "http://localhost:8081/test/pets";

const handleRequest = async (requestPromise) => {
  try {
    const response = await requestPromise;
    console.log(response.data);
    return response.data;
  } catch (error) {
    return "failed";
  }
};


export const fetchApplications = async (data, token) => {
    console.log(data);
    console.log(token);
    return handleRequest(
        axios.get(serverHost + "/non-adopted", {
        headers: {
            Authorization: `Bearer ${token}`,
        },
        })
    );
};

