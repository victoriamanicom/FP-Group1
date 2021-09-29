import "./FinanceReturn.css";
import { Card } from "react-bootstrap";
import BankCardReturn from "./BankCardReturn";

const FinanceReturn = ({ peopleBankAccountDTO }) => {

    const DisplayBasicFinance = ({ bank, accountNumber }) => {
        return (
            <>
                Bank: {bank}
                <br />
                Account Number: {accountNumber}
                <br />
            </>
        );
    };

    const DisplayBankAccount = ({ bank, accountNumber, bankCardsDTO}) => {
        return(
        <Card className="bankAccountReturn">
            <Card.Header className="bankAccounttitle">
                <DisplayBasicFinance
                className="bankAccountBasic"
                bank={bank}
                accountNumber={accountNumber}
                />
            </Card.Header>
            <Card.Body className="bankAccountBody">
                <BankCardReturn bankCardsDTO={bankCardsDTO}/>
            </Card.Body>
        </Card>
        )
    }
    console.log("FinanceReturn:")
    console.log(peopleBankAccountDTO);
    
    return (
        <Card className="financeReturn">
            <Card.Header className="financeReturnTitle">
                Financial Information
            </Card.Header>
            <Card.Body className="finaceReturnBody">
                {peopleBankAccountDTO.map(bankAccount =>
                <DisplayBankAccount key={peopleBankAccountDTO.accountNumber} {...bankAccount}/>
                )}
            </Card.Body>
        </Card>
    );
};

export default FinanceReturn;
