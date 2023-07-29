import Button from "react-bootstrap/Button";
import Card from "react-bootstrap/Card";
import { useNavigate } from "react-router-dom";

function Content({ cardTitle, cardContent, articleCategory }) {
  const navigate = useNavigate();
  const navigateToListArticles = () => {
    navigate("/list-articles", {
      state: {
        articleCategory: articleCategory,
      },
    });
  };

  return (
    <>
      <Card>
        <Card.Body>
          <Card.Title>{cardTitle}</Card.Title>
          <Card.Text>{cardContent}</Card.Text>
          <Button variant="primary" onClick={navigateToListArticles}>
            Read reviews
          </Button>
        </Card.Body>
      </Card>
    </>
  );
}

export default Content;
