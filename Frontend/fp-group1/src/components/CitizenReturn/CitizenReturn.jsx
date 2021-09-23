import "./CitizenReturn.css";
import Citizen from "./Citizen";
import Container from "react-bootstrap/Container";
import { useHistory } from "react-router-dom";

const CitizenReturn = ({ citizens }) => {
    const { push } = useHistory();

    const selectCitizen = (lastName) => {
        push(`/${lastName}/about`);
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
