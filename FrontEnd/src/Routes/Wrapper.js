import React, { createContext, useContext, useState } from "react";
import { RenderRoutes } from "./RenderRoutes";
import { adopterPrivilege, globalPrivilege, managerPrivilege } from "./routes";

const AuthContext = createContext();
export const GetAuthDataFn = () => useContext(AuthContext);

const defaultPersonState = () => {
  return {
    isAuthorized: false,
    username: "",
    privilege: globalPrivilege,
    personObj: {}
  };
};

function Wrapper() {
  const [person, setPerson] = useState(defaultPersonState());

  return (
    <AuthContext.Provider value={{ person, setPerson }}>
        <RenderRoutes />
    </AuthContext.Provider>
  );
}

export default Wrapper;
