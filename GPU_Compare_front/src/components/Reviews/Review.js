import React, { Fragment } from "react";

function Review(props) {
  const description = props.review.description;
  const userName = props.review.userName;
  return (
    <Fragment>
      <br></br>
      {userName}
      <br></br>
      {description}
      <br></br>
    </Fragment>
  );
}

export default Review;
