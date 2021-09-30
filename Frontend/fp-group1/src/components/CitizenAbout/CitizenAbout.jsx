import { Switch, Route, useParams, useHistory } from "react-router-dom";
import "./CitizenAbout.css";
import SideNavBar from "./sideNavBar/SideNavBar";
import Col from "react-bootstrap/Col";
import Row from "react-bootstrap/Row";
import FinanceReturn from "./FinanceReturn/FinanceReturn";
import MobileReturn from "./MobileReturn/MobileReturn";
import VehicleReturn from "./VehicleReturn/VehicleReturn";
import AssociatesReturn from "./AssociatesReturn/AssociatesReturn";
import ReactLoading from "react-loading";
import BioReturn from "./BioReturn/BioReturn";
import { useEffect, useState } from "react";
import axios from "axios";

const CitizenAbout = ({ searchID }) => {
    const [isLoaded, setIsLoaded] = useState(false);

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

    const { citizenID } = useParams();
    const { push } = useHistory();

    const handleSelect = (eventKey) => {
        push(`/${citizenData.citizenID}${eventKey}`);
    };

    const handleGetCitizen = (searchID) => {
        axios
            .get(`http://54.72.172.119:5001/getSuspectInfo/${searchID}`)
            .then(({ data }) => setCitizenData(data))
            .catch((err) => console.log(err));
    };

    //initial render check
    // if (citizenData.citizenID == "0") {
    handleGetCitizen(searchID);
    // }

    if (citizenData.citizenID !== "0") {
        setIsLoaded(true);
    }
    // useEffect(() => {
    //     setIsLoaded(true);
    // }, [citizenData]);

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
                        <Route exact path="/:citizenID/about">
                            {isLoaded ? (
                                <BioReturn
                                    citizenReturnDTO={
                                        citizenData.citizenReturnDTO
                                    }
                                    driverLicenceId={
                                        citizenData.vehiclesDTO[0]
                                            .driverLicenceId
                                    }
                                    phoneNumber={
                                        citizenData.peopleMobileDTO[0]
                                            .phoneNumber
                                    }
                                    associatesDTO={citizenData.associatesDTO}
                                />
                            ) : (
                                <>
                                    <ReactLoading
                                        type={"spinningBubbles"}
                                        color="#364b69"
                                    />
                                </>
                            )}
                        </Route>
                        <Route path="/:citizenID/finance">
                            <FinanceReturn
                                peopleBankAccountDTO={
                                    citizenData.peopleBankAccountDTO
                                }
                            />
                        </Route>
                        <Route path="/:citizenID/mobile">
                            <MobileReturn
                                peopleMobileDTO={citizenData.peopleMobileDTO}
                            />
                        </Route>
                        <Route path="/:citizenID/vehicle">
                            <VehicleReturn
                                vehiclesDTO={citizenData.vehiclesDTO}
                            />
                        </Route>
                        <Route path="/:citizenID/associates">
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
