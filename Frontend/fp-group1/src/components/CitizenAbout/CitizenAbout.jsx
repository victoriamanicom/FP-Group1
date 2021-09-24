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

const CitizenAbout = ({ citizens }) => {
    const { lastName } = useParams();
    const { push } = useHistory();

    const handleSelect = (eventKey) => {
        push(`/${lastName}${eventKey}`);
    };

    return (
        <>
            <Row className="citizenInfoReturn">
                <Col xs={2}>
                    <SideNavBar
                        citizen={citizens[0]}
                        handleSelect={handleSelect}
                    />
                </Col>
                <Col className="citizenInfoComponents">
                    <Switch>
                        <Route exact path="/:lastName/about">
                            <BioReturn />
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
