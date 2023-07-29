import { useLocation } from "react-router-dom";

function ListArticles() {
  const location = useLocation();

  return (
    <>
      <h1>{location.state.articleCategory}</h1>
    </>
  );
}

export default ListArticles;
