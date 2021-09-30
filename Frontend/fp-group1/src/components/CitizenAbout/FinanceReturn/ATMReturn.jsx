import Table from 'react-bootstrap/Table';
import "./ATMReturn.css";

const ATMReturn = ({ atmtransaction }) => {

    const ListATM = ({
        timestamp, amount, operator, streetName, postcode
    }) => {
        return (
            <tr>
                <td>{timestamp}</td>
                <td>{amount}</td>
                <td>{operator}</td>
                <td>{streetName}</td>
                <td>{postcode}</td>
            </tr>
        )
    }

    return (
        <Table className="atmReturnTable">
            <thead>
                <tr>
                    <th>Timestamp</th>
                    <th>Amount</th>
                    <th>Operator</th>
                    <th>Street Name</th>
                    <th>Postcode</th>
                </tr>
            </thead>
            <tbody>
                {atmtransaction.map(atmTransaction =>
                <ListATM key={atmtransaction.timestamp} {...atmTransaction} />
                )}
            </tbody>
        </Table>
    )
}

export default ATMReturn;