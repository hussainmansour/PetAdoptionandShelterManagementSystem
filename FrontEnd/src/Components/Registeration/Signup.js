import React from "react";
import { useState } from "react";
import { useNavigate } from "react-router-dom";
import { Link } from "react-router-dom";
import { register } from "../../Services/RegisterationService";
import { GetAuthDataFn } from "../../Routes/Wrapper";

function Signup() {
  const navigate = useNavigate();
  const { setPerson } = GetAuthDataFn();

  const [info, setInfo] = useState({
    fname: "",
    lname: "",
    username: "",
    contactNo: "",
    password: "",
    confirmedPassword: "",
    role: "",
  });

  function inputChange(e) {
    setInfo({ ...info, [e.target.name]: e.target.value });
  }

  function radioChange(e) {
    setInfo({ ...info, role: e.target.id });
  }

  const handleSubmit = async () => {
    console.log(
      info.fname,
      info.lname,
      info.username,
      info.contactNo,
      info.password,
      info.confirmedPassword,
      info.role
    );
    const response = await register({
      fname: info.fname,
      lname: info.lname,
      username: info.username,
      contactNo: info.contactNo,
      password: info.password,
      role: info.role,
    });
    console.log(response);
    if (response === "failed") {
      alert("Registration failed");
    } else {
      setPerson({
        isAuthorized: true,
        username: info.username,
        privilege: info.role.toUpperCase(),
        personObj: {},
      });
      console.log(info.role.toUpperCase());
      navigate("/");
    }
  };

  return (
    <section className="bg-gradient-to-r from-slate-800 to-gray-900">
      <div className="flex flex-col items-center justify-center px-6 py-2 mx-auto md:h-screen lg:py-0">
        <div className="w-full bg-white rounded-lg shadow dark:border md:mt-0 sm:max-w-md xl:p-0 dark:bg-gray-800 dark:border-gray-700">
          <div className="p-6 space-y-4 md:space-y-6 sm:p-8">
            <h1
              className="text-xl font-bold leading-tight tracking-tight text-gray-900
                        md:text-2xl dark:text-white text-center justify-center"
            >
              Sign up with new account
            </h1>

            {/*-----------------------------------form------------------------------------------*/}
            <form className="space-y-4 md:space-y-6">
              <div className="flex">
                {/*-----------------------------------first name------------------------------------------*/}
                <div>
                  <label
                    htmlFor="First"
                    className="block mb-2 text-sm font-medium text-gray-900 dark:text-white"
                  >
                    First Name
                  </label>
                  <input
                    className="bg-gray-50 text-gray-900 sm:text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
                    type="text"
                    placeholder="Enter your fname"
                    name="fname"
                    value={info.fname}
                    onChange={inputChange}
                    required
                  />
                </div>

                {/*-----------------------------------last name------------------------------------------*/}
                <div className="ml-5">
                  <label
                    htmlFor="Second"
                    className="block mb-2 text-sm font-medium text-gray-900 dark:text-white"
                  >
                    Last Name
                  </label>
                  <input
                    className="bg-gray-50 text-gray-900 sm:text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
                    type="text"
                    placeholder="Enter your lastName"
                    name="lname"
                    value={info.lname}
                    onChange={inputChange}
                    required
                  />
                </div>
              </div>

              <div className="flex">
                {/*-----------------------------------Username------------------------------------------*/}
                <div>
                  <label
                    htmlFor="Username"
                    className="block mb-2 text-sm font-medium text-gray-900 dark:text-white"
                  >
                    Username
                  </label>
                  <input
                    className="bg-gray-50 text-gray-900 sm:text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
                    type="text"
                    placeholder="Enter your userName"
                    name="username"
                    value={info.username}
                    onChange={inputChange}
                    required
                  />
                </div>

                {/*-----------------------------------contact no------------------------------------------*/}
                <div>
                  <label
                    htmlFor="contactNumber"
                    className="block mb-2 text-sm font-medium ml-5 text-gray-900 dark:text-white"
                  >
                    Contact number
                  </label>
                  <input
                    className="bg-gray-50 ml-5  text-gray-900 sm:text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
                    type="tel"
                    placeholder="222 222 2222"
                    pattern="[0-9]{3} [0-9]{3} [0-9]{4}"
                    name="contactNo"
                    value={info.contactNo}
                    onChange={inputChange}
                    required
                  />
                </div>
              </div>
              {/*-----------------------------------password------------------------------------------*/}
              <div>
                <label
                  htmlFor="password"
                  className="block mb-2 text-sm font-medium text-gray-900 dark:text-white"
                >
                  Password
                </label>
                <input
                  className="bg-gray-50 text-gray-900 sm:text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
                  type="password"
                  placeholder="Enter your password"
                  name="password"
                  value={info.password}
                  onChange={inputChange}
                  required
                />
              </div>

              {/*-----------------------------------check password------------------------------------------*/}
              <div>
                <label
                  htmlFor="password"
                  className="block mb-2 text-sm font-medium text-gray-900 dark:text-white"
                >
                  Confirm password
                </label>
                <input
                  className="bg-gray-50 text-gray-900 sm:text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
                  type="password"
                  placeholder="Enter confirmed Password"
                  name="confirmedPassword"
                  value={info.confirmedPassword}
                  onChange={inputChange}
                  required
                />
              </div>

              {/*-----------------------------------privilege------------------------------------------*/}
              <div className="flex flex-wrap justify-center space-x-8">
                <div className="flex items-center me-4">
                  <input
                    className="w-4 h-4 text-green-600 bg-gray-100 border-gray-300 focus:ring-green-500"
                    type="radio"
                    id="Manager"
                    name="formHorizontalRadios"
                    onChange={radioChange}
                    required
                  />
                  <label
                    htmlFor="green-radio"
                    className="ms-2 text-sm font-medium text-gray-900 dark:text-gray-300"
                  >
                    Manager
                  </label>
                </div>
                <div className="flex items-center me-4">
                  <input
                    className="w-4 h-4 text-green-600 bg-gray-100 border-gray-300 focus:ring-green-500"
                    type="radio"
                    id="Adopter"
                    name="formHorizontalRadios"
                    onChange={radioChange}
                    required
                  />
                  <label
                    htmlFor="green-radio"
                    className="ms-2 text-sm font-medium text-gray-900 dark:text-gray-300"
                  >
                    Adopter
                  </label>
                </div>
              </div>

              {/*-----------------------------------submit------------------------------------------*/}
              <button
                className="w-full text-white bg-primary-600 hover:bg-primary-700 focus:ring-4
                                focus:outline-none focus:ring-primary-300 font-medium rounded-lg text-sm px-5 py-2.5
                                text-center dark:bg-primary-600 dark:hover:bg-primary-700 dark:focus:ring-primary-800"
                type="button"
                onClick={handleSubmit}
              >
                Sign up
              </button>

              {/*-----------------------------------log-in------------------------------------------*/}
              <div className="inline-flex">
                <p className="text-sm font-light text-gray-500 dark:text-gray-400">
                  Already have an account?
                  <Link
                    to="/"
                    className="font-medium text-primary-600 hover:underline dark:text-primary-500"
                  >
                    log in
                  </Link>
                </p>
              </div>
            </form>
          </div>
        </div>
      </div>
    </section>
  );
}

export default Signup;
