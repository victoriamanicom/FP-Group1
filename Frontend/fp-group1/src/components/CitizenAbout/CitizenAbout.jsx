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

const CitizenAbout = ({suspectID}) => {

    const [suspectData, setSuspectData] = useState([1]);

    const { lastName } = useParams();
    const { push } = useHistory();

    const handleSelect = (eventKey) => {
        push(`/${lastName}${eventKey}`);
    };

    const handleGetSusepct = (suspectID) => {
        // axios
        // .get()
        // .then (({ data }) => setSuspectData(data))
        // .catch((err) => console.log(err));

        setSuspectData({
            citizenID: "001L",
            associatesData: {},
            whereaboutsData: {},
            vehicleData: {},
            mobileData: {},
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
                businessAddress: "67 Work Road, Worksfod, WO5 FO8"
            },
            financialData: {}
        })
    }

    if (suspectData == 1) {
        handleGetSusepct(suspectID);
    } else if (suspectData.citizenID !== suspectID) {
        handleGetSusepct(suspectID);
    }
    
    console.log(`the data:`);
    console.log(suspectData);
    return (
        <>
            <Row className="citizenInfoReturn">
                <Col xs={2}>
                    <SideNavBar
                        citizenBio={suspectData.citizenBio}
                        handleSelect={handleSelect}
                    />
                </Col>
                <Col className="citizenInfoComponents">
                    <Switch>
                        <Route exact path="/:lastName/about">
                            <BioReturn citizenBio={suspectData.citizenBio} />
                        </Route>
                        <Route path="/:lastName/finance">
                            <FinanceReturn />
                        </Route>
                        <Route path="/:lastName/mobile">
                            <MobileReturn />
                        </Route>
                        <Route path="/:lastName/vehicle">
                            <VehicleReturn />
                        </Route>
                        <Route path="/:lastName/associates">
                            <AssociatesReturn />
                        </Route>
                        <Route path="/:lastName/whereabouts">
                            <WhereaboutsReturn />
                        </Route>
                    </Switch>
                </Col>
            </Row>
        </>
    );
};

export default CitizenAbout;
