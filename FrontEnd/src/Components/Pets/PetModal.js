import { React, useState } from "react";
import { addPet } from "../../Services/StaffService";
import Cookies from "js-cookie";

const PetModal = ({ isOpen, closeModal, shelterName, refetchFunc }) => {
  const [name, setName] = useState("");
  const [species, setSpecies] = useState("");
  const [breed, setBreed] = useState("");
  const [dateOfBirth, setdateOfBirth] = useState("");
  const [gender, setGender] = useState("");
  const [healthStatus, setHealthStatus] = useState("");
  const [behavior, setBehavior] = useState("");
  const [description, setDescription] = useState("");
  const [image, setImage] = useState("");

  const handleNameChange = (e) => {
    setName(e.target.value);
  };

  const handleSpeciesChange = (e) => {
    setSpecies(e.target.value);
  };

  const handleBreedChange = (e) => {
    setBreed(e.target.value);
  };

  const handleDateChange = (e) => {
    setdateOfBirth(e.target.value);
  };

  const handleGenderChange = (e) => {
    setGender(e.target.value);
  };

  const handleHealthStatusChange = (e) => {
    setHealthStatus(e.target.value);
  };

  const handleBehaviorChange = (e) => {
    setBehavior(e.target.value);
  };

  const handleDescriptionChange = (e) => {
    setDescription(e.target.value);
  };

  const handleImageChange = (e) => {
    setImage(e.target.value);
  };

  const handleSave = async () => {
    await addPet(
      {
        shelterName: shelterName,
        name: name,
        species: species,
        breed: breed,
        dateOfBirth: dateOfBirth,
        behavior: behavior,
        description: description,
        healthStatus: healthStatus,
      },
      Cookies.get("token")
    );
    setBehavior("");
    setDescription("");
    setHealthStatus("");
    setImage("");
    setName("");
    setSpecies("");
    setBreed("");
    setdateOfBirth("");
    setGender("");
    closeModal();
    await refetchFunc();
  };

  const cancelSave = () => {
    setName("");
    setSpecies("");
    setBreed("");
    setdateOfBirth("");
    setGender("");
    setHealthStatus("");
    setBehavior("");
    setDescription("");
    setImage("");
    closeModal();
  };

  return (
    <div
      className={`fixed z-10 inset-0 overflow-y-auto ${
        isOpen ? "block" : "hidden"
      }`}
    >
      <div className="flex items-center justify-center min-h-screen pt-4 px-4 pb-20 text-center">
        <div className="fixed inset-0 transition-opacity" aria-hidden="true">
          <div className="absolute inset-0 bg-gray-500 opacity-75" />
        </div>
        <span
          className="hidden sm:inline-block sm:align-middle sm:h-screen"
          aria-hidden="true"
        >
          &#8203;
        </span>
        <div
          className="inline-block align-bottom bg-white rounded-lg text-left overflow-hidden shadow-xl transform transition-all sm:my-8 sm:align-middle sm:max-w-lg sm:w-full"
          role="dialog"
          aria-modal="true"
          aria-labelledby="modal-headline"
        >
          <div className="bg-white px-4 pt-5 pb-4 sm:p-6 sm:pb-4">
            <div className="sm:flex sm:items-start">
              <div className="mt-3 text-center sm:mt-0 sm:ml-4 sm:text-left">
                <h3
                  className="text-lg leading-6 font-medium text-gray-900"
                  id="modal-headline"
                >
                  Add a new Pet
                </h3>
                <div className="mt-2">
                  <input
                    type="text"
                    value={name}
                    onChange={handleNameChange}
                    className="w-full border rounded-md px-3 py-2 mt-2 focus:outline-none focus:ring focus:border-blue-300"
                    placeholder="Enter name"
                  />
                  <input
                    type="text"
                    value={species}
                    onChange={handleSpeciesChange}
                    className="w-full border rounded-md px-3 py-2 mt-2 focus:outline-none focus:ring focus:border-blue-300"
                    placeholder="Enter species"
                  />
                  <input
                    type="text"
                    value={breed}
                    onChange={handleBreedChange}
                    className="w-full border rounded-md px-3 py-2 mt-2 focus:outline-none focus:ring focus:border-blue-300"
                    placeholder="Enter breed"
                  />
                  <input
                    type="text"
                    value={dateOfBirth}
                    onChange={handleDateChange}
                    className="w-full border rounded-md px-3 py-2 mt-2 focus:outline-none focus:ring focus:border-blue-300"
                    placeholder="Enter date"
                  />
                  <input
                    type="text"
                    value={gender}
                    onChange={handleGenderChange}
                    className="w-full border rounded-md px-3 py-2 mt-2 focus:outline-none focus:ring focus:border-blue-300"
                    placeholder="Enter gender"
                  />
                  <input
                    type="text"
                    value={healthStatus}
                    onChange={handleHealthStatusChange}
                    className="w-full border rounded-md px-3 py-2 mt-2 focus:outline-none focus:ring focus:border-blue-300"
                    placeholder="Enter health status"
                  />
                  <input
                    type="text"
                    value={behavior}
                    onChange={handleBehaviorChange}
                    className="w-full border rounded-md px-3 py-2 mt-2 focus:outline-none focus:ring focus:border-blue-300"
                    placeholder="Enter behavior"
                  />
                  <input
                    type="text"
                    value={description}
                    onChange={handleDescriptionChange}
                    className="w-full border rounded-md px-3 py-2 mt-2 focus:outline-none focus:ring focus:border-blue-300"
                    placeholder="Enter description"
                  />
                  <input
                    type="text"
                    value={image}
                    onChange={handleImageChange}
                    className="w-full border rounded-md px-3 py-2 mt-2 focus:outline-none focus:ring focus:border-blue-300"
                    placeholder="Enter image"
                  />
                </div>
              </div>
            </div>
          </div>
          <div className="bg-gray-50 px-4 py-3 sm:px-6 sm:flex sm:flex-row-reverse">
            <button
              onClick={handleSave}
              className="w-full inline-flex justify-center rounded-md border border-transparent px-4 py-2 bg-blue-600 text-base font-medium text-white hover:bg-blue-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-blue-500 sm:ml-3 sm:w-auto sm:text-sm"
            >
              Save
            </button>
            <button
              onClick={cancelSave}
              className="mt-3 w-full inline-flex justify-center rounded-md border border-gray-300 px-4 py-2 bg-white text-base font-medium text-gray-700 hover:bg-gray-50 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-blue-500 sm:mt-0 sm:ml-3 sm:w-auto sm:text-sm"
            >
              Cancel
            </button>
          </div>
        </div>
      </div>
    </div>
  );
};

export default PetModal;
