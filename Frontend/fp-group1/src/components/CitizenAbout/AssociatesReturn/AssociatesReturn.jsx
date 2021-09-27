import "./AssociatesReturn.css";
import { Card } from "react-bootstrap";

const AssociatesReturn = ({associatesData}) => {

    return (
        <Card className="assReturn">
            <Card.Header className="assReturnTitle">Associates</Card.Header>
            <Card.Body className="assReturnBody">
                <Card.Text className="assReturnText">
                    <p>Unknown Data: {associatesData.data}</p>
                </Card.Text>
            </Card.Body>
        </Card>
    );
};

export default AssociatesReturn;
