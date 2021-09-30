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

    const FilterThroughAccounts = ({ bankCardDTOs }) => {
        return (
            <>
                {bankCardDTOs.map(card =>
                <FilterThroughCard key={bankCardDTOs.cardNumber}
                {...card}/>
                )}
            </>
        )
    }

    const FilterThroughCard = ({ epostransactions, atmtransaction}) => {
        return (
            <>
                <>
                    {epostransactions.map(location =>
                    <DisplayTransactionLocation key={epostransactions.timestamp}
                    {...location}/>
                    )}
                </>
                <>
                    {atmtransaction.map(location =>
                    <DisplayTransactionLocation key={atmtransaction.timestamp}
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
