import Table from "react-bootstrap/Table";
import "./ATMReturn.css";

const ATMReturn = ({ atmtransaction }) => {
    const ListATM = ({ timestamp, amount, operator, streetName, postcode }) => {
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
                <td>{operator}</td>
                <td>{streetName}</td>
                <td>{postcode}</td>
            </tr>
        );
    };

    return (
        <Table className="atmReturnTable">
            <thead>
                <tr>
                    <th>Date</th>
                    <th>Time</th>
                    <th>Amount</th>
                    <th>Operator</th>
                    <th>Street Name</th>
                    <th>Postcode</th>
                </tr>
            </thead>
            <tbody>
                {atmtransaction.map((atmTransaction) => (
                    <ListATM
                        key={atmtransaction.timestamp}
                        {...atmTransaction}
                    />
                ))}
            </tbody>
        </Table>
    );
};

export default ATMReturn;
