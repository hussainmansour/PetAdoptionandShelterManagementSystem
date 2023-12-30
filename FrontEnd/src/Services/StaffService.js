import axios from "axios";

export const serverHost = "http://localhost:8081/manager/shelters";

const handleRequest = async (requestPromise) => {
  try {
    const response = await requestPromise;
    console.log(response.data);
    return response.data;
  } catch (error) {
    return "failed";
  }
};

export const updateStaffMember = async (data, token) => {
  console.log(data);
  console.log(token);
  return handleRequest(
    axios.post("http://localhost:8081/staff/shelters/updateStaffMember", data, {
      headers: {
        Authorization: `Bearer ${token}`,
      },
    })
  );
};

export const insertShelter = async (data, token) => {
  console.log(data);
  return handleRequest(
    axios.post(serverHost + "/insert", data, {
      headers: {
        Authorization: `Bearer ${token}` },
    })
  );
};

export const fetchShelterStaffs = async (shelterName, token) => {
  return handleRequest(
    axios.get(serverHost + "/staffs/" + shelterName, {
      headers: {
        Authorization: `Bearer ${token}` },
    })
  );
};

export const getShelterName = async (staffName, token) => {
  console.log(staffName);
  console.log(token);
  return handleRequest(
    axios.get("http://localhost:8081/staff/shelters/getShelterName/" + staffName, {
      headers: {
        Authorization: `Bearer ${token}`,
      },
    })
  );
};

export const fetchPendingApplications = async (data, token) => {
  console.log(data);
  console.log(token);
  return handleRequest(
    axios.get("http://localhost:8081/test/applications/pending?shelterName=" + data, {
      headers: {
        Authorization: `Bearer ${token}`,
      },
    })
  );
};


export const fetchPets = async (data, token) => {
  console.log(data);
  console.log(token);
  return handleRequest(
    axios.post("http://localhost:8081/test/pets/getAll", data, {
      headers: {
        Authorization: `Bearer ${token}`,
      },
    })
  );
}

export const addPet = async (data, token) => {
  console.log(data);
  console.log(token);
  return handleRequest(
    axios.post("http://localhost:8081/test/pets/insert", data, {
      headers: {
        Authorization: `Bearer ${token}`,
      },
    })
  );
}


export const updateApplication = async (data, token) => {
  console.log(data);
  console.log(token);
  return handleRequest(
    axios.post("http://localhost:8081/test/applications/update", data, {
      headers: {
        Authorization: `Bearer ${token}`,
      },
    })
  );
}

export const insertApplication = async (data, token) => {
  console.log(data);
  console.log(token);
  return handleRequest(
    axios.post("http://localhost:8081/test/applications/insert", data, {
      headers: {
        Authorization: `Bearer ${token}`,
      },
    })
  );
}