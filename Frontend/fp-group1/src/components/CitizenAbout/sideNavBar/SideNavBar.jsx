import "./sideNavBar.css";
import Nav from "react-bootstrap/Nav";
import { Link } from "react-router-dom";

const SideNavBar = ({ citizenReturnDTO, handleSelect }) => {
    return (
        <Nav
            className="flex-column"
            onSelect={(eventKey) => handleSelect(eventKey)}
        >
            <Nav.Link disabled>
                {citizenReturnDTO.forenames} {citizenReturnDTO.surname}
            </Nav.Link>
            <Nav.Link eventKey="/about">About</Nav.Link>
            <Nav.Link eventKey="/finance">Financial</Nav.Link>
            <Nav.Link eventKey="/mobile">Mobile</Nav.Link>
            <Nav.Link eventKey="/vehicle">Vehicle</Nav.Link>
            <Nav.Link eventKey="/associates">Associates</Nav.Link>
            <Nav.Link eventKey="/whereabouts">Whereabouts</Nav.Link>
        </Nav>
    );
};

export default SideNavBar;
