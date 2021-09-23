import { useParams, useHistory } from "react-router-dom";
import SideNavBar from "./sideNavBar/SideNavBar";
import Container from "react-bootstrap/Container";
import Col from "react-bootstrap/Col";
import Row from "react-bootstrap/Row";

const CitizenAbout = ({ citizens }) => {
    const { lastName } = useParams();
    const { push } = useHistory();

    const handleSelect = (eventKey) => {
        push(`/${eventKey}/${lastName}`);
    };

    return (
        <>
            <Row>
                <Col xs={2}>
                    <SideNavBar
                        citizen={citizens[0]}
                        handleSelect={handleSelect}
                    />
                </Col>
                <Col>
                    <h1>Citizen About</h1>
                    <h2>{lastName}</h2>
                </Col>
            </Row>
        </>
    );
};

export default CitizenAbout;
