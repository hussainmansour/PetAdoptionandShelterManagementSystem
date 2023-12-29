import React from "react";
import { useNavigate } from "react-router-dom";
import logo from "./Assets/pets2.png";
import "./Card.css";

function ShelterCard(props) {
  const nav = useNavigate();

  function handleClick(name) {
    nav(`/shelter?name=${name}`);
  }

  return (
    <div className="relative w-full h-40 flex justify-center ">
      <button
        className="w-4/5 relative rounded-3xl text-gray-200 font-light shadow-2xl flex flex-row items-center group
            border-8 p-4 transition-all duration-1000 hover:scale-105 hover:ring-4 hover:bg-slate-400 card-shine-effect"
        onClick={() => handleClick(props.shelterName)}
      >
        <div className="pl-3 text-5xl tracking-wider group-hover:text-black transition-all duration-1000">
          {props.shelterName}
        </div>
        <div className="flex ml-auto space-x-4 pr-2 mt-6">
          <span class="material-symbols-outlined mt-6 text-3xl text-rose-500 group-hover:text-white transition-all duration-1000">
            engineering
          </span>
          <div className="text-xl font-medium tracking-wide mt-6 group-hover:text-black transition-all duration-1000">
            {props.ownerUsername}
          </div>
          <span class="material-symbols-outlined mt-6 text-3xl px-2 text-rose-500 group-hover:text-white transition-all duration-1000">
            phone_in_talk
          </span>
          <div className="text-xl font-medium tracking-widest mt-6 group-hover:text-black transition-all duration-1000">
            {props.contactNo}
          </div>
          <span class="material-symbols-outlined mt-6 text-3xl px-2 text-rose-500 group-hover:text-white transition-all duration-1000">
            pin_drop
          </span>
          <div className="text-xl font-medium  tracking-widest mt-6 group-hover:text-black transition-all duration-1000">
            {props.location}
          </div>
        </div>
        <div className="opacity-10 overflow-hidden pb-28 absolute right-7">
          <img src={logo} alt="Logo" className="pt-4 w-auto h-auto" />
        </div>
      </button>
    </div>
  );
}

export default ShelterCard;
