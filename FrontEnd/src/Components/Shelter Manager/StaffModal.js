import { React, useState } from "react";
import { insertStaff } from "../../Services/ShelterService";
import Cookies from "js-cookie";

const StaffModal = ({ isOpen, closeModal, shelterName, refetchFunc }) => {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [firstName, setFirstName] = useState("");
  const [lastName, setLastName] = useState("");
  const [contactNo, setContactNo] = useState("");
  const [role, setRole] = useState("");

  const handleUsernameChange = (e) => {
    setUsername(e.target.value);
  };

  const handlePasswordChange = (e) => {
    setPassword(e.target.value);
  };

  const handleFirstNameChange = (e) => {
    setFirstName(e.target.value);
  };

  const handleLastNameChange = (e) => {
    setLastName(e.target.value);
  };

  const handleContactNoChange = (e) => {
    setContactNo(e.target.value);
  };

  const handleRoleChange = (e) => {
    setRole(e.target.value);
  };
  
  const handleSave = async () => {
    if( await insertStaff({
      userName: username,
      password: password,
      fname: firstName,
      lname: lastName,
      contactNo: contactNo,
      shelterName: shelterName,
      role: role,
    }, Cookies.get("token")) === "Staff is already exists") {
      alert("Staff is already exists"); 
    } else {
      setUsername("");
      setPassword("");
      setFirstName("");
      setLastName("");
      setContactNo("");
      setRole("Reviewer");
      closeModal();
      await refetchFunc();    
    }
  };

  const cancelSave = () => {
    setUsername("");
    setPassword("");
    setFirstName("");
    setLastName("");
    setContactNo("");
    setRole("Reviewer");
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
                  Add a new staff member
                </h3>
                <div className="mt-2">
                  <input
                    type="text"
                    value={username}
                    onChange={handleUsernameChange}
                    className="w-full border rounded-md px-3 py-2 mt-2 focus:outline-none focus:ring focus:border-blue-300"
                    placeholder="Enter username"
                  />
                  <input
                    type="password"
                    value={password}
                    onChange={handlePasswordChange}
                    className="w-full border rounded-md px-3 py-2 mt-2 focus:outline-none focus:ring focus:border-blue-300"
                    placeholder="Enter password"
                  />
                   <select
                    value={role}
                    onChange={handleRoleChange}
                    className="w-full border rounded-md px-3 py-2 mt-2 focus:outline-none focus:ring focus:border-blue-300"
                  >
                    <option value="Reviewer">Reviewer</option>
                    <option value="Co-Manager">Co-Manager</option>
                  </select>
                  <input
                    type="text"
                    value={firstName}
                    onChange={handleFirstNameChange}
                    className="w-full border rounded-md px-3 py-2 mt-2 focus:outline-none focus:ring focus:border-blue-300"
                    placeholder="Enter first name"
                  />
                  <input
                    type="text"
                    value={lastName}
                    onChange={handleLastNameChange}
                    className="w-full border rounded-md px-3 py-2 mt-2 focus:outline-none focus:ring focus:border-blue-300"
                    placeholder="Enter last name"
                  />
                  <input
                    type="text"
                    value={contactNo}
                    onChange={handleContactNoChange}
                    className="w-full border rounded-md px-3 py-2 mt-2 focus:outline-none focus:ring focus:border-blue-300"
                    placeholder="Enter contact number"
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

export default StaffModal;
