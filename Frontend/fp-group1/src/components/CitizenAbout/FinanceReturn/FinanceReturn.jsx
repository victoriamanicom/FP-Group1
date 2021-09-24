import "./FinanceReturn.css";
import { Card } from "react-bootstrap";
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import EPOSReturn from "./EPOSReturn";
import ATMReturn from "./ATMReturn";

const FinanceReturn = ({ citizens }) => {
    const financeData = {
        bank: "HSBC",
        accountNumber: "8967860876",
    };

    const eposRecords = [
        {
            timestamp: "1",
            amount: "£3.99",
            vendor: "Tesco",
            streetName: "Barton Avenue",
        },
        {
            timestamp: "2",
            amount: "£99.59",
            vendor: "John Lewis",
            streetName: "Barton Avenue",
        },
    ];

    const atmRecords = [
        {
            timestamp: "1",
            amount: "£100",
            streetName: "Highgate Lane",
        },
        {
            timestamp: "5",
            amount: "£25",
            streetName: "Town Center",
        },
    ];

    const DisplayBasicFinance = ({ financeData }) => {
        return (
            <>
                Bank: {financeData.bank}
                <br />
                Account Number: {financeData.accountNumber}
                <br />
            </>
        );
    };

    return (
        <Card className="financeReturn">
            <Card.Header className="financeReturnTitle">
                <Card.Title className="financeReturnTitle">
                    Financial Information
                </Card.Title>
            </Card.Header>
            <Card.Body className="financeReturnBody">
                <Card.Text className="financeReturnText">
                    <DisplayBasicFinance
                        className="financeReturnBasic"
                        financeData={financeData}
                    />
                </Card.Text>

                <Row>
                    <Col>
                        <Card className="eposReturn">
                            <Card.Header className="eposTitle">
                                EPOS Records
                            </Card.Header>
                            <Card.Body className="eposBody">
                                <EPOSReturn eposRecords={eposRecords} />
                            </Card.Body>
                        </Card>
                    </Col>
                    <Col>
                        <Card className="atmReturn">
                            <Card.Header className="atmTitle">
                                ATM Records
                            </Card.Header>
                            <Card.Body className="atmBody">
                                <ATMReturn atmRecords={atmRecords} />
                            </Card.Body>
                        </Card>
                    </Col>
                </Row>
            </Card.Body>
        </Card>
    );
};

export default FinanceReturn;
