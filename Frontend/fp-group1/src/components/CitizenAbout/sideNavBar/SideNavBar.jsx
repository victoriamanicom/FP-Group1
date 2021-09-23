import "./sideNavBar.css";
import Nav from "react-bootstrap/Nav";
import { Link } from "react-router-dom";

const SideNavBar = ({ citizen, handleSelect }) => {
    return (
        <>
            <Nav
                className="flex-column"
                onSelect={(eventKey) => handleSelect(eventKey)}
            >
                <Link disabled>
                    {citizen.firstName} {citizen.lastName}
                </Link>
                <Link to="/about">About</Link>
                <Link to="/finance/:lastName">Financial</Link>
                <Link to="/mobile">Mobile</Link>
                <Link to="/vehicle">Vehicle</Link>
                <Link to="/associates">Associates</Link>
            </Nav>
        </>
    );
};

export default SideNavBar;
