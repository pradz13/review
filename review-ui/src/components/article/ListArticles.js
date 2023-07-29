import { useLocation } from "react-router-dom";
import Header from "../header/Header";
import React, { useEffect, useState } from "react";

function ListArticles() {
  const location = useLocation();

  const [response, setResponse] = useState();

  const getApiData = async () => {
    const response = await fetch(
      "http://localhost:9001/review-that-matters/articles/categories/MOVIE_REVIEW/0"
    ).then((response) => response.json());
    setResponse(response);
    console.log(response);
  };

  useEffect(() => {
    getApiData();
  }, []);

  return (
    <>
      <Header />
      <h1>{location.state.articleCategory}</h1>
    </>
  );
}

export default ListArticles;
