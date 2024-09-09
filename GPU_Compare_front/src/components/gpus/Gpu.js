import GpuItem from "./GpuItem";
import { useParams } from "react-router-dom";
import { useEffect, useState, Fragment } from "react";
import axios from "axios";
import Reviews from "../Reviews/Reviews";

const Gpu = (props) => {
  const id = useParams().id;

  const [gpu, setGpu] = useState([]);
  const [reviews, setReviews] = useState([]);

  const [reviewUserName, setReviewUserName] = useState([]);
  const [reviewDescription, setReviewDescription] = useState([]);

  const loadGpu = async () => {
    console.log("loading gpu");
    const result = await axios.get(`http://localhost:8080/gpu/${id}`);
    setGpu(result.data);
    setReviews(result.data.reviews);
  };
  const onUserNameChange = (e) => {
    setReviewUserName(e.target.value);
  };

  const onDescriptionChange = (e) => {
    setReviewDescription(e.target.value);
  };
  const handleSubmit = async (e) => {
    e.preventDefault();
    await axios.post("http://localhost:8080/review/add-review", {
      description: reviewDescription,
      userName: reviewUserName,
      gpu_id: id,
    });
    alert("review added");
    window.location.reload();
  };

  useEffect(() => {
    loadGpu();
  }, []);
  return (
    <Fragment>
      <GpuItem gpu={gpu}></GpuItem>
      <Reviews reviews={reviews}></Reviews>
      <br></br>

      <Fragment>
        <form onSubmit={handleSubmit}>
          <label htmlFor="userName">userName:</label>
          <input
            type="text"
            id="userName"
            name="userName"
            value={reviewUserName}
            onChange={onUserNameChange}
          ></input>

          <label htmlFor="description">description :</label>
          <input
            type="text"
            id="description"
            name="description"
            value={reviewDescription}
            onChange={onDescriptionChange}
          ></input>
          <input type="submit" value="Submit"></input>
        </form>
      </Fragment>
    </Fragment>
  );
};

export default Gpu;
