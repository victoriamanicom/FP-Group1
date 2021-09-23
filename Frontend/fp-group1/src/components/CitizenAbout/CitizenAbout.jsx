import { useParams } from "react-router-dom";

const CitizenAbout = () => {
    const { lastName } = useParams();


    return(
        <>
        <h1>Citizen About</h1>
        <h2>{lastName}</h2>
        </>
    );
}

export default CitizenAbout;