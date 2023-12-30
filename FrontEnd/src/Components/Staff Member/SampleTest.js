import React from "react";
import logo from "../Shelter Manager/Assets/header.png";
import UpdateStaff from "./UpdateStaff";
import { useNavigate } from "react-router";
import { GetAuthDataFn } from "./../../Routes/Wrapper";

function StaffMember() {
  const nav = useNavigate();
  const { person } = GetAuthDataFn();

  const navigateToPets = () => {
    nav(`/Pets?name=${person.username}`);
  }

  const navigateTpApplications = () => {
    nav(`/Applications?name=${person.username}`);
  }

  const navigateToRecords = () => {
    nav(`/Records?name=${person.username}`);
  }

  return (
    <div className="bg-gradient-to-r from-slate-800 to-gray-900 min-h-screen min-w-full">
      {/* header of the page */}
      <div className="px-20 py-14 w-full flex flex-row">
        <div>
          <div className="flex items-center mt-9">
            <span class="material-symbols-outlined text-7xl">group</span>{" "}
            <div className=" font-bold text-slate-950 text-6xl pl-9">
              Staff Member
            </div>
          </div>
          <div className="text-slate-50 text-3xl px-4 ml-10 py-12 tracking-widest w-auto font-light">
            <span className="text-rose-500 font-bold">Edit</span>{" "}
            <span>
              staff profiles including name, role, and contact details.
            </span>
            <br></br>
            <span className="text-rose-500 font-bold">Manage</span>{" "}
            <span>
              pet profiles available for adoption: add, edit, and oversee
              details.
            </span>
            <br></br>
            <span className="text-rose-500 font-bold">Review</span>{" "}
            <span>adoption applications submitted by potential adopters.</span>
          </div>

          <UpdateStaff />
        </div>
        <img
          src={logo}
          alt="Logo"
          className="fixed pointer-events-none left-80 opacity-25 blur-3xl h-screen"
        />
      </div>
      <hr className="border-b-2 mb-7 border-gray-500 w-4/5 mx-auto" />
      {/* Heading with buttons */}
      <div className="flex justify-center text-5xl mt-4">
        <button
          type="button"
          className="w-1/6  focus:outline-none text-white focus:ring-4 focus:ring-green-300 font-medium rounded-lg text-2xl  py-5 dark:hover:bg-green-700 dark:focus:ring-green-800"
          onClick={() => {navigateToPets()}}
        >
          Pets
        </button>
        <button
          type="button"
          className="w-1/6 focus:outline-none text-white focus:ring-4 focus:ring-green-300 font-medium rounded-lg text-2xl  py-5 dark:hover:bg-green-700 dark:focus:ring-green-800"
          onClick={() => {navigateTpApplications()}}
        >
          Applications
        </button>
        <button
          type="button"
          className="w-1/6 focus:outline-none text-white focus:ring-4 focus:ring-green-300 font-medium rounded-lg text-2xl  py-5 dark:hover:bg-green-700 dark:focus:ring-green-800"
          onClick={() => {navigateToRecords()}}
        >
          Records
        </button>
      </div>
    </div>
  );
}

export default StaffMember;
