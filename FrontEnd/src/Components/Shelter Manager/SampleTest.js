import React, { useEffect } from "react";
import CreateShelter from "./CreateShelter";
import logo from "./Assets/header.png";
import ShelterCard from "./ShelterCard";
import Loading from "./Loading";
import { GetAuthDataFn } from "../../Routes/Wrapper";

function ManagerGroups() {

  const { person, setPerson } = GetAuthDataFn();

  useEffect(() => {
    setPerson({
      isAuthorized: true,
      username: "Amr Ahmed",
      privilege: "MANAGER",
      personObj: {}
    });
  }, []);

  const data = [
    {
      shelterName: "First Shelter",
      contactNo: "111-111-1111",
      location: "123 Street, City A, Country X"
    },
    {
      shelterName: "Second Shelter",
      contactNo: "222-222-2222",
      location: "456 Avenue, City B, Country Y"
    },
    {
      shelterName: "Third Shelter",
      contactNo: "333-333-3333",
      location: "789 Road, City C, Country Z"
    },
    {
      shelterName: "First Shelter",
      contactNo: "111-111-1111",
      location: "123 Street, City A, Country X"
    },
    {
      shelterName: "Second Shelter",
      contactNo: "222-222-2222",
      location: "456 Avenue, City B, Country Y"
    },
    {
      shelterName: "Third Shelter",
      contactNo: "333-333-3333",
      location: "789 Road, City C, Country Z"
    }
  ];

  const isLoading = false;

  return (
    <div className="bg-gradient-to-r from-slate-800 to-gray-900 min-h-screen min-w-full">
      {/* header of the page */}
      <div className="px-20 py-14 w-full flex flex-row">
        <div>
          <div className="flex items-center mt-9">
            <span class="material-symbols-outlined text-7xl">domain</span>{" "}
            <div className=" font-bold text-slate-950 text-6xl pl-9">
              Manager Shelters
            </div>
          </div>
          <div className="text-slate-50 text-3xl px-4 ml-10 py-12 tracking-widest w-auto font-light">
            <span className="text-rose-500 font-bold">Explore</span>{" "}
            <span>your managed shelters and access their details.</span>
            <br></br>
            <span className="text-rose-500 font-bold">Manage</span>{" "}
            <span>shelter information and keep it up-to-date.</span>
            <br></br>
            <span className="text-rose-500 font-bold">View</span>{" "}
            <span>all staff members associated with each shelter.</span>
            <br></br>
            <span className="text-rose-500 font-bold">Add</span>{" "}
            <span>new staff members to a specific shelter.</span>
          </div>

          <CreateShelter />
        </div>
        <img
          src={logo}
          alt="Logo"
          className="fixed pointer-events-none left-80 opacity-25 blur-3xl h-screen"
        />
      </div>

      <hr className="border-b-2 mb-20 border-gray-500 w-4/5 mx-auto" />
      <ul className="pb-20">
            {isLoading ? (
              // skeletonLoading
              <div className="ml-44">
                <Loading />
              </div>
            ) : (
              data.map((item, index) => (
                <li className="text-left mb-16">
                  <ShelterCard
                    shelterName={item.shelterName}
                    ownerUsername={person.username}
                    contactNo={item.contactNo}
                    location={item.location}
                  />{" "}
                </li>
              ))
            )}
          </ul>
    </div>
  );
}

export default ManagerGroups;
