import "./App.css";
import Navbar from "react-bootstrap/NavBar";
import "material-icons/iconfont/material-icons.css";
import SearchBar from "./components/searchBar/SearchBar";
import { useState } from 'react';
import axios from 'axios';
import CitizenReturn from "./components/CitizenReturn/CitizenReturn";


function App() {

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
    <div className="App">
      <Navbar className="navbarHeader" sticky="top">
        <Navbar.Brand className="navbarTitle" href="">
          <span className="material-icons">privacy_tip</span>
          National Investigation Unit
        </Navbar.Brand>
      </Navbar>
      <SearchBar handleReset={handleReset} handleSearch={handleSearch}
      suspectForenames={suspectForenames} setSuspectForenames={setSuspectForenames}
      suspectSurname={suspectSurname} setSuspectSurname={setSuspectSurname}
      suspectGender={suspectGender} setSuspectGender={setSuspectGender}/>
      <CitizenReturn citizens={citizens}/>
    </div>
  );
}

export default App;
