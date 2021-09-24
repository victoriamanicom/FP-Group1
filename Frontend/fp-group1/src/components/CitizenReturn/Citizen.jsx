import "./Citizen.css";
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import Card from "react-bootstrap/Card";

const Citizen = ({ firstName, lastName, dob, sex, Address, selectCitizen }) => {
    return (
        <Row>
            <Card className="citizenCard">
                <Card.Body className="citizenCardBody">
                    <Card.Title className="citizenTitle">
                        <h5
                            className="citizenNameHeading"
                            onClick={() => selectCitizen(lastName)}
                        >
                            {firstName} {lastName}
                        </h5>
                    </Card.Title>
                    <Card.Text>
                        <Row>
                            <Col xs={4}>
                                <p>D.O.B: {dob}</p>
                                <p>Gender: {sex}</p>
                            </Col>
                            <Col>
                                <p>Address: {Address}</p>
                            </Col>
                        </Row>
                    </Card.Text>
                </Card.Body>
            </Card>
        </Row>
    );
};

export default Citizen;
