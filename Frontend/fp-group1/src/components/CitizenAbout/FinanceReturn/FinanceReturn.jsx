import "./FinanceReturn.css";
import { Card } from "react-bootstrap";
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import EPOSReturn from "./EPOSReturn";
import ATMReturn from "./ATMReturn";

const FinanceReturn = ({financialData}) => {

    const DisplayBasicFinance = (financialData) => {
        return (
            <>
                Bank: {financialData.bank}
                <br />
                Account Number: {financialData.accountNum}
                <br />
            </>
        );
    };

    return (
        <Card className="financeReturn">
            <Card.Header className="financeReturnTitle">
                Financial Information
            </Card.Header>
            <Card.Body className="financeReturnBody">
                <Card.Text className="financeReturnText">
                    <DisplayBasicFinance
                        className="financeReturnBasic"
                        financialData={financialData}
                    />
                </Card.Text>

                <Row>
                    <Col>
                        <Card className="eposReturn">
                            <Card.Header className="eposTitle">
                                EPOS Records
                            </Card.Header>
                            <Card.Body className="eposBody">
                                <EPOSReturn eposData={financialData.eposData} />
                            </Card.Body>
                        </Card>
                    </Col>
                    <Col>
                        <Card className="atmReturn">
                            <Card.Header className="atmTitle">
                                ATM Records
                            </Card.Header>
                            <Card.Body className="atmBody">
                                <ATMReturn atmData={financialData.atmData} />
                            </Card.Body>
                        </Card>
                    </Col>
                </Row>
            </Card.Body>
        </Card>
    );
};

export default FinanceReturn;
