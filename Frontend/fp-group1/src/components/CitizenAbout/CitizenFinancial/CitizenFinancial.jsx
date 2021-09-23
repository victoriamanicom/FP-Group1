import SideNavBar from "../sideNavBar/SideNavBar";
import { useParams, useHistory } from "react-router-dom";

const CitizenFinancial = ({ citizens }) => {
    const { lastName } = useParams();
    const { push } = useHistory();
    const handleSelect = (eventKey) => {
        push(`/${eventKey}/${lastName}`);
    };
    return (
        <>
            <SideNavBar citizen={citizens[0]} handleSelect={handleSelect} />
            <h2>Citizen Financial</h2>
        </>
    );
};

export default CitizenFinancial;
