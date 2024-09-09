import axios from "axios";
import React, { Fragment, useState } from "react";
import { useNavigate } from "react-router-dom";

function AddGpu() {
  let navigate = useNavigate();
  const [gpu, setGpu] = useState({
    manufacturer: "manufacturer",
    productName: "productName",
    releaseYear: "releaseYear",
    memSize: "memSize",
    memBusWidth: "memBusWidth",
    gpuClock: "gpuClock",
    memClock: "memClock",
    unifiedShader: "unifiedShader",
    tmu: "tmu",
    rop: "rop",
    pixelShader: "pixelShader",
    vertexShader: "vertexShader",
    igp: "igp",
    bus: "bus",
    memType: "memType",
    gpuChip: "gpuChip",
  });

  const {
    manufacturer,
    productName,
    releaseYear,
    memSize,
    memBusWidth,
    gpuClock,
    memClock,
    unifiedShader,
    tmu,
    rop,
    pixelShader,
    vertexShader,
    igp,
    bus,
    memType,
    gpuChip,
  } = gpu;

  const onInputChange = (e) => {
    setGpu({ ...gpu, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (event) => {
    event.preventDefault();
    await axios.post("http://localhost:8080/gpu/add", gpu);
    alert("gpu added");
    navigate("/");
  };

  return (
    <Fragment>
      <form onSubmit={handleSubmit}>
        <label htmlFor="manufacturer">manufacturer:</label>
        <input
          type="text"
          id="manufacturer"
          name="manufacturer"
          value={manufacturer}
          onChange={onInputChange}
        ></input>

        <label htmlFor="productName">productName :</label>
        <input
          type="text"
          id="productName"
          name="productName"
          value={productName}
          onChange={(e) => onInputChange(e)}
        ></input>

        <label htmlFor="releaseYear">releaseYear:</label>
        <input
          type="text"
          id="releaseYear"
          name="releaseYear"
          value={releaseYear}
          onChange={(e) => onInputChange(e)}
        ></input>

        <label htmlFor="memSize">memSize:</label>
        <input
          type="text"
          id="memSize"
          name="memSize"
          value={memSize}
          onChange={(e) => onInputChange(e)}
        ></input>

        <label htmlFor="memBusWidth">memBusWidth:</label>
        <input
          type="text"
          id="memBusWidth"
          name="memBusWidth"
          value={memBusWidth}
          onChange={(e) => onInputChange(e)}
        ></input>

        <label htmlFor="gpuClock">gpuClock:</label>
        <input
          type="text"
          id="gpuClock"
          name="gpuClock"
          value={gpuClock}
          onChange={(e) => onInputChange(e)}
        ></input>

        <label htmlFor="memClock">memClock:</label>
        <input
          type="text"
          id="memClock"
          name="memClock"
          value={memClock}
          onChange={(e) => onInputChange(e)}
        ></input>

        <label htmlFor="unifiedShader">unifiedShader:</label>
        <input
          type="text"
          id="unifiedShader"
          name="unifiedShader"
          value={unifiedShader}
          onChange={(e) => onInputChange(e)}
        ></input>

        <label htmlFor="tmu">tmu:</label>
        <input
          type="text"
          id="tmu"
          name="tmu"
          value={tmu}
          onChange={(e) => onInputChange(e)}
        ></input>

        <label htmlFor="rop">rop:</label>
        <input
          type="text"
          id="rop"
          name="rop"
          value={rop}
          onChange={(e) => onInputChange(e)}
        ></input>

        <label htmlFor="pixelShader">pixelShader:</label>
        <input
          type="text"
          id="pixelShader"
          name="pixelShader"
          value={pixelShader}
          onChange={(e) => onInputChange(e)}
        ></input>

        <label htmlFor="vertexShader">vertexShader:</label>
        <input
          type="text"
          id="vertexShader"
          name="vertexShader"
          value={vertexShader}
          onChange={(e) => onInputChange(e)}
        ></input>

        <label htmlFor="igp">igp:</label>
        <input
          type="text"
          id="igp"
          name="igp"
          value={igp}
          onChange={(e) => onInputChange(e)}
        ></input>

        <label htmlFor="bus">bus:</label>
        <input
          type="text"
          id="bus"
          name="bus"
          value={bus}
          onChange={(e) => onInputChange(e)}
        ></input>

        <label htmlFor="memType">memType :</label>
        <input
          type="text"
          id="memType"
          name="memType"
          value={memType}
          onChange={(e) => onInputChange(e)}
        ></input>

        <label htmlFor="gpuChip">gpuChip :</label>
        <input
          type="text"
          id="gpuChip"
          name="gpuChip"
          value={gpuChip}
          onChange={(e) => onInputChange(e)}
        ></input>

        <input type="submit" value="Submit"></input>
      </form>
    </Fragment>
  );
}

export default AddGpu;
