import React from "react";

function UserGpuItem(props) {
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

  return (
    <React.Fragment>
      {manufacturer} {productName} {releaseYear} {memSize} {memBusWidth}{" "}
      {gpuClock} {memClock}
      {unifiedShader} {tmu} {rop} {pixelShader} {vertexShader} {igp} {bus}{" "}
      {memType} {gpuChip}
      <br></br>
    </React.Fragment>
  );
}

export default UserGpuItem;
