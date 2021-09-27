import "./AssociatesReturn.css";
import { Card, Accordion } from "react-bootstrap";

const AssociatesReturn = ({associatesData}) => {

    return (
        <Card className="assReturn">
            <Card.Header className="assReturnTitle">Associates</Card.Header>
            <Card.Body className="assReturnBody">
                <Card.Text className="assReturnText">
                    <Accordion>
                        <Accordion.Item eventKey="0">
                            <Accordion.Header>Living With</Accordion.Header>
                            <Accordion.Body>
                                People this citizen lives with
                            </Accordion.Body>
                        </Accordion.Item>
                        <Accordion.Item eventKey="1">
                            <Accordion.Header>Works with</Accordion.Header>
                            <Accordion.Body>
                                People this citizen works with
                            </Accordion.Body>
                        </Accordion.Item>
                        <Accordion.Item eventKey="2">
                            <Accordion.Header>Calls?</Accordion.Header>
                            <Accordion.Body>
                                People this citizen has called{" "}
                            </Accordion.Body>
                        </Accordion.Item>
                    </Accordion>
                </Card.Text>
            </Card.Body>
        </Card>
    );
};

export default AssociatesReturn;
