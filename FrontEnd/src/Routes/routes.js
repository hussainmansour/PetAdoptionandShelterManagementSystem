import Login from "../Components/Registeration/Login";
import Signup from "../Components/Registeration/Signup";
import Error from "../Components/Error/Error";
import SampleTest1 from "../Components/Adopter/SampleTest";
import ManagerGroups from "../Components/Shelter Manager/SampleTest";
import StaffMember from "../Components/Staff Member/SampleTest";
import Shelter from "../Components/Shelter Manager/Shelter";
import Application from "../Components/Application/Application";
import Records from "../Components/Application/Records";
import Pets from "../Components/Pets/Pets";

export const globalPrivilege = "GLOBAL";
export const adopterPrivilege = "ADOPTER";
export const managerPrivilege = "MANAGER";
export const staffPrivilege = "STAFF";

export const nav = [

    // security pages
    {
       path: "/",
       Title: "Login",
       element: <Login />,
       status: globalPrivilege
   },
   {
       path: "/sign-up",
       Title: "Signup",
       element: <Signup />,
       status: globalPrivilege
   },
   // adopter
   {
        path: "/adopter",
        Title: "Adopter",
        element: <SampleTest1 />,
        status: adopterPrivilege
   },
   // shelter manager
   {
        path: "/shelter-manager",
        Title: "Shelter Manager",
        element: <ManagerGroups />,
        status: managerPrivilege
   },
   {
        path: "/shelter",
        Title: "Shelters",
        element: <Shelter />,
        status: managerPrivilege
   },
    // staff member
   {
        path: "/staff-member",
        Title: "Staff Member",
        element: <Pets />,
        status: staffPrivilege
   },
   // error page
   {
       path: "*",
       Title: "404",
       element: <Error />,
       status: globalPrivilege
   },

]