import "./WhereaboutsReturn.css";
import { Card } from "react-bootstrap";

const WhereaboutsReturn = () => {

    const whereaboutsData = [{
        data: "unknown"
    }]

    const DisplayWhereabouts = ({whereaboutsData}) => {
        return (
            <>
                Unknown Data: {whereaboutsData.data}
            </>
        )
    }

    return (
        <Card className="whereReturn">
        <Card.Header className="whereReturnTitle">
            Whereabouts
        </Card.Header>
        <Card.Body className="whereReturnBody">
            <Card.Text className="whereReturnText">
                <DisplayAssociates
                    className="whereReturnBasic"
                    whereaboutsData={whereaboutsData}
                />
            </Card.Text>
        </Card.Body>
    </Card>
    )
}

export default WhereaboutsReturn;