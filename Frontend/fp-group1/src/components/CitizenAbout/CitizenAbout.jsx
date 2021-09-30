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
            .get(`http://54.72.172.119:5001/getSuspectInfo/4914442527`)
            .then(({ data }) => setCitizenData(data))
            .catch((err) => console.log(err));

        // setCitizenData({
        //     citizenID: "001L",
        //     associatesDTO: {
        //         businessName: "Comedian Store",
        //         businessAddress: "67 Work Road, Worksfod, WO5 FO8",
        //         collegues: [
        //             {
        //                 personName: "Steave Smith",
        //                 dateOfBirth: "31/08/1654"
        //             },{
        //                 personName: "Deseray Berch",
        //                 dateOfBirth: "03/02/1899"
        //             }
        //         ],
        //         livingWith: [
        //             {
        //                 forenames: "Dave John",
        //                 surname: "Banks",
        //                 dateOfBirth: "12/12/2012"
        //             },{
        //                 forenames: "Alice",
        //                 surname: "Rogers",
        //                 dateOfBirth: "25/10/1983"
        //             }
        //         ]
        //     },
        //     whereaboutsDTO: { data: "null" },
        //     vehiclesDTO: [
        //         {
        //             make: "Ford",
        //             model: "T",
        //             colour: "yello",
        //             vehicleRegistrationNo: "YO5 QT33",
        //             registrationDate: "19/03/1956",
        //             driverLicenceId: "896698ds"
        //         },{
        //             make: "Tesla",
        //             model: "S",
        //             colour: "silver",
        //             vehicleRegistrationNo: "UH45 J32",
        //             registrationDate: "21/07/2019",
        //             driverLicenceId: "896698ds"
        //         },
        //     ],
        //     peopleMobileDTO: [
        //         {
        //         phoneNumber: "08428 768234",
        //         network: "Norange",
        //         mobileCallRecords: [
        //             {
        //                 timestamp: "21/09/2021:23:21:44",
        //                 callerMSISDN: "08428 768234",
        //                 recieverMSISDN: "08432 678217",
        //                 callCellTowerId: "78628936593465",
        //                 recieverName: "Alice Rogers"
        //             }
        //         ],
        //         mobileReceiveRecords: [
        //             {
        //                 timestamp: "22/09/2021:09:14:56",
        //                 callerMSISDN: "08432 678217",
        //                 recieverMSISDN: "08428 768234",
        //                 callCellTowerId: "3427658098",
        //                 callerName: "Alice Rogers"
        //             }
        //         ]
        //         }
        //     ],
        //     citizenReturnDTO: {
        //         citizenID: "001L",
        //         forenames: "Hary",
        //         surname: "Hill",
        //         homeAddress: "12 Hill Hill, Hillsfod, HI12 6HA",
        //         dateOfBirth: "12/13/14",
        //         placeOfBirth: "London",
        //         sex: "Male",
        //     },
        //     peopleBankAccountDTO: [{
        //         forenames: "Hary",
        //         surname: "Hill",
        //         bank: "HSBC",
        //         accountNumber: "2938723",
        //         bankCardsDTO: [
        //             {
        //                 cardNumber: "98633945",
        //                 sortCode: "34-34-34",
        //                 eposTransactions: [
        //                     {
        //                         timestamp: "21/09/2021:13:28:59",
        //                         amount: "£3.99",
        //                         vendor: "Tesco",
        //                         streetName: "Barton Avenue",
        //                         postcode: "sei 986"
        //                     },{
        //                         timestamp: "21/09/2021:15:01:31",
        //                         amount: "£99.00",
        //                         vendor: "John Lewis",
        //                         streetName: "Barton Avenue",
        //                         postcode: "sei 452"
        //                     },
        //                 ],
        //                 atmTransactions: [
        //                     {
        //                         timestamp: "10/09/2021:10:54:26",
        //                         type: "withdraw",
        //                         amount: "£100",
        //                         operator: "Lloyds",
        //                         streetName: "Highgate Lane",
        //                         postcode: "sei 64"
        //                     },{
        //                         timestamp: "19/09/2021:21:41:53",
        //                         type: "withdraw",
        //                         amount: "£25",
        //                         operator: "HSBC",
        //                         streetName: "Town Center",
        //                         postcode: "sei 425"
        //                     }
        //                 ],
        //             }
        //         ],
        //     }],
        // });
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
                        <Route path="/:lastName/whereabouts">
                            <WhereaboutsReturn
                                businessAddress={
                                    citizenData.associatesDTO.businessAddress
                                }
                                homeAddress={
                                    citizenData.citizenReturnDTO.homeAddress
                                }
                                peopleBankAccountDTO={
                                    citizenData.peopleBankAccountDTO
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
