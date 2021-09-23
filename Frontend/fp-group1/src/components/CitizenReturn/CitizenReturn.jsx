import "./CitizenReturn.css";
import Citizen from "./Citizen";
import Container from 'react-bootstrap/Container';
import { useHistory } from "react-router-dom";


const CitizenReturn = () => {
    const { push } = useHistory();

    const citizens = [{
        firstName: "First Name",
        lastName: "Last Name 1 ",
        dob: "DD/MM/YYYY",
        sex: "Male",
        Address: "5 Street Name"
    },{
        firstName: "First Name",
        lastName: "Last Name 2 ",
        dob: "DD/MM/YYYY",
        sex: "Male",
        Address: "6 Street Name"
    },{
        firstName: "First Name",
        lastName: "Last Name 3 ",
        dob: "DD/MM/YYYY",
        sex: "Male",
        Address: "7 Street Name"
    },{
        firstName: "First Name",
        lastName: "Last Name 4 ",
        dob: "DD/MM/YYYY",
        sex: "Male",
        Address: "7 Street Name"
    },{
        firstName: "First Name",
        lastName: "Last Name 5",
        dob: "DD/MM/YYYY",
        sex: "Male",
        Address: "7 Street Name"
    }
]

const selectCitizen = (lastName) => {
    push(`/about/${lastName}`);
}

    return (
        
            <div className="citizenList">
                <Container>
                    {citizens.map(citizen => <Citizen {...citizen} selectCitizen={selectCitizen} />)}
                    
                </Container>
            </div>
        
    );
}

export default CitizenReturn;