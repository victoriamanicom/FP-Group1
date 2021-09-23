import Table from 'react-bootstrap/Table';
import "./ATMReturn.css";

const ATMReturn = ({atmRecords}) => {

    const ListATM = ({timestamp, amount, streetName}) => {
        return (
            <tr>
                <td>{timestamp}</td>
                <td>{amount}</td>
                <td>{streetName}</td>
            </tr>
        )
    }

    return (
        <Table className="atmReturnTable">
            <thead>
                <tr>
                    <th>Timestamp</th>
                    <th>Amount</th>
                    <th>Street Name</th>
                </tr>
            </thead>
            <tbody>
                {atmRecords.map(atmRecord =>
                <ListATM key={atmRecord.timestamp} {...atmRecord} />
                )}
            </tbody>
        </Table>
    )
}

export default ATMReturn;