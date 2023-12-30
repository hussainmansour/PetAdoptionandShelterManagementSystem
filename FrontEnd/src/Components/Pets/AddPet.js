import React from "react";
import { useState } from "react";
import PetModal from "./PetModal";

function AddPet(props) {
  const [isModalOpen, setIsModalOpen] = useState(false);

  const openModal = () => {
    setIsModalOpen(true);
  };

  const closeModal = () => {
    setIsModalOpen(false);
  };

  return (
    <div>
      <button
        type="button"
        onClick={openModal}
        className="w-3/4 mb-9 z-10 ml-48 focus:outline-none text-white bg-green-700 hover:bg-green-800 focus:ring-4 focus:ring-green-300 font-medium rounded-lg text-2xl  py-5  dark:bg-green-600 dark:hover:bg-green-700 dark:focus:ring-green-800"
      >
        Add a new Pet
      </button>
      <PetModal isOpen={isModalOpen} closeModal={closeModal} />
    </div>
  );
}

export default AddPet;
