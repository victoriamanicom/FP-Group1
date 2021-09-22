import "./Citizen.css";
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';
import Card from 'react-bootstrap/Card';

const Citizen = ({firstName, lastName, dob, sex, Address}) => {
    return(
        <Row>
                        <Card>
                            <Card.Body>
                                <Card.Title><a href="">{firstName} {lastName}</a></Card.Title>
                                <Card.Text>
                                    <Row >
                                        <Col xs={4}>
                                        <p>D.O.B: {dob}</p>
                                        <p>Gender: {sex}</p>
                                        </Col>
                                        <Col>
                                        <p>
                                            Address: {Address}
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