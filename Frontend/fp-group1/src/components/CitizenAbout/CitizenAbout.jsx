import { Switch, Route, useParams, useHistory } from "react-router-dom";
import "./CitizenAbout.css";
import SideNavBar from "./sideNavBar/SideNavBar";
import Col from "react-bootstrap/Col";
import Row from "react-bootstrap/Row";
import FinanceReturn from "./FinanceReturn/FinanceReturn";
import MobileReturn from "./MobileReturn/MobileReturn";
import VehicleReturn from "./VehicleReturn/VehicleReturn";
import AssociatesReturn from "./AssociatesReturn/AssociatesReturn";
import WhereaboutsReturn from "./WhereaboutsReturn/WhereaboutsReturn";
import BioReturn from "./BioReturn/BioReturn";
import { useEffect, useState } from "react";
import axios from "axios";

const CitizenAbout = ({ citizenID }) => {
    const [citizenData, setCitizenData] = useState([1]);

    const { lastName } = useParams();
    const { push } = useHistory();

    const handleSelect = (eventKey) => {
        push(`/${lastName}${eventKey}`);
    };

    const handleGetCitizen = (citizenID) => {
        // axios
        // .get()
        // .then (({ data }) => setCitizenData(data))
        // .catch((err) => console.log(err));

        setCitizenData({
            citizenID: "001L",
            associatesData: { data: "null" },
            whereaboutsData: { data: "null" },
            vehicleData: [
                {
                    make: "Ford",
                    model: "T",
                    colour: "yello",
                    licencePlate: "YO5 QT33",
                    registrationDate: "19/03/1956",
                },
                {
                    make: "Tesla",
                    model: "S",
                    colour: "silver",
                    licencePlate: "UH45 J32",
                    registrationDate: "21/07/2019",
                },
            ],
            mobileData: {
                phoneNum: "08428 768234",
                network: "Norange",
                callData: [
                    {
                        timestamp: "21/09/2021:23:21:44",
                        callReceive: "Call",
                        phoneNum: "07323 578123",
                        forename: "Sam",
                        surname: "Smith",
                    },
                    {
                        timestamp: "22/09/2021:10:03:54",
                        callReceive: "Receive",
                        phoneNum: "07323 578123",
                        forename: "Sam",
                        surname: "Smith",
                    },
                ],
            },
            citizenBio: {
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
            },
            financialData: {
                bank: "HSBC",
                accountNum: "2938723",
                eposData: [
                    {
                        timestamp: "21/09/2021:13:28:59",
                        amount: "£3.99",
                        vendor: "Tesco",
                        streetName: "Barton Avenue",
                    },
                    {
                        timestamp: "21/09/2021:15:01:31",
                        amount: "£99.00",
                        vendor: "John Lewis",
                        streetName: "Barton Avenue",
                    },
                ],
                atmData: [
                    {
                        timestamp: "10/09/2021:10:54:26",
                        amount: "£100",
                        streetName: "Highgate Lane",
                    },
                    {
                        timestamp: "19/09/2021:21:41:53",
                        amount: "£25",
                        streetName: "Town Center",
                    },
                ],
            },
        });
    };

    if (citizenData == 1) {
        handleGetCitizen(citizenID);
    }

    console.log(`the data:`);
    console.log(citizenData);
    console.log(citizenData.citizenBio);
    return (
        <>
            <Row className="citizenInfoReturn">
                <Col xs={2}>
                    <SideNavBar
                        citizen={citizenData.citizenBio}
                        handleSelect={handleSelect}
                    />
                </Col>
                <Col className="citizenInfoComponents">
                    <Switch>
                        <Route exact path="/:lastName/about">
                            <BioReturn citizenBio={citizenData.citizenBio} />
                        </Route>
                        <Route path="/:lastName/finance">
                            <FinanceReturn
                                financialData={citizenData.financialData}
                            />
                        </Route>
                        <Route path="/:lastName/mobile">
                            <MobileReturn mobileData={citizenData.mobileData} />
                        </Route>
                        <Route path="/:lastName/vehicle">
                            <VehicleReturn
                                vehicleData={citizenData.vehicleData}
                            />
                        </Route>
                        <Route path="/:lastName/associates">
                            <AssociatesReturn
                                associatesData={citizenData.associatesData}
                            />
                        </Route>
                        <Route path="/:lastName/whereabouts">
                            <WhereaboutsReturn
                                whereaboutsData={citizenData.whereaboutsData}
                            />
                        </Route>
                    </Switch>
                </Col>
            </Row>
        </>
    );
};

export default CitizenAbout;
