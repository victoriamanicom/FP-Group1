import Table from 'react-bootstrap/Table';
import "./EPOSReturn.css";

const EPOSReturn = ({eposRecords}) => {

    const ListEPOS = ({timestamp, amount, vendor, streetName}) => {
        return (
            <tr>
                <td>{timestamp}</td>
                <td>{amount}</td>
                <td>{vendor}</td>
                <td>{streetName}</td>
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
                </tr>
            </thead>
            <tbody>
                {eposRecords.map(eposRecord =>
                <ListEPOS key={eposRecord.timestamp} {...eposRecord} />
                )}
            </tbody>
        </Table>
    )
}

export default EPOSReturn;