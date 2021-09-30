import "./WhereaboutsReturn.css";
import { Card } from "react-bootstrap";
import Table from 'react-bootstrap/Table';

const WhereaboutsReturn = ({
    businessAddress, homeAddress, peopleBankAccountDTO
}) => {

    const DisplayTransactionLocation = ({ timestamp, streetName, postcode }) => {
        return (
            <tr>
                <td>{timestamp}</td>
                <td>{streetName}</td>
                <td>{postcode}</td>
            </tr>
        )
    }

    const FilterThroughAccounts = ({ bankCardsDTO }) => {
        return (
            <>
                {bankCardsDTO.map(card =>
                <FilterThroughCard key={bankCardsDTO.cardNumber}
                {...card}/>
                )}
            </>
        )
    }

    const FilterThroughCard = ({ eposTransactions, atmTransactions}) => {
        return (
            <>
                <>
                    {eposTransactions.map(location =>
                    <DisplayTransactionLocation key={eposTransactions.timestamp}
                    {...location}/>
                    )}
                </>
                <>
                    {atmTransactions.map(location =>
                    <DisplayTransactionLocation key={atmTransactions.timestamp}
                    {...location}/>
                    )}
                </>
            </>
        )
    }

    return (
        <Card className="whereReturn">
            <Card.Header className="whereReturnTitle">
                Known Whereabouts
            </Card.Header>
            <Card.Body className="whereReturnBody">
                <Card.Text className="whereReturnText">
                    <p> Home Location: {homeAddress}</p>
                    <p> Work Location: {businessAddress}</p>
                </Card.Text>
                <Card className="transactionLocationReturn">
                    <Card.Header className="transactionLocationTitle">
                        Transaction Locations
                    </Card.Header>
                    <Card.Body className="transactionLocationBody">
                        <Table className="transactionLocationTable">
                            <thead>
                                <tr>
                                    <th>Timestamp</th>
                                    <th>Street Name</th>
                                    <th>Post Code</th>
                                </tr>
                            </thead>
                            <tbody>
                                {peopleBankAccountDTO.map(bankAccount =>
                                <FilterThroughAccounts key={peopleBankAccountDTO}
                                {...bankAccount}/>
                                )}
                            </tbody>
                        </Table>
                    </Card.Body>
                </Card>
            </Card.Body>
        </Card>
    );
};

export default WhereaboutsReturn;
