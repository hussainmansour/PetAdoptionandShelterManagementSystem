import React from "react";
import logo from "../Shelter Manager/Assets/header.png";

function Records(props) {
  const data = [
    {
      username: "JohnDoe123",
      contactNumber: "123-456-7890",
      dateOfApplication: "2023-12-28",
      petId: "001",
      petName: "Fluffy",
      status: "Accepted",
    },
    {
      username: "JohnDoe123",
      contactNumber: "123-456-7890",
      dateOfApplication: "2023-12-28",
      petId: "001",
      petName: "Fluffy",
      status: "Rejected",
    },
    {
      username: "JohnDoe123",
      contactNumber: "123-456-7890",
      dateOfApplication: "2023-12-28",
      petId: "001",
      petName: "Fluffy",
      status: "Accepted",
    },
    {
      username: "JohnDoe123",
      contactNumber: "123-456-7890",
      dateOfApplication: "2023-12-28",
      petId: "001",
      petName: "Fluffy",
      status: "Rejected",
    },
    {
      username: "JohnDoe123",
      contactNumber: "123-456-7890",
      dateOfApplication: "2023-12-28",
      petId: "001",
      petName: "Fluffy",
      status: "Accepted",
    },
    {
      username: "JohnDoe123",
      contactNumber: "123-456-7890",
      dateOfApplication: "2023-12-28",
      petId: "001",
      petName: "Fluffy",
      status: "Accepted",
    },
    {
      username: "JohnDoe123",
      contactNumber: "123-456-7890",
      dateOfApplication: "2023-12-28",
      petId: "001",
      petName: "Fluffy",
      status: "Accepted",
    },
    {
      username: "JohnDoe123",
      contactNumber: "123-456-7890",
      dateOfApplication: "2023-12-28",
      petId: "001",
      petName: "Fluffy",
      status: "Accepted",
    },

    // Add more objects as needed for additional rows of data
  ];
  const isLoading = false;

  return (
    <section className="bg-gray-50 dark:bg-gray-900 p-3 sm:p-5 min-h-screen">
      <img
        src={logo}
        alt="Logo"
        className="fixed pointer-events-none left-80 opacity-25 blur-3xl h-screen"
      />
      <div className="mx-auto max-w-screen opacity-75 pb-10 px-8 ">
        <div className="text-5xl text-gray-700 bg-gray-50 tracking-widest dark:bg-gray-700 text-center dark:text-gray-400 mt-5 px-4 py-3 rounded-2xl dark:bg-opacity-25">
          Applications Records
        </div>{" "}
        {/* table of staff members */}
        <div className="bg-white dark:bg-gray-800 relative mt-12 shadow-md sm:rounded-lg overflow-hidden ">
          <div className="flex flex-col md:flex-row items-center justify-between space-y-3 md:space-y-0 md:space-x-4 p-4"></div>
          <div className="overflow-x-auto">
            <table className="w-full text-sm text-left dark:bg-opacity-75 text-gray-500 dark:text-gray-400">
              <thead className="text-base text-gray-700 uppercase bg-gray-50 dark:bg-gray-700 dark:text-gray-400">
                <tr>
                  <th scope="col" className="px-4 py-3">
                    username
                  </th>
                  <th scope="col" className="px-4 py-3">
                    contact number
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
                    status
                  </th>
                </tr>
              </thead>
              <tbody>
                {isLoading ? (
                  // skeletonLoading
                  <div className="ml-44"></div>
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
                      <button
                          id={`user-${index}-dropdown-button`}
                          data-dropdown-toggle={`user-${index}-dropdown`}
                          className={`bg-csut ${app.status === 'Accepted' ? 'bg-green-500' : 'bg-red-500'} pointer-events-none items-center p-0.5 mt-2 text-lg font-medium w-2/3 text-center text-white hover:text-gray-800 rounded-lg dark:text-white dark:hover:text-black dark:focus:ring-2 dark:focus:ring-slate-500 dark:focus:ring-offset-2`}
                          type="button"
                        >
                          {app.status}
                        </button>
                    </tr>
                  ))
                )}
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </section>
  );
}

export default Records;
