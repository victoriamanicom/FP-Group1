import { Switch, Route, useParams, useHistory } from "react-router-dom";
import "./CitizenAbout.css";
import SideNavBar from "./sideNavBar/SideNavBar";
import Col from "react-bootstrap/Col";
import Row from "react-bootstrap/Row";
import FinanceReturn from "./FinanceReturn/FinanceReturn";
import MobileReturn from "./MobileReturn/MobileReturn";
import VehicleReturn from "./VehicleReturn/VehicleReturn";
import AssociatesReturn from "./AssociatesReturn/AssociatesReturn";

import BioReturn from "./BioReturn/BioReturn";
import { useEffect, useState } from "react";
import axios from "axios";

const CitizenAbout = ({ searchID }) => {
    const [citizenData, setCitizenData] = useState({
        citizenID: "0",
        associatesDTO: {
            businessName: "",
            businessAddress: "",
            collegues: [
                {
                    personName: "",
                    dateOfBirth: "",
                },
            ],
            livingWith: [
                {
                    forenames: "",
                    surname: "",
                    dateOfBirth: "",
                },
            ],
        },
        vehiclesDTO: [
            {
                make: "",
                model: "",
                colour: "",
                vehicleRegistrationNo: "",
                registrationDate: "",
                driverLicenceId: "",
            },
        ],
        peopleMobileDTO: [
            {
                phoneNumber: "",
                network: "",
                mobileCallRecords: [
                    {
                        timestamp: "",
                        callerMSISDN: "",
                        recieverMSISDN: "",
                        callCellTowerId: "",
                        recieverName: "",
                    },
                ],
                mobileReceiveRecords: [
                    {
                        timestamp: "",
                        callerMSISDN: "",
                        recieverMSISDN: "",
                        callCellTowerId: "",
                        callerName: "",
                    },
                ],
            },
        ],
        citizenReturnDTO: {
            citizenID: "",
            forenames: "y",
            surname: "",
            homeAddress: "",
            dateOfBirth: "",
            placeOfBirth: "",
            sex: "",
        },
        peopleBankAccountDTO: [
            {
                forenames: "",
                surname: "",
                bank: "",
                accountNumber: "",
                bankCardsDTO: [
                    {
                        cardNumber: "",
                        sortCode: "",
                        eposTransactions: [
                            {
                                timestamp: "",
                                amount: "",
                                vendor: "",
                                streetName: "",
                                postcode: "",
                            },
                        ],
                        atmTransactions: [
                            {
                                timestamp: "",
                                type: "",
                                amount: "",
                                operator: "",
                                streetName: "",
                                postcode: "",
                            },
                        ],
                    },
                ],
            },
        ],
    });

    const { lastName } = useParams();
    const { push } = useHistory();

    const handleSelect = (eventKey) => {
        push(`/${lastName}${eventKey}`);
    };

    const handleGetCitizen = (searchID) => {
        axios
            .get(`http://54.72.172.119:5001/getSuspectInfo/${searchID}`)
            .then(({ data }) => setCitizenData(data))
            .catch((err) => console.log(err));
    };

    //initial render check
    if (citizenData.citizenID == "0") {
        console.log("setting data");
        handleGetCitizen(searchID);
    }

    //development data structure check
    console.log(`data check:`);
    console.log(citizenData);

    return (
        <>
            <Row className="citizenInfoReturn">
                <Col xs={2}>
                    <SideNavBar
                        citizenReturnDTO={citizenData.citizenReturnDTO}
                        handleSelect={handleSelect}
                    />
                </Col>
                <Col className="citizenInfoComponents">
                    <Switch>
                        <Route exact path="/:lastName/about">
                            <BioReturn
                                citizenReturnDTO={citizenData.citizenReturnDTO}
                                driverLicenceId={
                                    citizenData.vehiclesDTO[0].driverLicenceId
                                }
                                phoneNumber={
                                    citizenData.peopleMobileDTO[0].phoneNumber
                                }
                                associatesDTO={citizenData.associatesDTO}
                            />
                        </Route>
                        <Route path="/:lastName/finance">
                            <FinanceReturn
                                peopleBankAccountDTO={
                                    citizenData.peopleBankAccountDTO
                                }
                            />
                        </Route>
                        <Route path="/:lastName/mobile">
                            <MobileReturn
                                peopleMobileDTO={citizenData.peopleMobileDTO}
                            />
                        </Route>
                        <Route path="/:lastName/vehicle">
                            <VehicleReturn
                                vehiclesDTO={citizenData.vehiclesDTO}
                            />
                        </Route>
                        <Route path="/:lastName/associates">
                            <AssociatesReturn
                                businessName={
                                    citizenData.associatesDTO.businessName
                                }
                                businessAddress={
                                    citizenData.associatesDTO.businessAddress
                                }
                                collegues={citizenData.associatesDTO.collegues}
                                livingWith={
                                    citizenData.associatesDTO.livingWith
                                }
                            />
                        </Route>
                    </Switch>
                </Col>
            </Row>
        </>
    );
};

export default CitizenAbout;
