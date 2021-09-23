import "./App.css";
import Navbar from "react-bootstrap/NavBar";
import Nav from "react-bootstrap/Nav";
import "material-icons/iconfont/material-icons.css";
import SearchBar from "./components/searchBar/SearchBar";
import { useState } from 'react';
import axios from 'axios';
import CitizenReturn from "./components/CitizenReturn/CitizenReturn";
import MobileReturn from "./components/MobileReturn/MobileReturn";
import FinanceReturn from "./components/FinanceReturn/FinanceReturn";
import CitizenAbout from "./components/CitizenAbout/CitizenAbout";
import CitizenFinancial from "./components/CitizenAbout/CitizenFinancial/CitizenFinancial";
import { BrowserRouter as Router, Switch, Route } from "react-router-dom";

function App() {
    const citizens = [
        {
            firstName: "First Name",
            lastName: "Last Name 1 ",
            dob: "DD/MM/YYYY",
            sex: "Male",
            Address: "5 Street Name",
        },
        {
            firstName: "First Name",
            lastName: "Last Name 2 ",
            dob: "DD/MM/YYYY",
            sex: "Male",
            Address: "6 Street Name",
        },
        {
            firstName: "First Name",
            lastName: "Last Name 3 ",
            dob: "DD/MM/YYYY",
            sex: "Male",
            Address: "7 Street Name",
        },
        {
            firstName: "First Name",
            lastName: "Last Name 4 ",
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
  const [citizens, setCitizens] = useState([]);

  const handleReset = e => {
    setSuspectForenames("");
    setSuspectSurname("");
    setSuspectGender("");

  }

  const handleSearch = e => {
    e.preventDefault();
    axios
    .get()
    .then((result) => {
      setCitizens(result.data);
    })
    .catch(err => console.log(err));
  }
    return (
        <Router className="App">
            <Navbar className="navbarHeader" sticky="top">
                <Navbar.Brand className="navbarTitle" href="">
                    <span class="material-icons">privacy_tip</span>
                    National Investigation Unit
                </Navbar.Brand>
            </Navbar>
            <SearchBar handleReset={handleReset} handleSearch={handleSearch}
      suspectForenames={suspectForenames} setSuspectForenames={setSuspectForenames}
      suspectSurname={suspectSurname} setSuspectSurname={setSuspectSurname}
      suspectGender={suspectGender} setSuspectGender={setSuspectGender}/>

            <Switch>
                <Route exact path="/">
                    <CitizenReturn citizens={citizens} />
                </Route>
                <Route path="/about/:lastName">
                    <CitizenAbout citizens={citizens} />
                </Route>
                <Route path="/finance/:lastName">
                    <CitizenFinancial citizens={citizens} />
                </Route>
            </Switch>
        </Router>
    );
}

export default App;
