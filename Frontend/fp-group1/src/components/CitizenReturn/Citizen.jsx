import "./Citizen.css";
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';
import Card from 'react-bootstrap/Card';

const Citizen = (citizen) => {
    return(
        <Row>
                        <Card>
                            <Card.Body>
                                <Card.Title><a href="">{citizen.firstName} {citizen.lastName} </a></Card.Title>
                                <Card.Text>
                                    <Row>
                                        <Col>
                                        <p>D.O.B: {citizen.dob} </p>
                                        <p>Gender: {citizen.sex} </p>
                                        </Col>
                                        <Col>
                                        <p>
                                            Address: {citizen.Address}
                                        </p>
                                        </Col>
                                    </Row>
                                </Card.Text>
                            </Card.Body>
                        </Card>
                    </Row>
    );
}

export default Citizen;