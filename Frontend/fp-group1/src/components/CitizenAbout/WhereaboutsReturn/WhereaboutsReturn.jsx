import "./WhereaboutsReturn.css";
import { Card } from "react-bootstrap";

const WhereaboutsReturn = () => {
    const whereaboutsData = [
        {
            data: "unknown",
        },
    ];

    return (
        <Card className="whereReturn">
            <Card.Header className="whereReturnTitle">Whereabouts</Card.Header>
            <Card.Body className="whereReturnBody">
                <Card.Text className="whereReturnText">
                    <p> Unknown Data: {whereaboutsData.data}</p>
                </Card.Text>
            </Card.Body>
        </Card>
    );
};

export default WhereaboutsReturn;
