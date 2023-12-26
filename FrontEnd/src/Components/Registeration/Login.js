import React, { useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import GetAuthDataFn from "./../../Routes/Wrapper";

function Login(props) {
  const navigate = useNavigate();
  const { setPerson } = GetAuthDataFn();

  const [info, setInfo] = useState({
    username: "",
    password: "",
    role: "",
  });

  function inputChange(e) {
    setInfo({ ...info, [e.target.name]: e.target.value });
  }

  function radioChange(e) {
    setInfo({ ...info, role: e.target.id });
  }

  const handleSubmit = async (e) => {
    console.log(info.username, info.password, info.role);
  };

  return (
    <section className="bg-gradient-to-r from-slate-800 to-gray-900">
      <div className="flex flex-col items-center justify-center px-6 py-2 mx-auto md:h-screen lg:py-0">
        <div className="w-full bg-white rounded-lg shadow dark:border md:mt-0 sm:max-w-md xl:p-0 dark:bg-gray-800 dark:border-gray-700">
          <div className="p-6 space-y-4 md:space-y-6 sm:p-8">
            <h1 className="text-xl font-bold leading-tight tracking-tight text-center text-gray-900 md:text-2xl dark:text-white">
              Sign in with your account
            </h1>

            {/*-----------------------------------form------------------------------------------*/}
            <form className="space-y-4 md:space-y-6" action="#">
              {/*-----------------------------------email------------------------------------------*/}
              <div>
                <label
                  htmlFor="email"
                  className="block mb-2 text-sm font-medium text-gray-900 dark:text-white"
                >
                  Username
                </label>
                <input
                  type="text"
                  id="username"
                  className="bg-gray-50 text-gray-900 sm:text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
                  placeholder="Enter your username"
                  name="username"
                  value={info.username}
                  onChange={inputChange}
                  required
                />
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
                  type="password"
                  id="password"
                  className="bg-gray-50 text-gray-900 sm:text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
                  placeholder="Enter your password"
                  name="password"
                  value={info.password}
                  onChange={inputChange}
                  required
                />
              </div>

              {/*-----------------------------------privilege------------------------------------------*/}
              <div className="flex flex-wrap justify-center space-x-8">
                <div className="flex items-center me-4">
                  <input
                    className="w-4 h-4 text-red-600 bg-gray-100 border-gray-300 focus:ring-red-500"
                    type="radio"
                    name="formHorizontalRadios"
                    onChange={radioChange}
                    required
                  />
                  <label
                    htmlFor="red-radio"
                    className="ms-2 text-sm font-medium text-gray-900 dark:text-gray-300"
                  >
                    Staff Member
                  </label>
                </div>
                <div className="flex items-center me-4">
                  <input
                    className="w-4 h-4 text-green-600 bg-gray-100 border-gray-300 focus:ring-green-500"
                    type="radio"
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
                Sign in
              </button>

              {/*-----------------------------------signup - forget password------------------------------------------*/}
              <div className="flex items-center justify-between">
                <p className="text-sm font-light text-gray-500 dark:text-gray-400">
                  Don’t have an account yet? 
                  <Link
                    to="/sign-up"
                    className="font-medium text-primary-600 hover:underline dark:text-primary-500"
                  >
                    Sign up
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

export default Login;
