import React from "react";
import {Container, Nav, Navbar} from "react-bootstrap";
import "./NavBar.css"

export default function NavBar(){
    return(
        <Navbar bg="light" variant="light">
            <Container className={"navbar-container"}>
                <Nav className="me-auto">
                    <Nav.Link href="#/">Home</Nav.Link>
                    <Nav.Link href="#/cards">Cards</Nav.Link>
                    <Nav.Link href="#/packs">Packs</Nav.Link>
                </Nav>
            </Container>
        </Navbar>
    )
}