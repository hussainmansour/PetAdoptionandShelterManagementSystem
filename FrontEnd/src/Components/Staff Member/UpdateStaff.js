import React from "react";
import { useState } from "react";
import StaffModal from "./StaffModal";

function UpdateStaff() {
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
        className="w-4/5 z-10 ml-48 focus:outline-none text-white bg-green-700 hover:bg-green-800 focus:ring-4 focus:ring-green-300 font-medium rounded-lg text-2xl  py-5  dark:bg-green-600 dark:hover:bg-green-700 dark:focus:ring-green-800"
      >
        Update Staff profile
      </button>
      <StaffModal isOpen={isModalOpen} closeModal={closeModal} />
    </div>
  );
}

export default UpdateStaff;
