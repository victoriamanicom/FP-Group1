import Table from "react-bootstrap/Table";
import "./EPOSReturn.css";

const EPOSReturn = ({ epostransactions }) => {
    const ListEPOS = ({ timestamp, amount, vendor, streetName, postcode }) => {
        const splitTimestampFromDate = timestamp.split("T");
        console.log(splitTimestampFromDate);
        const splitTimestamp = splitTimestampFromDate[1].split(":");
        console.log(splitTimestamp);
        return (
            <tr>
                <td>{splitTimestampFromDate[0]}</td>
                <td>
                    {splitTimestamp[0]}:{splitTimestamp[1]}
                </td>
                <td>{amount}</td>
                <td>{vendor}</td>
                <td>{streetName}</td>
                <td>{postcode}</td>
            </tr>
        );
    };
    return (
        <Table className="eposReturnTable">
            <thead>
                <tr>
                    <th>Date</th>
                    <th>Time</th>
                    <th>Amount</th>
                    <th>Vendor</th>
                    <th>Street Name</th>
                    <th>Postcode</th>
                </tr>
            </thead>
            <tbody>
                {epostransactions.map((eposTransaction) => (
                    <ListEPOS
                        key={epostransactions.timestamp}
                        {...eposTransaction}
                    />
                ))}
            </tbody>
        </Table>
    );
};

export default EPOSReturn;
