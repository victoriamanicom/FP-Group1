import "./BankCardReturn.css";
import { Card } from "react-bootstrap";
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import EPOSReturn from "./EPOSReturn";
import ATMReturn from "./ATMReturn";

const BankCardReturn = ({ bankCardsDTO}) => {

    const DisplayBankCard = ({
        cardNumber, sortCode, eposTransactions, atmTransactions
    }) => {
        return (
            <Card className="bankCardReturn">
                <Card.Header className="cardTitle">
                    Bank Card Number: {cardNumber}
                    <br/>
                    Sort Code: {sortCode}
                </Card.Header>
            <Row>
            <Col>
                <Card className="eposReturn">
                    <Card.Header className="eposTitle">
                        EPOS Records
                    </Card.Header>
                    <Card.Body className="eposBody">
                        <EPOSReturn eposTransactions={eposTransactions} />
                    </Card.Body>
                </Card>
                </Col>
                <Col>
                <Card className="atmReturn">
                    <Card.Header className="atmTitle">
                        ATM Records
                    </Card.Header>
                    <Card.Body className="atmBody">
                        <ATMReturn atmTransactions={atmTransactions} />
                    </Card.Body>
                </Card>
            </Col>
            </Row>
            </Card>
        )
    }
    console.log("BankCardReturn:")
    console.log(bankCardsDTO)
    return (
        <>
            {bankCardsDTO.map(bankCard =>
            <DisplayBankCard key={bankCardsDTO.cardNumber} {...bankCard}/>
            )}
        </>
    )
}

export default BankCardReturn;