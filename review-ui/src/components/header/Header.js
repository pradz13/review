import Container from "react-bootstrap/Container";
import Navbar from "react-bootstrap/Navbar";

function Header() {
  return (
    <>
      <Navbar bg="primary" data-bs-theme="dark">
        <Container>
          <Navbar.Brand href="#home">Review that matters</Navbar.Brand>
        </Container>
      </Navbar>
      <br />
    </>
  );
}

export default Header;
