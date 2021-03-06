import Table from "react-bootstrap/Table";
import Col from "react-bootstrap/Col";
import Row from "react-bootstrap/Row";
import { Card } from "react-bootstrap";
import "./CallRecordsReturn.css";

const CallRecordsReturn = ({ mobileCallRecords, mobileReceiveRecords }) => {
    const ListCallRecords = ({ timestamp, receiverMSISDN, receiverName }) => {
        const splitTimestampFromDate = timestamp.split(" ");
        console.log(splitTimestampFromDate);
        const splitTimestamp = splitTimestampFromDate[1].split(":");
        console.log(splitTimestamp);
        return (
            <tr>
                <td>{splitTimestampFromDate[0]}</td>
                <td>
                    {splitTimestamp[0]}:{splitTimestamp[1]}
                </td>
                <td>{receiverMSISDN}</td>
                <td>{receiverName}</td>
            </tr>
        );
    };

    const ListRecieveRecords = ({ timestamp, callerMSISDN, callerName }) => {
        const splitTimestampFromDate = timestamp.split(" ");
        console.log(splitTimestampFromDate);
        const splitTimestamp = splitTimestampFromDate[1].split(":");
        console.log(splitTimestamp);
        return (
            <tr>
                <td>{splitTimestampFromDate[0]}</td>
                <td>
                    {splitTimestamp[0]}:{splitTimestamp[1]}
                </td>
                <td>{callerMSISDN}</td>
                <td>{callerName}</td>
            </tr>
        );
    };

    return (
        <Row>
            <Col>
                <Card className="callsReturn">
                    <Card.Header className="callsTitle">
                        Outgoing Calls
                    </Card.Header>
                    <Card.Body className="callBody">
                        <Table className="callTable">
                            <thead>
                                <tr>
                                    <th>Date</th>
                                    <th>Time</th>
                                    <th>Phone Number</th>
                                    <th>Name</th>
                                </tr>
                            </thead>
                            <tbody>
                                {mobileCallRecords.map((called) => (
                                    <ListCallRecords
                                        key={mobileCallRecords.timestamp}
                                        {...called}
                                    />
                                ))}
                            </tbody>
                        </Table>
                    </Card.Body>
                </Card>
            </Col>
            <Col>
                <Card className="recieveReturn">
                    <Card.Header className="recieveTitle">
                        Incoming Calls
                    </Card.Header>
                    <Card.Body className="recieveBody">
                        <Table className="recieveTable">
                            <thead>
                                <tr>
                                    <th>Date</th>
                                    <th>Time</th>
                                    <th>Phone Number</th>
                                    <th>Name</th>
                                </tr>
                            </thead>
                            <tbody>
                                {mobileReceiveRecords.map((recieved) => (
                                    <ListRecieveRecords
                                        key={mobileReceiveRecords.timestamp}
                                        {...recieved}
                                    />
                                ))}
                            </tbody>
                        </Table>
                    </Card.Body>
                </Card>
            </Col>
        </Row>
    );
};

export default CallRecordsReturn;
