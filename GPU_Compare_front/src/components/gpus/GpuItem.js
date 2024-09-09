import React from "react";
import { Link } from "react-router-dom";
import axios from "axios";
function GpuItem(props) {
  const manufacturer = props.gpu.manufacturer;
  const productName = props.gpu.productName;
  const releaseYear = props.gpu.releaseYear;
  const memSize = props.gpu.memSize;
  const memBusWidth = props.gpu.memBusWidth;
  const gpuClock = props.gpu.gpuClock;
  const memClock = props.gpu.memClock;
  const unifiedShader = props.gpu.unifiedShader;
  const tmu = props.gpu.tmu;
  const rop = props.gpu.rop;
  const pixelShader = props.gpu.pixelShader;
  const vertexShader = props.gpu.vertexShader;
  const igp = props.gpu.igp;
  const bus = props.gpu.bus;
  const memType = props.gpu.memType;
  const gpuChip = props.gpu.gpuChip;
  const id = props.gpu.id;

  const deleteGpu = async (id) => {
    const result = await axios.delete(`http://localhost:8080/gpu/delete/${id}`);
    if (result) {
      alert(`the gpu with ${id} was deleted`);
    }
  };

  const deleteHandle = (e) => {
    e.preventDefault();
    deleteGpu(id);
  };

  return (
    <React.Fragment>
      {manufacturer} {productName} {releaseYear} {memSize} {memBusWidth}{" "}
      {gpuClock} {memClock}
      {unifiedShader} {tmu} {rop} {pixelShader} {vertexShader} {igp} {bus}{" "}
      {memType} {gpuChip} <Link to={`/gpu/${id}`}>view GPU</Link>{" "}
      <button onClick={deleteHandle}>delete</button>{" "}
      <Link to={`/editGpu/${id}`}>edit</Link>
      <br></br>
    </React.Fragment>
  );
}

export default GpuItem;
