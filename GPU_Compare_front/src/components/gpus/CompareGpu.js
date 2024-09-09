import React from "react";
import GpuItem from "./GpuItem";
import { useEffect, useState, Fragment } from "react";
import axios from "axios";
import UserGpuItem from "./UserGpuItem";

function CompareGpu(props) {
  const [gpu1, setGpu1] = useState([]);
  const [gpu2, setGpu2] = useState([]);

  const [gpuName1, setGpuName1] = useState([]);
  const [gpuName2, setGpuName2] = useState([]);

  const loadGpus = async () => {
    const twoGpus = await axios.get(
      `http://localhost:8080/gpu/compare?productName1=${gpuName1}&productName2=${gpuName2}`
    );
    console.log(twoGpus);

    setGpu1(twoGpus.data[0]);
    setGpu2(twoGpus.data[1]);
  };

  const compareHandler = (e) => {
    loadGpus();
  };

  const onGpuName1Change = (e) => {
    setGpuName1(e.target.value);
  };

  const onGpuName2Change = (e) => {
    setGpuName2(e.target.value);
  };
  return (
    <Fragment>
      <label htmlFor="gpuName1">first gpu name : </label>
      <input
        type="text"
        id="gpuName1"
        name="gpuName1"
        value={gpuName1}
        onChange={onGpuName1Change}
      ></input>

      <label htmlFor="gpuName2">second gpu name :</label>
      <input
        type="text"
        id="gpuName2"
        name="gpuName2"
        value={gpuName2}
        onChange={onGpuName2Change}
      ></input>

      <button onClick={compareHandler}>compare</button>
      <br></br>
      <UserGpuItem gpu={gpu1}></UserGpuItem>
      <br></br>
      <UserGpuItem gpu={gpu2}></UserGpuItem>
    </Fragment>
  );
}

export default CompareGpu;
