import React, { useEffect, useState } from "react";
import logo from "../Shelter Manager/Assets/header.png";
import { useLocation } from "react-router-dom";
import Loading from "../Shelter Manager/Loading";
import AddPet from "./AddPet";
import { fetchPets, getShelterName } from "../../Services/StaffService";
import Cookies from "js-cookie";
import { useQuery } from "react-query";

function Pets(props) {
  const location = useLocation();
  const staffInfo = new URLSearchParams(location.search);
  const staffName = staffInfo.get("name");
  
  const {
    data: shelterName,
    error1,
  } = useQuery(
    "fetchShelterName",
    () => getShelterName(staffName, Cookies.get("token")),
    { refetchOnWindowFocus: false }
    );
    
    
    const request = {
      pageNo: 0,
      criteria: [
        { first: "shelterName", second: "Codeforces" },
        { first: "isAdopted", second: false },
      ],
    }

    const {
      data,
      isLoading2,
      error2,
      refetch,
    } = useQuery(
      "fetchPets",
      () => fetchPets(request, Cookies.get("token")),
      { refetchOnWindowFocus: false }
      );
      
      if (error1 || error2) {
    return <p>Error: {error1.message}</p>;
  }

  /*
  {
    "pageNo" : 0,
    "criteria" : [{"first" : "shelterName" , "second" : "shelter"} ,  , {"first" : "isAdopted" , "second" : false}]
}
  */

  const handleAccept = (app) => {
    console.log(app.username, app.petId);
  };

  const handleReject = (app) => {
    console.log(app.username, app.petId);
  };

  return (
    <section className="bg-gray-50 dark:bg-gray-900 p-3 sm:p-5 min-h-screen">
      <img
        src={logo}
        alt="Logo"
        className="fixed pointer-events-none left-80 opacity-25 blur-3xl h-screen"
      />
      <div className="mx-auto max-w-screen opacity-75 pb-10 px-8 ">
        {shelterName && (
          <div className="text-5xl text-gray-700 bg-gray-50 tracking-widest dark:bg-gray-700 text-center dark:text-gray-400 mt-5 px-4 py-3 rounded-2xl dark:bg-opacity-25">
            Pets in the Shelter {shelterName}
          </div>
        )}
        {/* table of staff members */}
        <div className="bg-white dark:bg-gray-800 relative mt-12 shadow-md sm:rounded-lg overflow-hidden ">
          <div className="flex flex-col md:flex-row items-center justify-between space-y-3 md:space-y-0 md:space-x-4 p-4"></div>
          <div className="overflow-x-auto">
            <table className="w-full text-sm text-left dark:bg-opacity-75 text-gray-500 dark:text-gray-400">
              <thead className="text-base text-gray-700 uppercase bg-gray-50 dark:bg-gray-700 dark:text-gray-400">
                <tr>
                  <th scope="col" className="px-4 py-3">
                    Gender
                  </th>
                  <th scope="col" className="px-4 py-3">
                    Shelter Name
                  </th>
                  <th scope="col" className="px-4 py-3">
                    date
                  </th>
                  <th scope="col" className="px-4 py-3">
                    pet name
                  </th>
                  <th scope="col" className="px-4 py-3">
                    pet id
                  </th>
                  <th scope="col" className="px-4 py-3">
                    Update
                  </th>
                </tr>
              </thead>
              {/* <tbody>
                {isLoading2 ? (
                  // skeletonLoading
                  <Loading />
                ) : (
                  // quetions and answers
                  data.map((app, index) => (
                    <tr
                      key={index}
                      className="border-b text-lg dark:border-gray-700 text-gray-400"
                    >
                      <td className="px-4 py-3">{app.username}</td>
                      <td className="px-4 py-3">{app.contactNumber}</td>
                      <td className="px-4 py-3">{app.dateOfApplication}</td>
                      <td className="px-4 py-3">{app.petName}</td>
                      <td className="px-4 py-3">{app.petId}</td>
                      <td className="px-4 py-3">
                        <button
                          id={`user-${index}-dropdown-button`}
                          data-dropdown-toggle={`user-${index}-dropdown`}
                          className="bg-csut items-center p-0.5 text-lg font-medium w-2/3 text-center text-white hover:text-gray-800 rounded-lg dark:text-white dark:bg-customGreen dark:hover:text-black dark:focus:ring-2 dark:focus:ring-slate-500 dark:focus:ring-offset-2"
                          type="button"
                          onClick={() => handleAccept(app)}
                        >
                          Update Pet
                        </button>
                      </td>
                    </tr>
                  ))
                )} */}
              {/* </tbody> */}
            </table>
          </div>
        </div>
      </div>
      <AddPet shelterName={shelterName}/>
    </section>
  );
}

export default Pets;
