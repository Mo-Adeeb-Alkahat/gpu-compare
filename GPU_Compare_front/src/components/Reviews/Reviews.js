import React from "react";
import { Fragment } from "react";
import Review from "./Review";

function Reviews(props) {
  return (
    <Fragment>
      {props.reviews.map((review) => (
        <Fragment>
          <Review key={review.id} review={review}></Review>
        </Fragment>
      ))}
    </Fragment>
  );
}

export default Reviews;
