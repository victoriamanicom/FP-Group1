import "./CitizenReturn.css";
import Citizen from "./Citizen";
import Container from 'react-bootstrap/Container';


const CitizenReturn = () => {

    const citizens = [{
        firstName: "First Name",
        lastName: "Last Name",
        dob: "DD/MM/YYYY",
        sex: "Male",
        Address: "Street Name"
    },{
        firstName: "First Name",
        lastName: "Last Name",
        dob: "DD/MM/YYYY",
        sex: "Male",
        Address: "Street Name"
    },{
        firstName: "First Name",
        lastName: "Last Name",
        dob: "DD/MM/YYYY",
        sex: "Male",
        Address: "Street Name"
    }
]

    return (
        
            <div className="citizenList">
                <Container>
                    {citizens.map(citizen => <Citizen {...citizen} />)}
                    
                </Container>
            </div>
        
    );
}

export default CitizenReturn;