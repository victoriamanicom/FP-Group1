import "./AssociatesReturn.css";
import { Card } from "react-bootstrap";

const AssociatesReturn = () => {

    const associatesData = [{
        data: "unknown"
    }]

    const DisplayAssociates = ({associatesData}) => {
        return (
            <>
                Unknown Data: {associatesData.data}
            </>
        )
    }

    return (
        <Card className="assReturn">
        <Card.Header className="assReturnTitle">
            Associates
        </Card.Header>
        <Card.Body className="assReturnBody">
            <Card.Text className="assReturnText">
                <DisplayAssociates
                    className="assReturnBasic"
                    associatesData={associatesData}
                />
            </Card.Text>
        </Card.Body>
    </Card>
    )
}

export default AssociatesReturn;