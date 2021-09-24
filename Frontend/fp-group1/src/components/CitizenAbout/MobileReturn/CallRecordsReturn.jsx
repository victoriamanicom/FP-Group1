import Table from 'react-bootstrap/Table';
import "./CallRecordsReturn.css";

const CallRecordsReturn = ({callRecords}) => {

    const ListCalls = ({timestamp, callRecieve,assPhoneNumber, assForenames, assSurname}) => {
        return(
            <tr>
                <td>{timestamp}</td>
                <td>{callRecieve}</td>
                <td>{assPhoneNumber}</td>
                <td>{assForenames}</td>
                <td>{assSurname}</td>
            </tr>
        )
    }
    
    return (
        <Table className="callReturnTable">
            <thead>
                <tr>
                    <th>Timestamp</th>
                    <th>Call / Recieve</th>
                    <th>PhoneNumber</th>
                    <th>Forenames</th>
                    <th>Surname</th>
                </tr>
            </thead>
            <tbody>
                {callRecords.map(callRecord =>
                <ListCalls key={callRecord.timestamp} {...callRecord} />
                )}
            </tbody>
        </Table>
    )
}

export default CallRecordsReturn;