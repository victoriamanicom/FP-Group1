import "./App.css";
import Navbar from "react-bootstrap/NavBar";
import Nav from "react-bootstrap/Nav";
import { Container } from "react-bootstrap";
import "material-icons/iconfont/material-icons.css";
import SearchBar from "./components/searchBar/SearchBar";
import { useState, useEffect } from "react";

import axios from "axios";
import CitizenReturn from "./components/CitizenReturn/CitizenReturn";
import CitizenAbout from "./components/CitizenAbout/CitizenAbout";
import { BrowserRouter as Router, Switch, Route } from "react-router-dom";

function App() {
    const [citizenForenames, setCitizenForenames] = useState("");
    const [citizenSurname, setCitizenSurname] = useState("");
    const [citizenGender, setCitizenGender] = useState("");
    const [searchID, setSearchID] = useState("");
    const [citizens, setCitizens] = useState([]);
    const [isLoaded, setIsLoaded] = useState(false);

    const handleReset = (e) => {
        setCitizenForenames("");
        setCitizenSurname("");
        setCitizenGender("");
        setSearchID("");
        setCitizens([]);
    };

    const handleSearch = (e) => {
        e.preventDefault();

        const searchCitizen = {
            forenames: `${citizenForenames}`,
            surname: `${citizenSurname}`,
            sex: `${citizenGender}`,
        };

        axios
            .post("/api/findCitizens", searchCitizen)
            .then(({ data }) => setCitizens(data))
            .catch((err) => console.log(err));
    };

    useEffect(() => {
        setIsLoaded(true);
    }, [citizens]);

    return (
        <Router className="App">
            <Navbar className="navbarHeader" sticky="top">
                <Container>
                    <Navbar.Brand className="navbarTitle" href="">
                        <span className="material-icons">privacy_tip</span>
                        National Investigation Unit
                    </Navbar.Brand>
                    <Nav>
                        <Nav.Link href="/">
                            <span className="material-icons-round">home</span>
                        </Nav.Link>
                    </Nav>
                </Container>
            </Navbar>
            <SearchBar
                handleReset={handleReset}
                handleSearch={handleSearch}
                citizenForenames={citizenForenames}
                setCitizenForenames={setCitizenForenames}
                citizenSurname={citizenSurname}
                setCitizenSurname={setCitizenSurname}
                citizenGender={citizenGender}
                setCitizenGender={setCitizenGender}
            />

            <Switch>
                <Route exact path="/">
                    {isLoaded ? (
                        <CitizenReturn
                            citizens={citizens}
                            setSearchID={setSearchID}
                        />
                    ) : (
                        <></>
                    )}
                </Route>

                <Route path="/:searchID">
                    <CitizenAbout citizens={citizens} searchID={searchID} />
                </Route>
            </Switch>
        </Router>
    );
}

export default App;
