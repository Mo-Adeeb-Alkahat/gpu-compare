import { Fragment } from "react";
import GpuItem from "./GpuItem";

const Gpus = (props) => {
  return (
    <Fragment>
      {props.gpus.map((gpu) => (
        <Fragment>
          <GpuItem key={gpu.id} gpu={gpu}></GpuItem>
        </Fragment>
      ))}
    </Fragment>
  );
};

export default Gpus;
