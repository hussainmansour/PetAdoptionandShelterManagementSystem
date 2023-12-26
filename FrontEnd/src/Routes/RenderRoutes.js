import { Route, Routes } from "react-router-dom";
import { GetAuthDataFn } from "./Wrapper";
import { nav } from "./routes";

export const RenderRoutes = () => {
  const { person } = GetAuthDataFn();

  function jsxRoute(r, i) {
    return <Route key={i} path={r.path} element={r.element} />;
  }

  return (
    <Routes>
      {nav.map((r, i) => {
        return isValidRoute(r, i, person, jsxRoute);
      })}
    </Routes>
  );
};

function isValidRoute(r, i, person, jsxFn) {
  if (r.status === person.privilege || r.Title === "404") {
    return jsxFn(r, i);
  }
  return false;
}
