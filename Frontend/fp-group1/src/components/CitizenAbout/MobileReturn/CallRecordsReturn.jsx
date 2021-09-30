import Table from "react-bootstrap/Table";
import Col from "react-bootstrap/Col";
import Row from "react-bootstrap/Row";
import { Card } from "react-bootstrap";
import "./CallRecordsReturn.css";

const CallRecordsReturn = ({ mobileCallRecords, mobileReceiveRecords }) => {

    const ListCallRecords = ({ timestamp, receiverMSISDN, receiverName }) => {
        return(

            <tr>
                <td>{timestamp}</td>
                <td>{receiverMSISDN}</td>
                <td>{receiverName}</td>
            </tr>
        );
    };

    const ListRecieveRecords = ({ timestamp, callerMSISDN, callerName }) => {
        return (
            <tr>
                <td>{timestamp}</td>
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
                        Call Records
                    </Card.Header>
                    <Card.Body className="callBody">
                        <Table className="callTable">
                            <thead>
                                <tr>
                                    <th>Timestamp</th>
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
                        Recieve Records
                    </Card.Header>
                    <Card.Body className="recieveBody">
                        <Table className="recieveTable">
                            <thead>
                                <tr>
                                    <th>Timestamp</th>
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
