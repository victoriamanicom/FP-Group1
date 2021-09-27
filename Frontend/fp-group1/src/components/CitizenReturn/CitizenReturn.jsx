import "./CitizenReturn.css";
import Citizen from "./Citizen";
import Container from "react-bootstrap/Container";
import { useHistory } from "react-router-dom";

const CitizenReturn = ({ citizens, setCitizenID }) => {
    const { push } = useHistory();

    const selectCitizen = (lastName, citizenID) => {
        push(`/${lastName}/about`);
        setCitizenID(citizenID);
    };

    return (
        <div className="citizenList">
            <Container>
                {citizens.map((citizen) => (
                    <Citizen {...citizen} selectCitizen={selectCitizen} />
                ))}
            </Container>
        </div>
    );
};

export default CitizenReturn;
