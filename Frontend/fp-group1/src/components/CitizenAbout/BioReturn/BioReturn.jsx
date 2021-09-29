import { Card, Row, Col } from "react-bootstrap";
import "./BioReturn.css";

const BioReturn = ({
    citizenReturnDTO, driverLicenceId, phoneNumber, associatesDTO
    }) => {

    const addressString = citizenReturnDTO.homeAddress;
    const newAddress = addressString.split(",");
    const addressObject = {
        streetName: newAddress[0],
        town: newAddress[1],
        postcode: newAddress[2],
    };

    const DisplayBio = ({
        citizenReturnDTO, addressObject, driverLicenceId, phoneNumber, associatesDTO
        }) => {
        return (
            <>
                <Row className="citizenInformation">
                    <Col className="citizenBasicInformation" xs={4}>
                        <p>Forename: {citizenReturnDTO.forenames}</p>
                        <p>Surname: {citizenReturnDTO.surname}</p>
                        <p>Sex: {citizenReturnDTO.sex}</p>
                        <p>D.O.B: {citizenReturnDTO.dateOfBirth}</p>
                        <p> Place of Birth: {citizenReturnDTO.placeOfBirth}</p>
                        {/* <p>Nationality: {citizenReturnDTO.nationality}</p>
                        <p>Passport Number: {citizenReturnDTO.passportNo}</p> 
                        no data return for this information*/}
                        <p>
                            Driving Licence Number:{" "}
                            {driverLicenceId}
                        </p>
                    </Col>
                    <Col>
                        <Row className="contactInformation">
                            <h4>Contact Information:</h4>
                            <p>
                                Home Address: {addressObject.streetName},
                                {addressObject.town}
                            </p>

                            <p>Postcode: {addressObject.postcode}</p>
                            <p>Mobile Number: {phoneNumber}</p>
                        </Row>
                        <Row className="employmentInformation">
                            <h4>Employment Information:</h4>
                            <p>
                                Place of Employment: {associatesDTO.businessName}
                            </p>
                            <p>
                                Address of Employment:{" "}
                                {associatesDTO.businessAddress}
                            </p>
                        </Row>
                    </Col>
                </Row>
            </>
        );
    };

    return (
        <Card className="bioReturn">
            <Card.Header className="bioReturnTitle">
                Citizen Information
            </Card.Header>
            <Card.Body className="bioReturnBody">
                <Card.Text className="bioReturnText">
                    <DisplayBio
                        className="bioReturnBasic"
                        citizenReturnDTO={citizenReturnDTO}
                        addressObject={addressObject}
                        driverLicenceId={driverLicenceId}
                        phoneNumber={phoneNumber}
                        associatesDTO={associatesDTO}
                    />
                </Card.Text>
            </Card.Body>
        </Card>
    );
};

export default BioReturn;
