import "./Citizen.css";
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';
import Card from 'react-bootstrap/Card';

const Citizen = () => {
    return(
        <Row>
                        <Card>
                            <Card.Body>
                                <Card.Title>First Name, Last Name</Card.Title>
                                <Card.Text>
                                    <Row>
                                        <Col>
                                        <p>D.O.B: DD/MM/YYYY</p>
                                        <p>Gender: </p>
                                        </Col>
                                        <Col>
                                        <p>
                                            Address: <br />7 Street Name <br/>
                                            Town <br />
                                            Postcode
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