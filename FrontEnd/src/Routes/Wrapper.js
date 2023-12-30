import React, { createContext, useContext, useState } from "react";
import { RenderRoutes } from "./RenderRoutes";
import { QueryClient, QueryClientProvider } from 'react-query';
import { adopterPrivilege, globalPrivilege, managerPrivilege } from "./routes";

const AuthContext = createContext();
export const GetAuthDataFn = () => useContext(AuthContext);

const defaultPersonState = () => {
  return {
    isAuthorized: false,
    username: "",
    privilege: "GLOBAL",
    personObj: {}
  };
};

function Wrapper() {
  const [person, setPerson] = useState(defaultPersonState());
  const queryClient = new QueryClient();
  return (
    <AuthContext.Provider value={{ person, setPerson }}>
      <QueryClientProvider client={queryClient}>
        <RenderRoutes />
      </QueryClientProvider>
    </AuthContext.Provider>
  );
}

export default Wrapper;
