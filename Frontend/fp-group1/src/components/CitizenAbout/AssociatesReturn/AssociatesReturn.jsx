import "./AssociatesReturn.css";
import { Card, Accordion } from "react-bootstrap";
import Table from "react-bootstrap/Table";

const AssociatesReturn = ({
    businessName, businessAddress, collegues, livingWith
}) => {

    const DisplayBasicWork = ({ businessAddress, businessName }) => {
        return (
            <>
                Business Name: {businessName}
                <br/>
                Business Address: {businessAddress}
            </>
        )
    }

    const ListLivingWith = ({ forenames, surname, dateOfBirth }) => {
        return (
            <tr>
                <td>{forenames}</td>
                <td>{surname}</td>
                <td>{dateOfBirth}</td>
            </tr>
        )
    }

    const ListWorkingWith = ({ personName, dateOfBirth }) => {
        return (
            <tr>
                <td>{personName}</td>
                <td>{dateOfBirth}</td>
            </tr>
        )
    }

    return (
        <Card className="assReturn">
            <Card.Header className="assReturnTitle">Associates</Card.Header>
            <Card.Body className="assReturnBody">
                <Card.Text className="assReturnText">
                    <Accordion>
                        <Accordion.Item eventKey="0">
                            <Accordion.Header>Living With</Accordion.Header>
                            <Accordion.Body>
                                <Table className="livingWithTable">
                                    <thead>
                                        <tr>
                                            <th>Forenames</th>
                                            <th>Surname</th>
                                            <th>Date of Birth</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        {livingWith.map(person =>
                                        <ListLivingWith
                                        key={`${livingWith.dateOfBirth} : ${livingWith.forenames}`}
                                        {...person}/>
                                        )}
                                    </tbody>
                                </Table>
                            </Accordion.Body>
                        </Accordion.Item>
                        <Accordion.Item eventKey="1">
                            <Accordion.Header>Works with</Accordion.Header>
                            <Accordion.Body>
                                <Card className="workWithReturn">
                                    <Card.Header className="workWithTitle">
                                        <DisplayBasicWork
                                        businessAddress={businessAddress}
                                        businessName={businessName}/>
                                    </Card.Header>
                                    <Card.Body className="workWithBody">
                                        <Table className="workWithTable">
                                            <thead>
                                                <tr>
                                                    <th>Name</th>
                                                    <th>Date of Birth</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                {collegues.map(person =>
                                                <ListWorkingWith
                                                key={`${collegues.dateOfBirth} : ${collegues.Name}`}
                                                {...person}/>
                                                )}
                                            </tbody>
                                        </Table>
                                    </Card.Body>
                                </Card>
                            </Accordion.Body>
                        </Accordion.Item>
                    </Accordion>
                </Card.Text>
            </Card.Body>
        </Card>
    );
};

export default AssociatesReturn;
