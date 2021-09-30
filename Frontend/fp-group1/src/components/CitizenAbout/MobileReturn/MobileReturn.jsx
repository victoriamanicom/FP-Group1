import { Card } from "react-bootstrap"
import CallRecordsReturn from "./CallRecordsReturn"
import "./MobileReturn.css";

const MobileReturn = ({ peopleMobileDTO }) => {

    const DisplayBasicPhone = ({ phoneNumber, network }) => {
        return(
        <>
            Phone Number: {phoneNumber}
            <br/>
            Network: {network}
        </>
        )
    }

    const DisplayMobile = ({
        phoneNumber, network, mobileCallRecords, mobileReceiveRecords
    }) => {
        return (
            <Card className="mobileReturn">
                <Card.Header className="mobileTitle">
                    <DisplayBasicPhone
                    phoneNumber={phoneNumber}
                    network={network}
                    />
                </Card.Header>
                <Card.Body className="mobileBody">
                    <CallRecordsReturn
                    mobileCallRecords={mobileCallRecords}
                    mobileReceiveRecords={mobileReceiveRecords}
                    />
                </Card.Body>
            </Card>
        )
    }

    return (
        <Card className="mobileRecordsReturn">
            <Card.Header className="mobileRecordsReturnTitle">
                Mobile Information
            </Card.Header>
            <Card.Body className="mobileRecordsReturnBody">
                {peopleMobileDTO.map(mobile =>
                <DisplayMobile key={peopleMobileDTO.phoneNumber} {...mobile}/>
                )}
            </Card.Body>
        </Card>
    )
}

export default MobileReturn;