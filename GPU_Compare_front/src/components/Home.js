import { React, Fragment } from "react";
import Gpus from "./gpus/Gpus";
import axios from "axios";
import { useEffect, useState } from "react";
import { Link } from "react-router-dom";

const Home = () => {
  const [gpus, setGpus] = useState([]);
  const [minYear, setMinYear] = useState([]);
  const [manufacturer, setManufacturer] = useState([]);
  const [gpusNames, setGpuNAmes] = useState([]);

  const [selectedOption1, setSelectedOption1] = useState(null);
  const [selectedOption2, setSelectedOption2] = useState(null);

  useEffect(() => {
    loadGpus();
  }, []);

  const loadGpus = async () => {
    const result = await axios.get("http://localhost:8080/gpu/all");
    setGpus(result.data);
    setGpuNAmes(
      gpus.map((gpu) => {
        return { value: gpu.productName, label: gpu.productName };
      })
    );
  };

  const onYearChange = (e) => {
    setMinYear(e.target.value);
  };

  const onManufacturerChange = (e) => {
    setManufacturer(e.target.value);
  };

  const searchHandle = async (e) => {
    e.preventDefault();
    const result = await axios.post(`http://localhost:8080/gpu/filter`, {
      manufacturer: manufacturer,
      minimumReleaseYear: minYear,
    });
    setGpus(result.data);
  };

  return (
    <Fragment>
      <Link to="/addGpu"> Add GPU </Link>
      <label htmlFor="manufacturer">manufacturer:</label>
      <input
        type="text"
        id="manufacturer"
        name="manufacturer"
        onChange={onManufacturerChange}
      ></input>
      <label htmlFor="minimumReleaseYear">minimumReleaseYear :</label>
      <input
        type="text"
        id="minimumReleaseYear"
        name="minimumReleaseYear"
        onChange={onYearChange}
      ></input>
      <button onClick={searchHandle}> search </button>
      <Link to="/compare"> Compare </Link>
      <Gpus gpus={gpus}></Gpus>;
    </Fragment>
  );
};

export default Home;
