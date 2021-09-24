import { Card } from "react-bootstrap"
import CallRecordsReturn from "./CallRecordsReturn"
import "./MobileReturn.css";

//{mobileData: {phoneNumber, network},
//    callRecords: {timestamp, callRecieve, assForenames, assSurname}}
const MobileReturn = () => {

    const mobileData = {
        phoneNumber: "00000030",
        network: "Norange",
    }

    const callRecords = [{
            timestamp: "1",
            callRecieve: "Call",
            assPhoneNumer: "875875876",
            assForenames: "Sam",
            assSurname: "Smith"
        },{
            timestamp: "2",
            callRecieve: "Recieve",
            assPhoneNumber: "9836893",
            assForenames: "Sam",
            assSurname: "Smith"
        },{
            timestamp: "3",
            callRecieve: "Recieve",
            assPhoneNumber: "747647864",
            assForenames: "Yuri",
            assSurname: "Poster"
        }
    ]

    const DisplayBasicPhone = ({mobileData}) => {
        return(
        <>
            Phone Number: {mobileData.phoneNumber}
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
                <CallRecordsReturn callRecords={callRecords} />
            </Card.Body>
        </Card>
    )
}

export default MobileReturn;