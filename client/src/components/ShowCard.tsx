import React from "react";
import {Show} from "../types";

type ShowCardProps = {
  show: Show
}

const ShowCard = ({show}: ShowCardProps): JSX.Element => {
  const {title, lastEpNum, nextEpTitle} = show;

  return (
    <div className="show-card">
      <div className="show-card__img-wrap">
        <img src="https://via.placeholder.com/90x125.png" alt="" className="show-card__img"/>
      </div>

      <div className="show-card__content">
        <h2 className="show-card__title">{title}</h2>
        <p className="show-card__last-ep-num">{lastEpNum}</p>
        <p className="show-card__next-ep-title">{nextEpTitle}</p>
      </div>
    </div>
  );
};

export default ShowCard;