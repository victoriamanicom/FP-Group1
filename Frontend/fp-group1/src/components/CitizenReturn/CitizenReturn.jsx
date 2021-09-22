import "./CitizenReturn.css";
import Citizen from "./Citizen";
import Container from 'react-bootstrap/Container';


const CitizenReturn = () => {
    return (
        
            <div className="citizenList">
                <Container>
                    <Citizen />
                    <Citizen />
                    
                </Container>
            </div>
        
    );
}

export default CitizenReturn;