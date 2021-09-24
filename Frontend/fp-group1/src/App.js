import "./App.css";
import Navbar from "react-bootstrap/NavBar";
import Nav from "react-bootstrap/Nav";
import { Container } from "react-bootstrap";
import "material-icons/iconfont/material-icons.css";
import SearchBar from "./components/searchBar/SearchBar";
import { useState } from "react";
import axios from "axios";
import CitizenReturn from "./components/CitizenReturn/CitizenReturn";
import CitizenAbout from "./components/CitizenAbout/CitizenAbout";
import { BrowserRouter as Router, Switch, Route } from "react-router-dom";

function App() {
    const citizens = [
        {
            firstName: "First Name",
            lastName: "Last Name 1",
            dob: "DD/MM/YYYY",
            sex: "Male",
            Address: "5 Street Name",
        },
        {
            firstName: "First Name",
            lastName: "Last Name 2",
            dob: "DD/MM/YYYY",
            sex: "Male",
            Address: "6 Street Name",
        },
        {
            firstName: "First Name",
            lastName: "Last Name 3",
            dob: "DD/MM/YYYY",
            sex: "Male",
            Address: "7 Street Name",
        },
        {
            firstName: "First Name",
            lastName: "Last Name 4",
            dob: "DD/MM/YYYY",
            sex: "Male",
            Address: "7 Street Name",
        },
        {
            firstName: "First Name",
            lastName: "Last Name 5",
            dob: "DD/MM/YYYY",
            sex: "Male",
            Address: "7 Street Name",
        },
    ];
    const [suspectForenames, setSuspectForenames] = useState("");
    const [suspectSurname, setSuspectSurname] = useState("");
    const [suspectGender, setSuspectGender] = useState("");
    // const [citizens, setCitizens] = useState([]);

    const handleReset = (e) => {
        setSuspectForenames("");
        setSuspectSurname("");
        setSuspectGender("");
    };

    const handleSearch = (e) => {
        e.preventDefault();
        axios
            .get()
            .then((result) => {
                // setCitizens(result.data);
            })
            .catch((err) => console.log(err));
    };
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
                suspectForenames={suspectForenames}
                setSuspectForenames={setSuspectForenames}
                suspectSurname={suspectSurname}
                setSuspectSurname={setSuspectSurname}
                suspectGender={suspectGender}
                setSuspectGender={setSuspectGender}
            />

            <Switch>
                <Route exact path="/">
                    <CitizenReturn citizens={citizens} />
                </Route>
                <Route path="/:lastName">
                    <CitizenAbout citizens={citizens} />
                </Route>
                {/* <Route path="/finance/:lastName">
                    <FinanceReturn citizens={citizens} />
                </Route> */}
            </Switch>
        </Router>
    );
}

export default App;
