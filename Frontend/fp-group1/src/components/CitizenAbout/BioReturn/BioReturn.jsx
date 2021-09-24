import { Card, Row, Col } from "react-bootstrap";
import "./BioReturn.css";

const BioReturn = ({ citizenBio }) => {
    // const citizenBio = {
    //     forename: "Hary",
    //     surname: "Hill",
    //     sex: "Male",
    //     dob: "12/13/14",
    //     homeAddress: "12 Hill Hill, Hillsfod, HI12 6HA",
    //     drivingLicenceNo: "98973965",
    //     phoneNo: "98563964",
    //     passportNo: "3457304957",
    //     nationality: "Doiche",
    //     businessName: "Comedian Store",
    //     businessAddress: "67 Work Road, Worksfod, WO5 FO8",
    // };

    const addressString = citizenBio.homeAddress;
    const newAddress = addressString.split(",");
    const addressObject = {
        streetName: newAddress[0],
        town: newAddress[1],
        postcode: newAddress[2],
    };

    const DisplayBio = ({ citizenBio, streetName, town, postcode}) => {
        return (
            <>
                <Row className="citizenInformation">
                    <Col className="citizenBasicInformation" xs={4}>
                        <p>Forename: {citizenBio.forename}</p>
                        <p>Surname: {citizenBio.surname}</p>
                        <p>Sex: {citizenBio.sex}</p>
                        <p>D.O.B: {citizenBio.dob}</p>
                        <p>Nationality: {citizenBio.nationality}</p>
                        <p>Passport Number: {citizenBio.passportNo}</p>
                        <p>
                            Driving Licence Number:{" "}
                            {citizenBio.drivingLicenceNo}
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
                            <p>Mobile Number: {citizenBio.phoneNo}</p>
                        </Row>
                        <Row className="employmentInformation">
                            <h4>Employment Information:</h4>
                            <p>
                                Place of Employment: {citizenBio.businessName}
                            </p>
                            <p>
                                Address of Employment:{" "}
                                {citizenBio.businessAddress}
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
                        citizenBio={citizenBio}
                        address={addressObject}
                    />
                </Card.Text>
            </Card.Body>
        </Card>
    );
};

export default BioReturn;
