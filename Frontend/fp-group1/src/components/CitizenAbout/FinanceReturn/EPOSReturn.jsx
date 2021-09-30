import Table from 'react-bootstrap/Table';
import "./EPOSReturn.css";

const EPOSReturn = ({eposTransactions}) => {

    const ListEPOS = ({timestamp, amount, vendor, streetName, postcode}) => {
        return (
            <tr>
                <td>{timestamp}</td>
                <td>{amount}</td>
                <td>{vendor}</td>
                <td>{streetName}</td>
                <td>{postcode}</td>
            </tr>
        )
    }
    return (
        <Table className="eposReturnTable">
            <thead>
                <tr>
                    <th>Timestamp</th>
                    <th>Amount</th>
                    <th>Vendor</th>
                    <th>Street Name</th>
                    <th>Postcode</th>
                </tr>
            </thead>
            <tbody>
                {eposTransactions.map(eposTransaction =>
                <ListEPOS key={eposTransactions.timestamp} {...eposTransaction} />
                )}
            </tbody>
        </Table>
    )
}

export default EPOSReturn;