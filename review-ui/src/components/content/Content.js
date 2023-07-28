import Button from "react-bootstrap/Button";
import Card from "react-bootstrap/Card";

function Content({ cardTitle, cardContent }) {
  return (
    <Card>
      <Card.Body>
        <Card.Title>{cardTitle}</Card.Title>
        <Card.Text>{cardContent}</Card.Text>
        <Button variant="primary">Read reviews</Button>
      </Card.Body>
    </Card>
  );
}

export default Content;
