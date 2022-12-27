import React from "react";
import ReactDOM from "react-dom";
import "./sass/main.scss";
import ShowCard from "./components/ShowCard";
import {Show} from "./types";

const testShow: Show = {
  title: "Breaking Bad",
  lastEpNum: "S01E05",
  nextEpTitle: "Upcoming Ep Title"
};

ReactDOM.render(
  <ShowCard show={testShow}/>,
  document.getElementById("app-root"),
);