import React from "react";
import logo from "../Shelter Manager/Assets/header.png";

function Application(props) {

  const data = [
    {
      username: "JohnDoe123",
      contactNumber: "123-456-7890",
      dateOfApplication: "2023-12-28",
      petId: "001",
      petName: "Fluffy",
      description: "Adorable cat",
      petPictureUrl: "pet_picture_url_1",
    },
    {
      username: "JaneSmith456",
      contactNumber: "987-654-3210",
      dateOfApplication: "2023-12-29",
      petId: "002",
      petName: "Buddy",
      description: "Friendly dog",
      petPictureUrl: "pet_picture_url_2",
    },
    {
      username: "JohnDoe123",
      contactNumber: "123-456-7890",
      dateOfApplication: "2023-12-28",
      petId: "001",
      petName: "Fluffy",
      description: "Adorable cat",
      petPictureUrl: "pet_picture_url_1",
    },
    {
      username: "JaneSmith456",
      contactNumber: "987-654-3210",
      dateOfApplication: "2023-12-29",
      petId: "002",
      petName: "Buddy",
      description: "Friendly dog",
      petPictureUrl: "pet_picture_url_2",
    },
    {
      username: "JohnDoe123",
      contactNumber: "123-456-7890",
      dateOfApplication: "2023-12-28",
      petId: "001",
      petName: "Fluffy",
      description: "Adorable cat",
      petPictureUrl: "pet_picture_url_1",
    },
    {
      username: "JaneSmith456",
      contactNumber: "987-654-3210",
      dateOfApplication: "2023-12-29",
      petId: "002",
      petName: "Buddy",
      description: "Friendly dog",
      petPictureUrl: "pet_picture_url_2",
    },
    {
      username: "JohnDoe123",
      contactNumber: "123-456-7890",
      dateOfApplication: "2023-12-28",
      petId: "001",
      petName: "Fluffy",
      description: "Adorable cat",
      petPictureUrl: "pet_picture_url_1",
    },
    {
      username: "JaneSmith456",
      contactNumber: "987-654-3210",
      dateOfApplication: "2023-12-29",
      petId: "002",
      petName: "Buddy",
      description: "Friendly dog",
      petPictureUrl: "pet_picture_url_2",
    },
    {
      username: "JohnDoe123",
      contactNumber: "123-456-7890",
      dateOfApplication: "2023-12-28",
      petId: "001",
      petName: "Fluffy",
      description: "Adorable cat",
      petPictureUrl: "pet_picture_url_1",
    },
    {
      username: "JaneSmith456",
      contactNumber: "987-654-3210",
      dateOfApplication: "2023-12-29",
      petId: "002",
      petName: "Buddy",
      description: "Friendly dog",
      petPictureUrl: "pet_picture_url_2",
    },
    // Add more objects as needed for additional rows of data
  ];
  const isLoading = false;

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
        <div className="text-5xl text-gray-700 bg-gray-50 tracking-widest dark:bg-gray-700 text-center dark:text-gray-400 mt-5 px-4 py-3 rounded-2xl dark:bg-opacity-25">
          Applications
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
                    Accept
                  </th>
                  <th scope="col" className="px-4 py-3">
                    Reject
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
                      <td className="px-4 py-3">
                        <button
                          id={`user-${index}-dropdown-button`}
                          data-dropdown-toggle={`user-${index}-dropdown`}
                          className="bg-csut items-center p-0.5 text-lg font-medium w-2/3 text-center text-white hover:text-gray-800 rounded-lg dark:text-white dark:bg-customGreen dark:hover:text-black dark:focus:ring-2 dark:focus:ring-slate-500 dark:focus:ring-offset-2"
                          type="button"
                          onClick={() => handleAccept(app)}
                        >
                          Accept
                        </button>
                      </td>
                      <td className="px-4 py-3">
                        <button
                          id={`user-${index}-dropdown-button`}
                          data-dropdown-toggle={`user-${index}-dropdown`}
                          className="bg-csut items-center p-0.5 text-lg w-2/3 font-medium text-center text-white hover:text-gray-800 rounded-lg dark:text-white dark:bg-red-500 dark:hover:text-black dark:focus:ring-2 dark:focus:ring-slate-500 dark:focus:ring-offset-2"
                          type="button"
                          onClick={() => handleReject(app)}
                        >
                          Reject
                        </button>
                      </td>
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

export default Application;
