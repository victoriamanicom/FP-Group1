import "./CitizenReturn.css";
import Citizen from "./Citizen";
import Container from 'react-bootstrap/Container';


const CitizenReturn = () => {

    const citizen = {
        firstName: "Andrew",
        lastName: "Roy Slater",
        dob: "DD/MM/YYYY",
        sex: "Male",
        Address: "Street Name"
    }

    return (
        
            <div className="citizenList">
                <Container>
                    <Citizen {...citizen}/>
                    <Citizen />
                    
                </Container>
            </div>
        
    );
}

export default CitizenReturn;