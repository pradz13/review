import Container from "react-bootstrap/Container";
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import Content from "../content/Content";

function Category() {
  return (
    <>
      <br />
      <Container>
        <Row>
          <Col sm>
            <Content cardTitle={"Books"} cardContent={"Reviews of books"} />
          </Col>
          <Col sm>
            <Content cardTitle={"Movies"} cardContent={"Reviews of movies"} />
          </Col>
          <Col sm>
            <Content cardTitle={"Shows"} cardContent={"Reviews of shows"} />
          </Col>
        </Row>
      </Container>
    </>
  );
}

export default Category;
