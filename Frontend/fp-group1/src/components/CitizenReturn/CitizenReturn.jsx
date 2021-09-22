import "./CitizenReturn.css";
import Citizen from "./Citizen";
import Container from 'react-bootstrap/Container';


const CitizenReturn = ({citizens}) => {

//    const citizens = [{
//        firstName: "First Name",
//        lastName: "Last Name",
//        dob: "DD/MM/YYYY",
//        sex: "Male",
//        Address: "5 Street Name"
//    },{
//        firstName: "First Name",
//       lastName: "Last Name",
//        dob: "DD/MM/YYYY",
//        sex: "Male",
//        Address: "6 Street Name"
//    },{
//        firstName: "First Name",
//        lastName: "Last Name",
//        dob: "DD/MM/YYYY",
//        sex: "Male",
//        Address: "7 Street Name"
//    }
//]

    return (
        
            <div className="citizenList">
                <Container>
                    {citizens.map(citizen => <Citizen {...citizen} />)}
                    
                </Container>
            </div>
        
    );
}

export default CitizenReturn;