import Container from "react-bootstrap/Container";
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import Button from "react-bootstrap/Button";
import Card from "react-bootstrap/Card";

function Hero() {
  return (
    <Container>
      <Row>
        <Col>
          <Card>
            <Card.Header>Our reviews are unbiased</Card.Header>
            <Card.Body>
              <Card.Title>
                Books, movies, shows - reviews at your fingetips
              </Card.Title>
              <Card.Text>
                Our reviews are detailed and gives you insights on what you
                should invest your time.
              </Card.Text>
              <Button variant="primary">Check the latest trending posts</Button>
            </Card.Body>
          </Card>
        </Col>
      </Row>
    </Container>
  );
}

export default Hero;
