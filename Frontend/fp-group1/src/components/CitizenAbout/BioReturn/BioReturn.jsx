import { Card } from "react-bootstrap";
import "./BioReturn.css";

const BioReturn = () => {
    const citizenBio = {
        forename: "Hary",
        surname: "Hill",
        sex: "Male",
        dob: "12/13/14",
        homeAddress: "12 Hill Hill, Hillsfod, HI12 6HA",
        drivingLicenceNo: "98973965",
        phoneNo: "98563964",
        passportNo: "3457304957",
        nationality: "Doiche",
        businessName: "Comedian Store",
        businessAddress: "67 Work Road, Worksfod, WO5 FO8",
    };

    const DisplayBio = ({ citizenBio }) => {
        return (
            <>
                forename: {citizenBio.forename}
                <br />
                surname: {citizenBio.surname}
                <br />
                sex: {citizenBio.sex}
                <br />
                dob: {citizenBio.dob}
                <br />
                homeAddress: {citizenBio.homeAddress}
                <br />
                drivingLicenceNo: {citizenBio.drivingLicenceNo}
                <br />
                phoneNo: {citizenBio.phoneNo}
                <br />
                passportNo: {citizenBio.passportNo}
                <br />
                nationality: {citizenBio.nationality}
                <br />
                businessName: {citizenBio.businessName}
                <br />
                businessAddress: {citizenBio.businessAddress}
                <br />
            </>
        );
    };

    return (
        <Card className="bioReturn">
            <Card.Header className="bioReturnTitle">
                Bio Information
            </Card.Header>
            <Card.Body className="bioReturnBody">
                <Card.Text className="bioReturnText">
                    <DisplayBio
                        className="bioReturnBasic"
                        citizenBio={citizenBio}
                    />
                </Card.Text>
            </Card.Body>
        </Card>
    );
};

export default BioReturn;
