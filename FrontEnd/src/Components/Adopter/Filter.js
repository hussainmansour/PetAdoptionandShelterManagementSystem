import React from "react";
import { useState } from "react";
import { fetchPets } from "../../Services/StaffService";
import Cookies from "js-cookie";

function Filter(props) {

    const [search, setSearch] = useState("");
    const [filter, setFilter] = useState("");

    const handleSearch = (e) => {
        setSearch(e.target.value);
    }

    const handleFilter = (e) => {
        setFilter(e.target.value);
    }

    const handleSubmit = async (e) => {
        const data = {
            pageNo: 0,
            criteria: [
              { "first": { filter }, "second": {search}},
            ]
          }

          console.log(data);
        await fetchPets(data, Cookies.get("token"));
        props.refetchFunc(data);
    }

  return (
    <div class="flex flex-col md:flex-row gap-3">
      <div class="flex">
        <input
          type="text"
          placeholder="Search for the tool you like"
          onChange={(e) => handleSearch(e)}
          class="w-full md:w-80 px-3 h-10 rounded-l border-2 border-sky-500 focus:outline-none focus:border-sky-500"
        />
        <button
          class="bg-sky-500 text-white rounded-r px-2 md:px-3 py-0 md:py-1"
          onClick={() => handleSubmit()}
        >
          Search
        </button>
      </div>
      <select
        id="pricingType"
        name="pricingType"
        onChange={(e) => handleFilter(e)}
        class="w-full h-10 border-2 border-sky-500 focus:outline-none focus:border-sky-500 text-sky-500 rounded px-2 md:px-3 py-0 md:py-1 tracking-wider"
      >
        <option value="All" selected="">
          All
        </option>
        <option value="Freemium">shelterName</option>
        <option value="Free">name</option>
        <option value="Paid">gender</option>
        <option value="Paid">location</option>
        <option value="Paid">isAdopted</option>
      </select>
    </div>
  );
}

export default Filter;
