import Table from 'react-bootstrap/Table';
import "./CallRecordsReturn.css";

const CallRecordsReturn = ({callData}) => {

    const ListCalls = ({timestamp, callRecieve, phoneNum, forename, surname}) => {
        return(
            <tr>
                <td>{timestamp}</td>
                <td>{callRecieve}</td>
                <td>{phoneNum}</td>
                <td>{forename}</td>
                <td>{surname}</td>
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
                {callData.map(callRecord =>
                <ListCalls key={callRecord.timestamp} {...callRecord} />
                )}
            </tbody>
        </Table>
    )
}

export default CallRecordsReturn;