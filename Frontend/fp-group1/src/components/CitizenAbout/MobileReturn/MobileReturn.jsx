import { Card } from "react-bootstrap"
import CallRecordsReturn from "./CallRecordsReturn"
import "./MobileReturn.css";

//{mobileData: {phoneNumber, network},
//    callRecords: {timestamp, callRecieve, assForenames, assSurname}}
const MobileReturn = ({mobileData}) => {

    const DisplayBasicPhone = ({mobileData}) => {
        return(
        <>
            Phone Number: {mobileData.phoneNum}
            <br/>
            Network: {mobileData.network}
            <br/>
        </>
        )
    }

    return (
        <Card className="mobileReturn">
            <Card.Header className="mobileReturnTitle">Mobile Information</Card.Header>
            <Card.Body className="mobileReturnBody">
                <Card.Text className="mobileReturnText">
                    <DisplayBasicPhone className="mobileReturnBasic"
                    mobileData={mobileData}/>
                </Card.Text>
                <CallRecordsReturn callData={mobileData.callData} />
            </Card.Body>
        </Card>
    )
}

export default MobileReturn;